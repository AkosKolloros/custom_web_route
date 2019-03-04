package com.codecool.site;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class Test {

    public static void main(String[] args) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);

        for (Method m : Routes.class.getMethods()) {
            Class<WebRoute> webRouteClass = WebRoute.class;
            if (m.isAnnotationPresent(webRouteClass)) {
                /*
                Here comes your logic.
                If the given path from the HttpExchange method is the SAME like the WebRoute annotation's path, you should INVOKE this method.
                */
                String route = m.getAnnotation(webRouteClass).value();

                if (route.equals("")) {
                    route = m.getAnnotation(webRouteClass).path();
                }

                System.out.println(route);

                String response = m.invoke(new Routes()).toString();

                server.createContext(route, new MyHandler(response));
            }
        }

        server.setExecutor(null); // creates a default executor
        server.start();
    }

    static class MyHandler implements HttpHandler {
        private String response;

        public void handle(HttpExchange t) throws IOException {
            t.sendResponseHeaders(200, response.length());
            OutputStream os = t.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }

        public MyHandler(String response) {
            this.response = response;
        }
    }
}