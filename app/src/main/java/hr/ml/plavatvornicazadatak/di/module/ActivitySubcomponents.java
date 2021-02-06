package hr.ml.plavatvornicazadatak.di.module;

import dagger.Module;
import hr.ml.plavatvornicazadatak.di.component.ArticleFragmentComponent;
import hr.ml.plavatvornicazadatak.di.component.FragmentComponent;

@Module(subcomponents = {FragmentComponent.class, ArticleFragmentComponent.class})
public class ActivitySubcomponents {
}
