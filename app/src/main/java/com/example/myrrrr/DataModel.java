package com.example.myrrrr;



import java.util.PrimitiveIterator;

public class DataModel {
    private String name;
    private String description;
    private int image;

    public DataModel(String name, String description, int image) {
        this.name = name;
        this.description = description;
        this.image = image;
    }
    public String getDescription() {return description;}

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}

