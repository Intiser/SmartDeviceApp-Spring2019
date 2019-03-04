package com.example.teacher.playstore.model;

public class Category {
    int type;
    String categoryName;
    String description;

    public Category(int type, String categoryName, String description) {
        this.type = type;
        this.categoryName = categoryName;
        this.description = description;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
