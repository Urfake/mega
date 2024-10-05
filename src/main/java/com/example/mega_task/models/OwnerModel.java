package com.example.mega_task.models;

import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public class OwnerModel {
    private Long id;

    @NotEmpty(message = "This field shouldn't be nullable")
    private String name;

    private List<BookModel> bookModels;

    public OwnerModel() {
    }

    public OwnerModel(String name, List<BookModel> bookModels) {
        this.name = name;
        this.bookModels = bookModels;
    }

    public OwnerModel(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<BookModel> getBookModels() {
        return bookModels;
    }

    public void setBookModels(List<BookModel> bookModels) {
        this.bookModels = bookModels;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
