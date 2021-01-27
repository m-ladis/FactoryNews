package hr.ml.plavatvornicazadatak.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import hr.ml.plavatvornicazadatak.R;
import hr.ml.plavatvornicazadatak.adapter.NewsAdapter;
import hr.ml.plavatvornicazadatak.model.entity.Article;
import hr.ml.plavatvornicazadatak.presenter.LastNewsIPresenter;
import hr.ml.plavatvornicazadatak.presenter.LastNewsPresenter;

public class LastNewsFragment extends Fragment implements LastNewsIFragment {
    private LastNewsIPresenter presenter;

    private RecyclerView lastNewsRecyclerView;

    private NewsAdapter newsAdapter;

    public LastNewsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        presenter = new LastNewsPresenter(this);

        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_last_news, container, false);

        // bind views
        lastNewsRecyclerView = rootView.findViewById(R.id.last_news_recycler_view);

        newsAdapter = new NewsAdapter(getContext());
        lastNewsRecyclerView.setAdapter(newsAdapter);

        presenter.showLastNews();

        return rootView;
    }

    @Override
    public void setArticles(List<Article> articles) {
        newsAdapter.setArticles(articles);
        newsAdapter.notifyDataSetChanged();
    }
}