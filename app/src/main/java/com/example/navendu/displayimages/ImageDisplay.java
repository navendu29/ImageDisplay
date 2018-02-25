package com.example.navendu.displayimages;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by navendu on 25/2/18.
 */

public class ImageDisplay {

    @SerializedName("worldpopulation")
    @Expose
    private List<Worldpopulation> worldpopulation = null;

    public List<Worldpopulation> getWorldpopulation() {
        return worldpopulation;
    }

    public void setWorldpopulation(List<Worldpopulation> worldpopulation) {
        this.worldpopulation = worldpopulation;

    }

}