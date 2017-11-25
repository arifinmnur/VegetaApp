package com.arifinmnur.VegetaApp;

/**
 * Created by ArieDZ_2 on 11/22/2017.
 */

public class SayurandanBuah {
    private String mNamaBuah, mDeskripsiBuah;

    private int mImage;

    public SayurandanBuah(String namaBuah, String deskripsiBuah, int image) {
        mNamaBuah = namaBuah;
        mDeskripsiBuah = deskripsiBuah;
        mImage = image;
    }

    public String getNamaBuah() {
        return mNamaBuah;
    }

    public void setNamaBuah(String mNamaBuah) {
        this.mNamaBuah = mNamaBuah;
    }

    public String getDeskripsiBuah() {
        return mDeskripsiBuah;
    }

    public void setDeskripsiBuah(String mDeskripsiBuah) {
        this.mDeskripsiBuah = mDeskripsiBuah;
    }

    public int getImage() {
        return mImage;
    }

    public void setImage(int mImage) {
        this.mImage = mImage;
    }



}
