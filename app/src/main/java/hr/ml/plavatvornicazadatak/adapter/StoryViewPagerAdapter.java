package hr.ml.plavatvornicazadatak.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.List;

import hr.ml.plavatvornicazadatak.view.StoryViewPagerFragment;

public class StoryViewPagerAdapter extends FragmentStatePagerAdapter {

    List<StoryViewPagerFragment> fragments;

    public StoryViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments != null ? fragments.size() : 0;
    }

    public void setFragments(List<StoryViewPagerFragment> fragments) {
        this.fragments = fragments;
    }
}
