package com.example.mega_task.models;

import jakarta.validation.constraints.NotEmpty;

public class BookModel {
    private Long id;

    private Long ownerId;
    @NotEmpty(message = "This field shouldn't be nullable")
    private String title;

    private boolean isAvailable;

    public BookModel() {
    }

    public BookModel(Long ownerId, String title) {
        this.ownerId = ownerId;
        this.title = title;
    }

    public BookModel(String title) {
        this.title = title;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
