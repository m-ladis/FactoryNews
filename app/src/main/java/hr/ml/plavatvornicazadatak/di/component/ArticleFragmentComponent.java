package hr.ml.plavatvornicazadatak.di.component;

import androidx.fragment.app.Fragment;

import dagger.BindsInstance;
import dagger.Subcomponent;
import hr.ml.plavatvornicazadatak.di.module.StoryModule;
import hr.ml.plavatvornicazadatak.di.scope.FragmentScope;
import hr.ml.plavatvornicazadatak.model.entity.Article;
import hr.ml.plavatvornicazadatak.view.StoryFragment;

@FragmentScope
@Subcomponent(modules = StoryModule.class)
public interface ArticleFragmentComponent {

    @Subcomponent.Factory
    interface Factory {
        ArticleFragmentComponent create(@BindsInstance Fragment fragment, @BindsInstance Article article);
    }

    void inject(StoryFragment storyFragment);
}
