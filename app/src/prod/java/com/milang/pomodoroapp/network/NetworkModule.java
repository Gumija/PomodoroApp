package com.milang.pomodoroapp.network.prod;

import com.milang.pomodoroapp.network.PomodoroApi;
import com.milang.pomodoroapp.network.GsonHelper;
import com.milang.pomodoroapp.network.NetworkConfig;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;

@Module
public class NetworkModule {

    private OkHttpHelper okHttpHelper = new OkHttpHelper();

    @Provides
    @Singleton
    public OkHttpClient.Builder provideOkHttpClientBuilder() {
        return provideOkHttpClientBuilder();
    }

    @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient(OkHttpClient.Builder builder) {
        return builder.build();
    }

    @Provides
    @Singleton
    public Retrofit provideRetrofit(OkHttpClient client) {
        return okHttpHelper.provideRetrofit(client);
    }

    @Provides
    @Singleton
    public PomodoroApi provideDefaultApi(Retrofit retrofit) {
        return retrofit.create(PomodoroApi.class);
    }

}


