package com.raytech.raytech_app;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.raytech.raytech_app.fragments.HomeFragment;
import com.raytech.raytech_app.fragments.AIFragment;
import com.raytech.raytech_app.fragments.IzmirFragment;
import com.raytech.raytech_app.fragments.ProfileFragment;
import com.raytech.raytech_app.fragments.SettingsFragment;

public class MainActivity extends AppCompatActivity {
    private int selectedItemId = 1; // Default selected item ID is 1 (home)


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set home as the default fragment
        getSupportFragmentManager().beginTransaction()
                .setReorderingAllowed(true)
                .replace(R.id.fragment_container_id, HomeFragment.class, null)
                .commit();

        MeowBottomNavigation bottomNavigation = findViewById(R.id.bottomNavigation);
        bottomNavigation.show(3, true); // Select home icon by default
        bottomNavigation.add(new MeowBottomNavigation.Model(1, R.drawable.baseline_settings_24));
        bottomNavigation.add(new MeowBottomNavigation.Model(2, R.drawable.izmir));
        bottomNavigation.add(new MeowBottomNavigation.Model(3, R.drawable.baseline_home_24));
        bottomNavigation.add(new MeowBottomNavigation.Model(4, R.drawable.robot_angry));
        bottomNavigation.add(new MeowBottomNavigation.Model(5, R.drawable.baseline_person_24));

        bottomNavigation.setOnClickMenuListener(model -> {
            selectedItemId = model.getId();

            switch (model.getId()) {
                case 1:
                    getSupportFragmentManager().beginTransaction()
                            .setReorderingAllowed(true)
                            .replace(R.id.fragment_container_id, SettingsFragment.class, null)
                            .commit();
                    break;
                case 2:
                    getSupportFragmentManager().beginTransaction()
                            .setReorderingAllowed(true)
                            .replace(R.id.fragment_container_id, IzmirFragment.class, null)
                            .commit();
                    break;
                case 3:
                    getSupportFragmentManager().beginTransaction()
                            .setReorderingAllowed(true)
                            .replace(R.id.fragment_container_id, HomeFragment.class, null)
                            .commit();
                    break;
                case 4:
                    getSupportFragmentManager().beginTransaction()
                            .setReorderingAllowed(true)
                            .replace(R.id.fragment_container_id, AIFragment.class, null)
                            .commit();
                    break;
                case 5:
                    getSupportFragmentManager().beginTransaction()
                            .setReorderingAllowed(true)
                            .replace(R.id.fragment_container_id, ProfileFragment.class, null)
                            .commit();
                    break;
            }

            return null;
        });
    }

}