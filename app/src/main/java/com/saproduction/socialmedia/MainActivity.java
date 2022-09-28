package com.saproduction.socialmedia;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.iammert.library.readablebottombar.ReadableBottomBar;
import com.saproduction.socialmedia.Fragments.AddFragment;
import com.saproduction.socialmedia.Fragments.HomeFragment;
import com.saproduction.socialmedia.Fragments.NotificationFragment;
import com.saproduction.socialmedia.Fragments.ProfileFragment;
import com.saproduction.socialmedia.Fragments.SearchFragment;
import com.saproduction.socialmedia.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.image.setImageResource(R.drawable.home);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.container, new HomeFragment());
        fragmentTransaction.commit();

        binding.bottomBar.setOnItemSelectListener(new ReadableBottomBar.ItemSelectListener() {
            @Override
            public void onItemSelected(int i) {
                FragmentTransaction fragmentManager = getSupportFragmentManager().beginTransaction();
                switch(i){
                    case 0:
                        fragmentManager.replace(R.id.container, new HomeFragment());
                        break;
                    case 1:
                        fragmentManager.replace(R.id.container, new SearchFragment());
                        break;
                    case 2:
                        fragmentManager.replace(R.id.container, new AddFragment());
                        break;
                    case 3:
                        fragmentManager.replace(R.id.container, new NotificationFragment());
                        break;
                    case 4:
                        fragmentManager.replace(R.id.container, new ProfileFragment());
                        break;
                }
                fragmentManager.commit();
            }
        });

    }
}