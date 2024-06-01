package com.example.flashnews.Fragment;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.flashnews.Networking.ApiServices;
import com.example.flashnews.Networking.RetrofitClient;
import com.example.flashnews.News;
import com.example.flashnews.NewsAdapter;
import com.example.flashnews.NewsResponse2;
import com.example.flashnews.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PrFragment extends Fragment {
    private RecyclerView recyclerView;
    private NewsAdapter newsAdapter;
    private ProgressBar progressBar;
    private LinearLayout layoutNoInternet;
    private Button btnRetry;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        newsAdapter = new NewsAdapter();
        recyclerView.setAdapter(newsAdapter);
        progressBar = view.findViewById(R.id.progressBar);
        layoutNoInternet = view.findViewById(R.id.layout_no_internet);
        btnRetry = view.findViewById(R.id.btnRetry);

        layoutNoInternet.setVisibility(View.GONE);

        checkInternetConnection();

        btnRetry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkInternetConnection();
            }
        });

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                loadInitialNews();
                progressBar.setVisibility(View.GONE);
            }
        }, 2000);
        return view;
    }

    public void loadInitialNews() {
        getNewsFromApi("business");
    }

    private void checkInternetConnection() {
        ConnectivityManager connectivityManager = (ConnectivityManager) requireActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = connectivityManager.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null && activeNetwork.isConnectedOrConnecting();

        if (!isConnected) {
            layoutNoInternet.setVisibility(View.VISIBLE);
            progressBar.setVisibility(View.GONE);
        } else {
            layoutNoInternet.setVisibility(View.GONE);
            progressBar.setVisibility(View.VISIBLE);
            loadInitialNews();
        }
    }
    private void getNewsFromApi(String query) {
        ApiServices apiService = RetrofitClient.getClient().create(ApiServices.class);
        Call<NewsResponse2> call = apiService.getNews("fr", query, "2af87976fc3a4e74981179e9c30ff663");
        call.enqueue(new Callback<NewsResponse2>() {
            @Override
            public void onResponse(Call<NewsResponse2> call, Response<NewsResponse2> response) {
                if (response.isSuccessful()) {
                    NewsResponse2 newsResponse = response.body();
                    if (newsResponse != null) {
                        List<News> newsList = newsResponse.getArticles();
                        newsAdapter.setData(newsList);
                    } else {
                        Toast.makeText(getContext(), "Gagal mendapatkan data berita: NewsResponse is null", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getContext(), "Gagal mendapatkan data berita", Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.GONE);
                }
            }

            @Override
            public void onFailure(Call<NewsResponse2> call, Throwable t) {
                Toast.makeText(getContext(), "Gagal melakukan panggilan API", Toast.LENGTH_SHORT).show();
                progressBar.setVisibility(View.GONE);
            }
        });
    }
}
