package hr.ml.plavatvornicazadatak.view;

import java.util.List;

public interface StoryIFragment extends BaseIFragment {

    void updateAdapterDataSet(List<StoryViewPagerFragment> fragments, int currentItem);

    void setProgressBarVisibility(boolean visible);

}
