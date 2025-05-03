package com.dauphine.blogger_box_backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "category")

public class Category {
    @Id
    @Column(name = "id")
    UUID id;

    @Column(name = "name")
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
