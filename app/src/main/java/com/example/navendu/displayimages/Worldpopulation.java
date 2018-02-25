package com.example.navendu.displayimages;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by navendu on 25/2/18.
 */

public class Worldpopulation {

    @SerializedName("rank")
    @Expose
    private Integer rank;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("population")
    @Expose
    private String population;
    @SerializedName("flag")
    @Expose
    private String flag;


    public Worldpopulation()
    {}

    public Worldpopulation(int r,String c,String p,String i){
        rank=r;
        country=c;
        population=p;
        flag=i;


    }


    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}
