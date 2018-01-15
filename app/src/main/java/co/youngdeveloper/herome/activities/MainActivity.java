package co.youngdeveloper.herome.activities;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import co.youngdeveloper.herome.R;
import co.youngdeveloper.herome.fragments.MainFragment;
import co.youngdeveloper.herome.fragments.PowerFragment;

public class MainActivity extends AppCompatActivity implements MainFragment.OnMainFragmentInteractionListener, PowerFragment.OnPowerFragmentInteractionListener {

    public static String powerType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager manager = getSupportFragmentManager();
        Fragment fragment = manager.findFragmentById(R.id.fragment_container);

        if (fragment == null) {
            fragment = new MainFragment();
            manager.beginTransaction().add(R.id.fragment_container, fragment).commit();
        }

    }

    public void loadPowerScreen() {
        PowerFragment powerFragment = new PowerFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, powerFragment).addToBackStack(null).commit();
    }

    public String setPowerType(int selectedPower) {
        switch (selectedPower) {
            case 1:
                powerType = "Accidental";
                break;

            case 2:
                powerType = "Genetic";
                break;

            case 3:
                powerType = "Born";
                break;
        }

        return powerType;
    }

    @Override
    public void onMainFragmentInteraction(Uri uri) {

    }

    @Override
    public void onPowerFragmentInteraction(Uri uri) {

    }
}
