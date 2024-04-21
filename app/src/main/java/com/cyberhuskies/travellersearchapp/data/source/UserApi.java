package com.cyberhuskies.travellersearchapp.data.source;

import android.view.PixelCopy;

import java.util.List;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

import com.cyberhuskies.travellersearchapp.data.dto.AccountDto;
import com.cyberhuskies.travellersearchapp.data.dto.UserDto;
import com.cyberhuskies.travellersearchapp.domain.entites.FullUserEntity;

public interface UserApi {
    @GET("edu/v1/user")
    Call<List<UserDto>> getAll();
    @GET("edu/v1/user/{id}")
    Call<UserDto> getById(@Path("id") String id);
    @GET("/edu/v1/user/username/{username}")
    Call<Void> isExist(@Path("username") String login);
    //create new
    @POST("edu/v1/user/register")
    Call<Void> register(@Body AccountDto dto);
    //get login
    @GET("edu/v1/user/login")
    Call<Void> login();
}
