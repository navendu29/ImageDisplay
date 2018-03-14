package com.example.navendu.displayimages;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.HttpException;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Observer;
import rx.Scheduler;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {



    private static final String TAG = MainActivity.class.getSimpleName();

    private Subscription subscription;



    private static final String BASE_URL = "http://www.androidbegin.com/tutorial/";

    private ImageService ImageService;

 ArrayList<Worldpopulation>ww;

    private RecyclerView recyclerView;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RxJavaCallAdapterFactory rxAdapter = RxJavaCallAdapterFactory.create();
            final Gson gson =
                    new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
            final Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson)).addCallAdapterFactory(rxAdapter)
                    .build();
            ImageService = retrofit.create(ImageService.class);

//            Call<ImageDisplay> call=  ImageService.getImages();
        Observable<ImageDisplay> call = ImageService.getImages();
         call
                .subscribeOn(Schedulers.io()) // optional if you do not wish to override the default behavior
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<ImageDisplay>() {
             @Override
             public void onCompleted() {

             }

             @Override
             public void onError(Throwable e) {

             }

             @Override
             public void onNext(ImageDisplay g) {



                 List<Worldpopulation>  hd=(ArrayList<Worldpopulation>) g.getWorldpopulation();


                 ww=new ArrayList<Worldpopulation>();
                 for(Worldpopulation k:hd)
                 {
                     ww.add(k);

                 }





                 recyclerView = findViewById(R.id.recycler_view);


                 recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL, false));

                 ImageAdapter studentsAdapter = new ImageAdapter(ww,getApplicationContext());
                 recyclerView.setAdapter(studentsAdapter);
             }
         });


//           call.enqueue(new Callback<ImageDisplay>() {
//                @Override
//                public void onResponse(Call<ImageDisplay> call, Response<ImageDisplay> response) {
//
//
//                   ImageDisplay g= response.body();
//
//
//           List<Worldpopulation>  hd=(ArrayList<Worldpopulation>) g.getWorldpopulation();
//
//
//           ww=new ArrayList<Worldpopulation>();
//           for(Worldpopulation k:hd)
//           {
//               ww.add(k);
//
//           }
//
//
//
//
//
//                    recyclerView = findViewById(R.id.recycler_view);
//
//
//                    recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL, false));
//
//                    ImageAdapter studentsAdapter = new ImageAdapter(ww,getApplicationContext());
//                    recyclerView.setAdapter(studentsAdapter);
//
//
//
//
//
//                }
//
//
//
//
//
//
//                @Override
//                public void onFailure(Call<ImageDisplay> call, Throwable t) {
//                    Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_SHORT).show();
//
//                }
//            });






    }


}
