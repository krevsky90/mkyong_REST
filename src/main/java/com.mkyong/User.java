package com.mkyong;

import com.fasterxml.jackson.annotation.JsonProperty;

//POJO
public class User {
    private int id;
    private String name;

    public User() {
        //note! without default constructor jackson unable to create POJO from POST request (to create User)
    }

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
