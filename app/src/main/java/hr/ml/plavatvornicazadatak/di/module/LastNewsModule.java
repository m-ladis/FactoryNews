package hr.ml.plavatvornicazadatak.di.module;

import androidx.fragment.app.Fragment;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import hr.ml.plavatvornicazadatak.di.scope.FragmentScope;
import hr.ml.plavatvornicazadatak.presenter.LastNewsIPresenter;
import hr.ml.plavatvornicazadatak.presenter.LastNewsPresenter;
import hr.ml.plavatvornicazadatak.view.LastNewsFragment;
import hr.ml.plavatvornicazadatak.view.LastNewsIFragment;

@Module
public abstract class LastNewsModule {

    @FragmentScope
    @Provides
    static LastNewsFragment provideLastNewsFragment(Fragment fragment) {
        return (LastNewsFragment) fragment;
    }

    @FragmentScope
    @Binds
    abstract LastNewsIPresenter bindsLastNewsIPresenter(LastNewsPresenter lastNewsPresenter);

    @FragmentScope
    @Provides
    static LastNewsIFragment bindsLastNewsIFragment(LastNewsFragment lastNewsFragment) {
        return lastNewsFragment;
    }

}
