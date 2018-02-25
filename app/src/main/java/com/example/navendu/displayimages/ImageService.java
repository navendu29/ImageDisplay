package com.example.navendu.displayimages;

import java.util.List;
import java.util.Observable;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observer;

/**
 * Created by navendu on 25/2/18.
 */

public interface ImageService {

    @GET("jsonparsetutorial.txt")
    Call<ImageDisplay> getImages();

}
