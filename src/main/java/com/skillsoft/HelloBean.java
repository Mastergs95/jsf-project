package com.skillsoft;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

import java.io.Serializable;

@Named("HelloWorld")
@RequestScoped
public class HelloBean implements Serializable {

    private String message="Hello World!";

    public String getMessage(){
        System.out.println(message);
        return message;
    }

    public void setMessage(String message){
        this.message=message;
    }
}
