/*
 * 
 */
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.List;
import java.util.Map;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

// TODO: Auto-generated Javadoc
/**
 * The Class Server.
 */
public class Server {

    /**
     * Start server.
     *
     * @param filename the filename
     * @throws Exception the exception
     */
    public static void startServer(String filename) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        server.createContext("/"+filename, new MyHandler(filename));
        server.setExecutor(null); // creates a default executor
        System.out.println("Please visit http://localhost:8000/" + filename );
        server.start();
    }

    /**
     * The Class MyHandler.
     */
    static class MyHandler implements HttpHandler {
    	
	    /** The fname. */
	    String fname;
        
        /**
         * Instantiates a new my handler.
         *
         * @param filename the filename
         */
        public MyHandler(String filename) {
			// TODO Auto-generated constructor stub
        	this.fname = filename;
		}
		
		/* (non-Javadoc)
		 * @see com.sun.net.httpserver.HttpHandler#handle(com.sun.net.httpserver.HttpExchange)
		 */
		@Override
        public void handle(HttpExchange t) throws IOException {
            String response = "404 Not Found";
			try {
				System.out.println(fname);
				response = convertToJSON.convert(fname);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            t.sendResponseHeaders(200, response.length());
            OutputStream os = t.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }

}