package com.goit.petStoreProject.model.Data;

import java.util.Arrays;

public class Pet {
    long id;
    Category category;
    String name;
    String[] photoUrl;
    Tag[] tags;
    String status;

    public Pet(long id, Category category, String name, String[] photoUrl, Tag[] tags, String status) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.photoUrl = photoUrl;
        this.tags = tags;
        this.status = status;
    }

    public Pet() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String[] photoUrl) {
        this.photoUrl = photoUrl;
    }

    public Tag[] getTags() {
        return tags;
    }

    public void setTags(Tag[] tags) {
        this.tags = tags;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ",\n \t" + category +
                ",\n \tname=\t'" + name + '\'' +
                ",\n \tPhotoUrl='" + photoUrl + '\'' +
                ",\n \n tags=" + Arrays.toString(tags) +
                ",\n status='" + status + '\'' +
                "\n";
    }
}
