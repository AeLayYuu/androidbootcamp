package com.aelayyuu.newapp_java.api;

import com.aelayyuu.newapp_java.model.News;

import retrofit2.Call;

public class ApiService {

    public static ApiInterface apiInterface;

    public static ApiInterface getApiInterface(){
        apiInterface = ApiClient.getApiClient().create(
                ApiInterface.class
        );
        return apiInterface;
    }

    public static Call<News> getNews (
            String country , String category , String apiKey
    ){
        return apiInterface.getNews(
                country, category, apiKey
        );
    }
}
