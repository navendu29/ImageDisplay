package com.example.navendu.displayimages;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by navendu on 25/2/18.
 */

public class ImageAdapter  extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder> {
    public ArrayList<Worldpopulation> mList;
    Context mContext;



    public ImageAdapter(ArrayList<Worldpopulation> arrayList, Context c) {
        this.mList = arrayList;
        this.mContext = c;
    }



    @Override
    public ImageAdapter.ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent, false);

        return new ImageViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ImageAdapter.ImageViewHolder holder, int position) {
        final Worldpopulation item = mList.get(position);
        holder.country.setText(item.getCountry());
        holder.rank.setText(item.getRank()+"");
        holder.population.setText(item.getPopulation());

        Resources resources = mContext.getResources();

   //     final int resourceId = resources.getIdentifier(item.getFlag(), "drawable",
     //           mContext.getPackageName());
        // Drawable toShow=  resources.getDrawable(resourceId);
       Picasso.with(mContext)
                .load(item.getFlag())
                .resize(300,300)
                .into(holder.flag);



        holder.flag.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent i=new Intent(mContext,Enlarge.class);
                i.putExtra("id",item.getFlag()+"");
                //i.putExtra("name", user.getUserFullName());
                mContext.startActivity(i);



            }
        });

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder {
        public TextView country,rank,population;
        public ImageView flag;

        public ImageViewHolder(View view) {
            super(view);
            country = (TextView)view.findViewById(R.id.t1);
            rank=(TextView) view.findViewById(R.id.t2);
            population=(TextView) view.findViewById(R.id.t3);

            flag=(ImageView) view.findViewById(R.id.t4);

        }
    }
}
