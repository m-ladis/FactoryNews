package hr.ml.plavatvornicazadatak.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import hr.ml.plavatvornicazadatak.R;
import hr.ml.plavatvornicazadatak.listener.LastNewsFragmentNavigationListener;
import hr.ml.plavatvornicazadatak.model.entity.Article;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {
    private Context context;
    private LastNewsFragmentNavigationListener lastNewsFragmentNavigationListener;
    private List<Article> articles;

    public NewsAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.story_item, parent, false);

        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        Article articleAtPosition = articles.get(position);

        holder.storyItemTitle.setText(articleAtPosition.getTitle());
    }

    @Override
    public int getItemCount() {
        return articles != null ? articles.size() : 0;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public void setListener(LastNewsFragmentNavigationListener lastNewsFragmentNavigationListener) {
        this.lastNewsFragmentNavigationListener = lastNewsFragmentNavigationListener;
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder{

        private TextView storyItemTitle;
        private ImageView storyItemImage;

        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);

            storyItemTitle = itemView.findViewById(R.id.story_item_title);
            storyItemImage = itemView.findViewById(R.id.story_item_image);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    lastNewsFragmentNavigationListener.navigateToArticle(getItemId());
                }
            });
        }
    }
}
