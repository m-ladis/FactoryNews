package hr.ml.plavatvornicazadatak;

import android.app.Application;

import hr.ml.plavatvornicazadatak.di.component.AppComponent;
import hr.ml.plavatvornicazadatak.di.component.DaggerAppComponent;


public class MainApplication extends Application {

    AppComponent appComponent;

    @Override
    public void onCreate() {
        configureDagger();
        super.onCreate();
    }

    private void configureDagger() {
        appComponent = DaggerAppComponent.factory().create(this);
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
