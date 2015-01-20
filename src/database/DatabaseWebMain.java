package database;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerCollection;
import org.eclipse.jetty.server.nio.SelectChannelConnector;

import com.j256.simplewebframework.displayer.StringResultDisplayer;
import com.j256.simplewebframework.handler.LoggingHandler;
import com.j256.simplewebframework.handler.ServiceHandler;

public class DatabaseWebMain {
	
	private static final int DEFAULT_WEB_PORT = 8080;

	public static void main(String[] args) throws Exception {
		// create jetty server
		Server server = new Server();
		// create the connector which receives HTTPD connections
		SelectChannelConnector connector = new SelectChannelConnector();
		// start it on the default port
		connector.setPort(DEFAULT_WEB_PORT);
		connector.setReuseAddress(true);
		server.addConnector(connector);

		
		StudentDatabaseWeb database = new StudentDatabaseWeb("Your School");
		
		// create a service handler
		ServiceHandler serviceHandler = new ServiceHandler();
		
		// register our service that handles requests from simple-web-framework
		serviceHandler.registerWebService(new HomeService(database));
		serviceHandler.registerWebService(new ModifyService(database));
		serviceHandler.registerWebService(new SearchService(database));
		serviceHandler.registerWebService(new ViewService(database));
		serviceHandler.registerWebService(new ExportService(database));
		
		// register a displayer of String results
		serviceHandler.registerResultDisplayer(new StringResultDisplayer());
		
		server.setHandler(serviceHandler);


		// server.setHandler(context);
		server.start();
	}

}
