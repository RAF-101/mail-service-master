package com.raf.emailservice.domain;

import com.raf.emailservice.EmailServiceApplication;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String name;
    private String text;
    private int parameters;

    public Tip() {
    }

    public Tip(String name, String text, int parameters) {
        this.name = name;
        this.text = text;
        this.parameters = parameters;
        EmailServiceApplication.tipovi.addTip(this);
    }

    public String buildMessage(String[] parameters){
        if(parameters.length != this.parameters) return null;
        String message = new String();
        message = text.toString();
        for(String parameter : parameters) {
            message = message.replaceFirst("%([a-zA-Z0-9])+", parameter);
        }
        return message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getParameters() {
        return parameters;
    }

    public void setParameters(int parameters) {
        this.parameters = parameters;
    }

    @Override
    public String toString() {
        return "Tip{" +
                "name='" + name + '\'' +
                ", text='" + text + '\'' +
                ", parameters=" + parameters +
                '}';
    }
}
