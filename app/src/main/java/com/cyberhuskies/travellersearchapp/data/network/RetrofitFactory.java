package com.cyberhuskies.travellersearchapp.data.network;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import com.cyberhuskies.travellersearchapp.data.source.CredentialsDataSource;
import com.cyberhuskies.travellersearchapp.data.source.TravelApi;
import com.cyberhuskies.travellersearchapp.data.source.UserApi;

public class RetrofitFactory {
    private static RetrofitFactory INSTANCE;

    private RetrofitFactory() {}

    public static synchronized RetrofitFactory getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new RetrofitFactory();
        }
        return INSTANCE;
    }
    private final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://10.0.2.2:8080/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private final OkHttpClient.Builder client = new OkHttpClient.Builder()
            .addInterceptor(chain -> {
                        String authData = CredentialsDataSource.getInstance().getAuthData();
                        if (authData == null) {
                            return chain.proceed(chain.request());
                        } else {
                            Request request = chain.request()
                                    .newBuilder()
                                    .addHeader("Authorization", authData)
                                    .build();
                            return chain.proceed(request);
                        }

                    }
            );
    public UserApi getUserApi() {
        return retrofit.create(UserApi.class);
    }
    public TravelApi getTravelApi() {
        return retrofit.create(TravelApi.class);
    }
}
