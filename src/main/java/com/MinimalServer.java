package com;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.server.handler.DefaultHandler;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;


/*
part 1/2 of the minimal server
 */


public class MinimalServer {

	public static void main(String[] args) throws Exception {
		// create new Server
		Server server = new Server(9999);

		//1.Creating resource for ui
		ResourceHandler resourceHandler= new ResourceHandler();
		resourceHandler.setResourceBase("ui");
		resourceHandler.setDirectoriesListed(true);
		ContextHandler contextHandler= new ContextHandler("/ui");
		contextHandler.setWelcomeFiles(new String[] { "index.html"});
		contextHandler.setHandler(resourceHandler);


		//2.Creating resource for Rest
		ResourceConfig config = new ResourceConfig();
		config.packages("com");
		ServletHolder servlet = new ServletHolder(new ServletContainer(config));
		ServletContextHandler servletContextHandler = new ServletContextHandler(server, "/*");
		servletContextHandler.addServlet(servlet, "/*");


		// adding both handles
		HandlerList handlers = new HandlerList();
		handlers.setHandlers(new Handler[] { contextHandler, servletContextHandler, new DefaultHandler() });
		server.setHandler(handlers);



		// Starting the com.MinimalServer
		server.start();
		System.out.println("Started!");
		server.join();
	}



}