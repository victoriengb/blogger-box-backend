package com.dauphine.blogger_box_backend.model;

import java.util.UUID;

public class Category {
    UUID id;
    String name;

    public Category(UUID id, String name){
        this.id = id;
        this.name = name;
    }

    public Category(){
        this.id = UUID.randomUUID();
        this.name = "";
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    
}
