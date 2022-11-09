package org.example.generic.domain;


public abstract class Entity<I extends Identity> {

    private final I id;

    public Entity(I id){
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        return id.equals(obj);
    }

    public I entityId() {
        return id;
    }
}
