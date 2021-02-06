package hr.ml.plavatvornicazadatak.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

import hr.ml.plavatvornicazadatak.MainApplication;
import hr.ml.plavatvornicazadatak.R;
import hr.ml.plavatvornicazadatak.di.component.ActivityComponent;

public class MainActivity extends AppCompatActivity {

    private ActivityComponent activityComponent;

    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        configureDI();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Setup navigationUI for changing titles and back button
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager()
                .findFragmentById(R.id.nav_host_fragment);

        navController = navHostFragment.getNavController();

        NavigationUI.setupActionBarWithNavController(
                this, navController);
    }

    private void configureDI() {
        activityComponent = ((MainApplication) getApplication())
                .getAppComponent()
                .getActivityComponent()
                .create(this);
    }

    @Override
    public boolean onSupportNavigateUp() {
        return navController.navigateUp();
    }

    public ActivityComponent getActivityComponent() {
        return activityComponent;
    }
}