package hr.ml.plavatvornicazadatak.di.component;

import android.app.Application;

import dagger.BindsInstance;
import dagger.Component;
import hr.ml.plavatvornicazadatak.di.module.AppSubcomponent;
import hr.ml.plavatvornicazadatak.di.module.RetrofitModule;
import hr.ml.plavatvornicazadatak.di.module.RoomDatabaseModule;
import hr.ml.plavatvornicazadatak.di.scope.ApplicationScope;

@ApplicationScope
@Component(modules = {RoomDatabaseModule.class, RetrofitModule.class, AppSubcomponent.class})
public interface AppComponent {

    @Component.Factory
    interface Factory{
        AppComponent create(@BindsInstance Application application);
    }

    ActivityComponent.Factory getActivityComponent();
}
