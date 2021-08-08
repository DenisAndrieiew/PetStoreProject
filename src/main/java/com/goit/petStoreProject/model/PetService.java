package com.goit.petStoreProject.model;

import com.goit.petStoreProject.model.Data.Category;
import com.goit.petStoreProject.model.Data.Pet;
import com.goit.petStoreProject.model.Data.PetStatus;
import com.goit.petStoreProject.model.Data.Tag;
import com.goit.petStoreProject.view.View;

import java.util.*;

public class PetService {

    public static Pet create(View view) {
        Pet pet = new Pet();
        view.write("input integer id for pet");
        long id = Long.valueOf(view.read());
        view.write("input name");
        String name = view.read();
        view.write("input url to photo url. left empty to end");
        List<String> photoUrls=new LinkedList<>();
        while (true){
            String url = view.read();
            if (url.equals("")){
                break;
            }
            photoUrls.add(url);
        }
        boolean isNotExit=true;
        view.write("input status");
        view.writeL("choose from:");

        String inputStatus=null;
        while (isNotExit) {
            Arrays.stream(PetStatus.values()).forEach(status->{
                view.writeL('\t'+ status.name().toLowerCase());
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
        isNotExit=true;
        view.write("input Category:");
        view.write("input Category id");
        long categoryId = Long.valueOf(view.read());
        view.write("input category name");
        String categoryName = view.read();
        Category category = new Category(categoryId, categoryName);
        view.write("input tags. left id empty to end");
        List<Tag> tagList = new ArrayList<>();
        while (true){
            view.write("input tag id");
            String tagId = view.read();
            if (tagId.equals("")){
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
}
