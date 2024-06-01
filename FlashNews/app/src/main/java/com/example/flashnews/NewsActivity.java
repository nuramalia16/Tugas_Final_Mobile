package com.example.flashnews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.flashnews.Fragment.AuFragment;
import com.example.flashnews.Fragment.BrFragment;
import com.example.flashnews.Fragment.HomeFragment;
import com.example.flashnews.Fragment.IdFragment;
import com.example.flashnews.Fragment.IgFragment;
import com.example.flashnews.Fragment.InFragment;
import com.example.flashnews.Fragment.ItFragment;
import com.example.flashnews.Fragment.JpFragment;
import com.example.flashnews.Fragment.JrFragment;
import com.example.flashnews.Fragment.KnFragment;
import com.example.flashnews.Fragment.KrFragment;
import com.example.flashnews.Fragment.MeFragment;
import com.example.flashnews.Fragment.PrFragment;
import com.example.flashnews.Fragment.RsFragment;
import com.example.flashnews.Fragment.SgFragment;
import com.example.flashnews.Fragment.UsFragment;

import com.example.flashnews.Activity.ListCityActivity;
import com.example.flashnews.Activity.ProfileActivity;

public class NewsActivity extends AppCompatActivity  {

    private HomeFragment homeFragment;
    private UsFragment usFragment;
    private Fragment currentFragment;
    private SearchView searchView;
    private String loggedInEmail;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        ImageView IV_Home = findViewById(R.id.IV_Home);
        searchView = findViewById(R.id.search_view);
        ImageView IV_map = findViewById(R.id.IV_world);
        ImageView iv_profile = findViewById(R.id.IV_Profile);


        // Tambahkan HomeFragment ke MainActivity
        if (savedInstanceState == null) {
            homeFragment = new HomeFragment();
            usFragment = new UsFragment();
            currentFragment = homeFragment;
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.fragment_container, homeFragment);
            fragmentTransaction.commit();

            loggedInEmail = getIntent().getStringExtra("email");

        }

        IV_Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new HomeFragment());
            }
        });

        IV_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewsActivity.this, ListCityActivity.class);
                intent.putExtra("email", loggedInEmail);
                startActivity(intent);
            }
        });

        iv_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewsActivity.this, ProfileActivity.class);
                intent.putExtra("email", loggedInEmail);
                startActivity(intent);
            }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                performSearch(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (newText.isEmpty()) {
                    loadInitialNews();
                } else {
                    performSearch(newText);
                }
                return true;
            }

        });

        handleIntent();
    }


    private void performSearch(String query) {
        if (currentFragment instanceof HomeFragment) {
            ((HomeFragment) currentFragment).searchNews(query);
        }
    }

    private void loadInitialNews() {
        if (currentFragment instanceof HomeFragment) {
            ((HomeFragment) currentFragment).loadInitialNews();
        }
//        else if (currentFragment instanceof UsFragment) {
//            ((UsFragment) currentFragment).loadInitialNews();
//        }
    }

    private void handleIntent() {
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("fragmentToLoad")) {
            String fragmentToLoad = intent.getStringExtra("fragmentToLoad");
            switch (fragmentToLoad) {
                case "usFragment":
                    loadFragment(new UsFragment());
                    searchView.setVisibility(View.GONE);
                    break;
                case "idFragment":
                    loadFragment(new IdFragment());
                    searchView.setVisibility(View.GONE);
                    break;
                case "inFragment":
                    loadFragment(new InFragment());
                    searchView.setVisibility(View.GONE);
                    break;
                case "jpFragment":
                    loadFragment(new JpFragment());
                    searchView.setVisibility(View.GONE);
                    break;
                case "jrFragment":
                    loadFragment(new JrFragment());
                    searchView.setVisibility(View.GONE);
                    break;
                case "igFragment":
                    loadFragment(new IgFragment());
                    searchView.setVisibility(View.GONE);
                    break;
                case "prFragment":
                    loadFragment(new PrFragment());
                    searchView.setVisibility(View.GONE);
                    break;
                case "brFragment":
                    loadFragment(new BrFragment());
                    searchView.setVisibility(View.GONE);
                    break;
                case "rsFragment":
                    loadFragment(new RsFragment());
                    searchView.setVisibility(View.GONE);
                    break;
                case "meFragment":
                    loadFragment(new MeFragment());
                    searchView.setVisibility(View.GONE);
                    break;
                case "knFragment":
                    loadFragment(new KnFragment());
                    searchView.setVisibility(View.GONE);
                    break;
                case "itFragment":
                    loadFragment(new ItFragment());
                    searchView.setVisibility(View.GONE);
                    break;
                case "krFragment":
                    loadFragment(new KrFragment());
                    searchView.setVisibility(View.GONE);
                    break;
                case "auFragment":
                    loadFragment(new AuFragment());
                    searchView.setVisibility(View.GONE);
                    break;
                case "sgFragment":
                    loadFragment(new SgFragment());
                    searchView.setVisibility(View.GONE);
                    break;
                default:
                    loadFragment(new HomeFragment());
                    break;
            }
        }
    }

    private void loadFragment(Fragment fragment) {
        currentFragment = fragment;
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}

