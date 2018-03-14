package com.example.navendu.displayimages;

import retrofit2.http.GET;

/**
 * Created by navendu on 25/2/18.
 */

public interface ImageService {

    @GET("jsonparsetutorial.txt")
    rx.Observable<ImageDisplay> getImages();
//    Call<ImageDisplay> getImages();

}
