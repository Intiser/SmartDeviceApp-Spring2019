package com.example.teacher.playstore.model;

import android.graphics.Bitmap;

import java.util.ArrayList;

public class Application {

    String name;
    Category category;
    Developer developer;
    Bitmap profileImage;
    ArrayList<Bitmap>previews;
    String Description;
    ArrayList<Review>reviews;

    public Application(String name, Category category, Developer developer, Bitmap profileImage, ArrayList<Bitmap> previews, String description, ArrayList<Review> reviews) {
        this.name = name;
        this.category = category;
        this.developer = developer;
        this.profileImage = profileImage;
        this.previews = previews;
        Description = description;
        this.reviews = reviews;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Developer getDeveloper() {
        return developer;
    }

    public void setDeveloper(Developer developer) {
        this.developer = developer;
    }

    public Bitmap getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(Bitmap profileImage) {
        this.profileImage = profileImage;
    }

    public ArrayList<Bitmap> getPreviews() {
        return previews;
    }

    public void setPreviews(ArrayList<Bitmap> previews) {
        this.previews = previews;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public ArrayList<Review> getReviews() {
        return reviews;
    }

    public void setReviews(ArrayList<Review> reviews) {
        this.reviews = reviews;
    }
}
