package hr.ml.plavatvornicazadatak.di.module;

import androidx.fragment.app.Fragment;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import hr.ml.plavatvornicazadatak.di.scope.FragmentScope;
import hr.ml.plavatvornicazadatak.presenter.StoryIPresenter;
import hr.ml.plavatvornicazadatak.presenter.StoryPresenter;
import hr.ml.plavatvornicazadatak.view.StoryFragment;
import hr.ml.plavatvornicazadatak.view.StoryIFragment;

@Module
public abstract class StoryModule {

    @FragmentScope
    @Provides
    static StoryFragment provideStoryFragment(Fragment fragment) {
        return (StoryFragment) fragment;
    }

    @FragmentScope
    @Binds
    abstract StoryIPresenter bindsStoryIPresenter(StoryPresenter storyPresenter);

    @FragmentScope
    @Provides
    static StoryIFragment bindsStoryIFragment(StoryFragment storyFragment) {
        return storyFragment;
    }

}
