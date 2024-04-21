package com.cyberhuskies.travellersearchapp.domain.entites;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class FullUserEntity {
    @NonNull
    private final String id;
    @NonNull
    private final String name;
    @Nullable
    private final String photoUrl;
    @Nullable
    private final String email;
    @Nullable
    private final String phone;

    @Nullable
    private final String travelId;

    public FullUserEntity(
            @NonNull String id,
            @NonNull String name,
            @Nullable String photoUrl,
            @Nullable String email,
            @Nullable String phone,
            @Nullable String travelId
    ) {
        this.id = id;
        this.name = name;
        this.photoUrl = photoUrl;
        this.email = email;
        this.phone = phone;
        this.travelId = travelId;
    }

    @NonNull
    public String getId() {
        return id;
    }

    @NonNull
    public String getName() {
        return name;
    }

    @Nullable
    public String getPhotoUrl() {
        return photoUrl;
    }

    @Nullable
    public String getEmail() {
        return email;
    }

    @Nullable
    public String getPhone() {
        return phone;
    }

    @Nullable
    public String getTravelId() {
        return travelId;
    }

}
