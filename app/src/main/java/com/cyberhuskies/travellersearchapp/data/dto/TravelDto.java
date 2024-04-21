package com.cyberhuskies.travellersearchapp.data.dto;

import androidx.annotation.AnyRes;
import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

public class TravelDto {
    @Nullable
    @SerializedName("id")
    public String id;

    @Nullable
    @SerializedName("startDate")
    public String startDate;

    @Nullable
    @SerializedName("finishDate")
    public String finishDate;

    @Nullable
    @SerializedName("city")
    public String city;

    @Nullable
    @SerializedName("coordinates")
    public String coordinates;
}
