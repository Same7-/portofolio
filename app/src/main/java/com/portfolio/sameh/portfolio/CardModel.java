package com.portfolio.sameh.portfolio;

/**
 * Created by sameh on 6/6/2015.
 */
public class CardModel {

    private String description;

    public CardModel(String description, int imageId) {
        this.description = description;
        this.imageId = imageId;
    }

    private int imageId;

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
