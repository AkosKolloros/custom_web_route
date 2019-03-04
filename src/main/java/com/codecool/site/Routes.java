package com.codecool.site;

import static com.codecool.site.RequestMethod.POST;

public class Routes {

    @WebRoute("/")
    public String index(){
        // Here goes the code to handle all requests going to localhost:8000/test1
        // and to return something
        return "Hello! This is the index";
    }

    @WebRoute("/test1")
    public String test1(){
        // Here goes the code to handle all requests going to localhost:8000/test1
        // and to return something
        return "This is my webpage";
    }

    @WebRoute("/test2")
    public String test2(){
        // Here goes the code to handle all requests going to localhost:8000/test2
        // and to return something
        return "This is also my webpage";
    }

    @WebRoute(method=POST, path = "/users")
    public String users() {
        // here goes the code to handle POST requests going to localhost:8000/users

        return "This is the users page";
    }
}
