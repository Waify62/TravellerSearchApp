package com.cyberhuskies.travellersearchapp.domain;

import androidx.annotation.NonNull;

import java.util.List;
import java.util.function.Consumer;

import com.cyberhuskies.travellersearchapp.domain.entites.FullUserEntity;
import com.cyberhuskies.travellersearchapp.domain.entites.ItemUserEntity;
import com.cyberhuskies.travellersearchapp.domain.entites.Status;

public interface UserRepository {
    void getAllUsers(@NonNull Consumer<Status<List<ItemUserEntity>>> callback);

    void getUser(@NonNull String id, @NonNull Consumer<Status<FullUserEntity>> callback);

}
