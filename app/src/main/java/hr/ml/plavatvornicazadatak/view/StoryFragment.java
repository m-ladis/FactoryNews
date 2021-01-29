package hr.ml.plavatvornicazadatak.view;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;

import hr.ml.plavatvornicazadatak.R;
import hr.ml.plavatvornicazadatak.adapter.StoryViewPagerAdapter;
import hr.ml.plavatvornicazadatak.model.entity.Article;
import hr.ml.plavatvornicazadatak.model.repository.NewsRepository;
import hr.ml.plavatvornicazadatak.presenter.StoryIPresenter;
import hr.ml.plavatvornicazadatak.presenter.StoryPresenter;

public class StoryFragment extends BaseFragment implements StoryIFragment {

    private StoryIPresenter presenter;

    private ViewPager storyViewPager;
    private ProgressBar progressCircular;

    private StoryViewPagerAdapter adapter;

    public StoryFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = getArguments();
        Article article = bundle.getParcelable("article");

        presenter = new StoryPresenter(new NewsRepository(getActivity().getApplication()), this, article);
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
}