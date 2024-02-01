package com.SpringCourse.Section7.Recipe;

import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class Recipe {
    private int id;
    private String recipeName;
    @Size(max=100, message = "Description is to long")
    private String description;
    private LocalDate dateAdded;
    private String addedByUser;
    public Recipe(){}

    public Recipe(int id, String recipeName, String description, LocalDate dateAdded, String addedByUser) {
        this.id = id;
        this.recipeName = recipeName;
        this.description = description;
        this.dateAdded = dateAdded;
        this.addedByUser = addedByUser;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", recipeName='" + recipeName + '\'' +
                ", description='" + description + '\'' +
                ", dateAdded=" + dateAdded +
                ", addedByUser='" + addedByUser + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(LocalDate dateAdded) {
        this.dateAdded = dateAdded;
    }

    public String getAddedByUser() {
        return addedByUser;
    }

    public void setAddedByUser(String addedByUser) {
        this.addedByUser = addedByUser;
    }
}
