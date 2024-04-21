package com.cyberhuskies.travellersearchapp.data.source;

import java.util.List;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

import com.cyberhuskies.travellersearchapp.data.dto.TravelDto;
import com.cyberhuskies.travellersearchapp.data.dto.UserDto;

public interface TravelApi {
    @POST("travel")
    Call<List<TravelDto>> add(@Body TravelDto travelDto);

    //all
    @GET("travel")
    Call<List<TravelDto>> getAll();
    //one
    @GET("travel/{id}")
    Call<TravelDto> getById(@Path("id") String id);
    //update
    @PUT("travel/{id}")
    Call<TravelDto> update(@Path("id") String id, @Body TravelDto travelDto);
    //delete
    @DELETE("travel/{id}")
    Call<TravelDto> delete(@Path("id") String id);
    // update user by id
}
