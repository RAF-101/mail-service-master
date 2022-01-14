package com.raf.emailservice.dto;

public class TipDto {
    private String name;
    private String text;
    private int parameters;

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
        return "TipDto{" +
                "name='" + name + '\'' +
                ", text='" + text + '\'' +
                ", parameters=" + parameters +
                '}';
    }
}
