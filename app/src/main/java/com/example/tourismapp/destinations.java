package com.example.tourismapp;

public class destinations {
    private int image;
    private String location, description;

    public destinations(int id, int image, String location, String description) {
        this.image = image;
        this.location = location;
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
