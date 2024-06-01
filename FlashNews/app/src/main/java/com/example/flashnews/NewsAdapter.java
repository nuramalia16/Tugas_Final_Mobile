package com.example.flashnews;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {

    private List<News> newsList = new ArrayList<>();

//    tam


    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item, parent, false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        News currentNews = newsList.get(position);
        holder.tv_author.setText(currentNews.getAuthor());
        holder.tv_title.setText(currentNews.getTitle());
        holder.tv_publish.setText(currentNews.getPublishedAt());
        holder.tv_url.setText(currentNews.getUrl());
        // Menggunakan Glide untuk memuat gambar dari URL ke ImageView
        Glide.with(holder.itemView.getContext())
                .load(currentNews.getUrlToImage())
                .placeholder(R.drawable.ic_launcher_background)
                .into(holder.avatarImageView);

    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    // Metode untuk mengatur data berita dalam adapter
    public void setData(List<News> newsList) {
        this.newsList = newsList;
        notifyDataSetChanged();
    }
    //    tamb
    public void clearData() {
        newsList.clear();
        notifyDataSetChanged();
    }


    // Kelas ViewHolder untuk menampung tampilan setiap item berita
    static class NewsViewHolder extends RecyclerView.ViewHolder {
        TextView tv_author;
        TextView tv_title,tv_publish,tv_url;
        ImageView avatarImageView;


        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_author = itemView.findViewById(R.id.tv_author);
            tv_title = itemView.findViewById(R.id.tv_tittle);
            avatarImageView = itemView.findViewById(R.id.avatarImageView);
            tv_publish = itemView.findViewById(R.id.tv_publish);
            tv_url = itemView.findViewById(R.id.tv_url);
        }
    }
}

