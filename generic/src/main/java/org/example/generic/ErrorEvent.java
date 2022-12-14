package org.example.generic;


import org.example.generic.domain.DomainEvent;

public class ErrorEvent extends DomainEvent {
    private final String classType;
    private final String message;

    public ErrorEvent(String classType, String message){
        super("org.error");
        this.classType = classType;
        this.message = message;
    }

    public String getClassType() {
        return classType;
    }

    public String getMessage() {
        return message;
    }
}