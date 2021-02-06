package hr.ml.plavatvornicazadatak.di.component;

import android.app.Activity;

import dagger.BindsInstance;
import dagger.Subcomponent;
import hr.ml.plavatvornicazadatak.di.module.ActivitySubcomponents;
import hr.ml.plavatvornicazadatak.di.scope.ActivityScope;
import hr.ml.plavatvornicazadatak.view.MainActivity;

@ActivityScope
@Subcomponent(modules = {ActivitySubcomponents.class})
public interface ActivityComponent {

    @Subcomponent.Factory
    interface Factory {
        ActivityComponent create(@BindsInstance Activity activity);
    }

    FragmentComponent.Factory getFragmentComponent();
    ArticleFragmentComponent.Factory getArticleFragmentComponent();

    void inject(MainActivity mainActivity);
}
