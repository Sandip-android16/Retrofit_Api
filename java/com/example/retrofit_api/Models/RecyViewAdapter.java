package com.example.retrofit_api.Models;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.retrofit_api.R;

import java.util.List;

public class RecyViewAdapter extends RecyclerView.Adapter<RecyViewAdapter.ViewHolder> {


    Context context;
    List<Hero> list;

    public RecyViewAdapter(Context context, List<Hero> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(context).inflate(R.layout.listview,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.textView.setText(list.get(position).getName());
        Glide.with(context)
                .load(list.get(position).getImageurl())
                .into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textView=itemView.findViewById(R.id.txtname);
            imageView=itemView.findViewById(R.id.ivIma);


        }
    }
}
