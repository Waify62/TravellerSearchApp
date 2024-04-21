package com.cyberhuskies.travellersearchapp.data.dto;

import androidx.annotation.Nullable;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UserDto {
    @Nullable
    @SerializedName("id")
    public String id;
    @Nullable
    @SerializedName("name")
    public String name;
    @Nullable
    @SerializedName("photoUrl")
    public String photoUrl;
    @Nullable
    @SerializedName("email")
    public String email;
    @Nullable
    @SerializedName("phone")
    public String phone;

    @Nullable
    @SerializedName("travel_id")
    public String travelId;
}
