package hr.ml.plavatvornicazadatak.di.component;

import androidx.fragment.app.Fragment;

import dagger.BindsInstance;
import dagger.Subcomponent;
import hr.ml.plavatvornicazadatak.di.module.LastNewsModule;
import hr.ml.plavatvornicazadatak.di.scope.FragmentScope;
import hr.ml.plavatvornicazadatak.view.LastNewsFragment;

@FragmentScope
@Subcomponent(modules = {LastNewsModule.class})
public interface FragmentComponent {

    @Subcomponent.Factory
    interface Factory {
        FragmentComponent create(@BindsInstance Fragment fragment);
    }

    void inject(LastNewsFragment lastNewsFragment);
}
