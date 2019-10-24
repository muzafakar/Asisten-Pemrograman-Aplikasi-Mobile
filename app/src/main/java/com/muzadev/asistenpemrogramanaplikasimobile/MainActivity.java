package com.muzadev.asistenpemrogramanaplikasimobile;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.muzadev.asistenpemrogramanaplikasimobile.fragments.FavoriteFragment;
import com.muzadev.asistenpemrogramanaplikasimobile.fragments.HomeFragment;
import com.muzadev.asistenpemrogramanaplikasimobile.fragments.ProfileFragment;

public class MainActivity extends AppCompatActivity {
    private Fragment homeFragment;
    private Fragment favoriteFragment;
    private Fragment profileFragment;

    private BottomNavigationView bnvHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bnvHome = findViewById(R.id.bnvHome);

        // inisialisasi object fragment
        homeFragment = new HomeFragment();
        favoriteFragment = new FavoriteFragment();
        profileFragment = new ProfileFragment();

        // menampilkan homeFragment sebagai tampilan awal
        replaceFragment(homeFragment);
        changeBnvColor(R.color.homeFragment);

        // memberikan aksi ketika  menu diklik
        bnvHome.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menuHome:
                        changeBnvColor(R.color.homeFragment);
                        replaceFragment(homeFragment);
                        break;
                    case R.id.menuProfile:
                        changeBnvColor(R.color.profileFragment);
                        replaceFragment(profileFragment);
                        break;
                    case R.id.menuFavorite:
                        changeBnvColor(R.color.favoriteFragment);
                        replaceFragment(favoriteFragment);
                        break;
                }
                return true;
            }
        });
    }

    private void changeBnvColor(int colorRes) {
        int color = ContextCompat.getColor(MainActivity.this, colorRes);
        bnvHome.setItemBackground(new ColorDrawable(color));
    }

    private void replaceFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.mainFragment, fragment)
                .commit();
    }
}
