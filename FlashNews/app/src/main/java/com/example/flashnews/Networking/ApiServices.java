package com.example.flashnews.Networking;

import com.example.flashnews.NewsResponse;
import com.example.flashnews.NewsResponse2;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiServices {
    @GET("v2/everything")
    Call<NewsResponse> getEverything(@Query("q") String query, @Query("apiKey") String apiKey);

    @GET("v2/top-headlines")
    Call<NewsResponse2> getNews(@Query("country") String country, @Query("category") String category, @Query("apiKey") String apiKey);

}
