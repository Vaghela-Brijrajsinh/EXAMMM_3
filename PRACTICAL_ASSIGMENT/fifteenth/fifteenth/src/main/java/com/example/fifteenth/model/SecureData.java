package com.example.fifteenth.model;

public class SecureData {

    private Integer id;

    private String text;

    // Default constructor
    public SecureData() {
    }

    // Parameterized constructor
    public SecureData(Integer id, String text) {
        this.id = id;
        this.text = text;
    }

    // Getter for ID
    public Integer getId() {
        return id;
    }

    // Setter for ID
    public void setId(Integer id) {
        this.id = id;
    }

    // Getter for text
    public String getText() {
        return text;
    }

    // Setter for text
    public void setText(String text) {
        this.text = text;
    }
}