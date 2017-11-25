package com.arifinmnur.VegetaApp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ArieDZ_2 on 11/22/2017.
 */

public class SayurandanBuahAdapter  extends RecyclerView.Adapter<SayurandanBuahAdapter.MyViewHolder> {
    public ArrayList<SayurandanBuah> sayurandanBuahs;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView namaBuah, descBuah;
        public ImageView images;

        public MyViewHolder(View view) {
            super(view);
            namaBuah = (TextView) view.findViewById(R.id.namabuah_textview_id);
            descBuah = (TextView) view.findViewById(R.id.deskripsiBuah_textview_id);
            images = (ImageView) view.findViewById(R.id.imagesRC);
        }
    }

    public SayurandanBuahAdapter(ArrayList<SayurandanBuah> sayurandanBuahs) {
        this.sayurandanBuahs = sayurandanBuahs;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycle_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        SayurandanBuah sayurandanBuah = sayurandanBuahs.get(position);
        holder.namaBuah.setText(sayurandanBuah.getNamaBuah());
        holder.descBuah.setText(sayurandanBuah.getDeskripsiBuah());
        holder.images.setImageResource(sayurandanBuah.getImage());
    }

    @Override
    public int getItemCount() {
        return sayurandanBuahs.size();
    }
}
