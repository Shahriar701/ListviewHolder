package com.example.dragonsage.listviewholder;

/**
 * Created by DragonSage on 10/3/2017.
 */

public class Place {

    public String mNameOfPlace;
    public int mZipCode;
    public String mNameOfImage;
    public String mPopup;

    public Place(String startNameOfPlace, int startZipCode, String startNameOfImage, String startPopup) {

        this.mNameOfPlace = startNameOfPlace;
        this.mZipCode = startZipCode;
        this.mNameOfImage = startNameOfImage;
        this.mPopup = startPopup;

    }
}
