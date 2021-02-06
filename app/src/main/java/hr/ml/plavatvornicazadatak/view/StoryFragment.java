package hr.ml.plavatvornicazadatak.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

import java.util.List;

import javax.inject.Inject;

import hr.ml.plavatvornicazadatak.R;
import hr.ml.plavatvornicazadatak.adapter.StoryViewPagerAdapter;
import hr.ml.plavatvornicazadatak.di.component.ArticleFragmentComponent;
import hr.ml.plavatvornicazadatak.model.entity.Article;
import hr.ml.plavatvornicazadatak.presenter.StoryIPresenter;

public class StoryFragment extends BaseFragment implements StoryIFragment {

    @Inject
    StoryIPresenter presenter;

    private ViewPager storyViewPager;
    private ProgressBar progressCircular;

    private StoryViewPagerAdapter adapter;

    public StoryFragment() {
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        Bundle bundle = getArguments();
        if (bundle != null) {
            Article article = bundle.getParcelable("article");
            configureDI(article);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_story, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        progressCircular = view.findViewById(R.id.story_progress_circular);
        storyViewPager = view.findViewById(R.id.story_viewpager);
        adapter = new StoryViewPagerAdapter(getChildFragmentManager(),
                StoryViewPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        storyViewPager.setAdapter(adapter);

        presenter.requestLastNews();
    }

    @Override
    public void updateAdapterDataSet(List<StoryViewPagerFragment> fragments, int currentItem) {
        adapter.setFragments(fragments);
        adapter.notifyDataSetChanged();
        storyViewPager.setCurrentItem(currentItem, true);
    }

    @Override
    public void setProgressBarVisibility(boolean visible) {
        if (visible) progressCircular.setVisibility(View.VISIBLE);
        else progressCircular.setVisibility(View.GONE);
    }

    private void configureDI(Article article) {
        ArticleFragmentComponent fragmentComponent = ((MainActivity) getActivity())
                .getActivityComponent()
                .getArticleFragmentComponent()
                .create(this, article);

        fragmentComponent.inject(this);
    }
}