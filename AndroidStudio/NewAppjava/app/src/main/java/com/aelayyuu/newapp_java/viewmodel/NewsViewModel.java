package com.aelayyuu.newapp_java.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.aelayyuu.newapp_java.api.ApiService;
import com.aelayyuu.newapp_java.model.News;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsViewModel extends ViewModel {
    MutableLiveData<News> result = new MutableLiveData<>();
    MutableLiveData<Boolean> loadError = new MutableLiveData<>();
    MutableLiveData<Boolean> loading = new MutableLiveData<>();

    public MutableLiveData<News> getResult() {
        return result;
    }

    public MutableLiveData<Boolean> getLoading() {
        return loading;
    }

    public MutableLiveData<Boolean> getLoadError() {
        return loadError;
    }

    public void loadResults() {
        loading.setValue(true);

        String apiKey = "5bb4015b85d448989fce66f1bd60de66";

        Call<News> newsCall = ApiService.getNews(
                "us", apiKey
        );
        newsCall.enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {
                if (response.isSuccessful() && response.body() != null) {
                    loading.setValue(false);
                    result.setValue(response.body());
                }

            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {
                loading.setValue(false);
                loadError.setValue(true);

            }
        });
    }
}
