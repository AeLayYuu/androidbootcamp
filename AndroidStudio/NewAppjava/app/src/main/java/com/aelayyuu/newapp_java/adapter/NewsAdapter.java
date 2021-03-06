package com.aelayyuu.newapp_java.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aelayyuu.newapp_java.R;
import com.aelayyuu.newapp_java.model.ArticlesItem;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class NewsAdapter extends
        RecyclerView.Adapter<NewsAdapter.ArticleViewHolder> {

    private List<ArticlesItem> articlesItemList = new ArrayList<>();

    @NonNull
    @Override
    public ArticleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_article, parent, false);
        return new ArticleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleViewHolder holder, int position) {
        holder.title.setText(articlesItemList.get(position).getTitle());
        Picasso.get()
                .load(articlesItemList.get(position).getUrlToImage())
                .into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return articlesItemList.size();
    }

    public void updateArticle(List<ArticlesItem> articlesItems) {
        this.articlesItemList = articlesItems;
        notifyDataSetChanged();
    }

    class ArticleViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        ImageView imageView;

        public ArticleViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.articleTitle);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }


}
