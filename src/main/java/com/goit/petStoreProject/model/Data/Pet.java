package com.goit.petStoreProject.model.Data;

import com.goit.petStoreProject.view.View;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

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

    public static Pet create(View view) {
        Pet pet = new Pet();
        view.write("input integer id for pet");
        long id = Long.valueOf(view.read());
        view.write("input name");
        String name = view.read();
        view.write("input url to photo url. left empty to end");
        List<String> photoUrls = new LinkedList<>();
        while (true) {
            String url = view.read();
            if (url.equals("")) {
                break;
            }
            photoUrls.add(url);
        }
        boolean isNotExit = true;
        view.write("input status");
        view.writeL("choose from:");

        String inputStatus = null;
        while (isNotExit) {
            Arrays.stream(PetStatus.values()).forEach(status -> {
                view.writeL('\t' + status.name().toLowerCase());
            });
            view.write("");
            inputStatus = view.read().toLowerCase();
            for (PetStatus status : PetStatus.values()) {
                if (inputStatus.equals(status.name().toLowerCase())) {
                    isNotExit = false;
                    break;
                }

            }
        }
        isNotExit = true;
        view.write("input Category:");
        view.write("input Category id");
        long categoryId = Long.valueOf(view.read());
        view.write("input category name");
        String categoryName = view.read();
        Category category = new Category(categoryId, categoryName);
        view.write("input tags. left id empty to end");
        List<Tag> tagList = new ArrayList<>();
        while (true) {
            view.write("input tag id");
            String tagId = view.read();
            if (tagId.equals("")) {
                break;
            }
            view.write("input tag name");
            String tagName = view.read();
            Tag tag = new Tag(Long.valueOf(tagId), tagName);
            tagList.add(tag);
        }
        pet.setId(id);
        pet.setName(name);
        pet.setPhotoUrl(photoUrls.toArray(new String[0]));
        pet.setCategory(category);
        pet.setStatus(inputStatus);
        pet.setTags(tagList.toArray(Tag[]::new));
        return pet;
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
