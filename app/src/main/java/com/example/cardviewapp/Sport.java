package com.example.cardviewapp;

//This will be the model class
public class Sport {

    private int sportImage;
    private String sportTitle, sportDescription;

    public Sport(int sportImage, String sportTitle, String sportDescription) {
        this.sportImage = sportImage;
        this.sportTitle = sportTitle;
        this.sportDescription = sportDescription;
    }


    public int getSportImage() {
        return sportImage;
    }

    public void setSportImage(int sportImage) {
        this.sportImage = sportImage;
    }

    public String getSportTitle() {
        return sportTitle;
    }

    public void setSportTitle(String sportTitle) {
        this.sportTitle = sportTitle;
    }

    public String getSportDescription() {
        return sportDescription;
    }

    public void setSportDescription(String sportDescription) {
        this.sportDescription = sportDescription;
    }
}
