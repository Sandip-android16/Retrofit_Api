package com.example.retrofit_api.Models;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.retrofit_api.R;

import java.util.ArrayList;
import java.util.List;

public class ListViewAdapter extends BaseAdapter {

    Context context;
    List<Hero> heroList;

    public ListViewAdapter(Context context, List<Hero> heroList) {
        this.context = context;
        this.heroList = heroList;
    }

    @Override
    public int getCount() {
        return heroList.size();
    }

    @Override
    public Object getItem(int position) {
        return heroList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return heroList.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView= LayoutInflater.from(context).inflate(R.layout.listview,null);


        ImageView imageView;
        TextView textView;

        textView=convertView.findViewById(R.id.txtname);
        imageView=convertView.findViewById(R.id.ivIma);

        textView.setText(heroList.get(position).getName());


        Glide.with(context)
                .load(heroList.get(position).getImageurl())
                .into(imageView);
        return convertView;
    }
}
