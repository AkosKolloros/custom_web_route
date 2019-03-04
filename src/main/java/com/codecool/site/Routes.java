package com.codecool.site;

public class Routes {
    @WebRoute("/test1")
    public String test1(){
        // Here goes the code to handle all requests going to localhost:8000/test1
        // and to return something
        return "test1";
    }

    @WebRoute("/test2")
    public String test2(){
        // Here goes the code to handle all requests going to localhost:8000/test2
        // and to return something
        return "test2";
    }
}
