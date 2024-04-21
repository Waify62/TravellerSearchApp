package com.cyberhuskies.travellersearchapp.domain;

import androidx.annotation.NonNull;

import java.util.List;
import java.util.function.Consumer;

import com.cyberhuskies.travellersearchapp.domain.entites.ItemUserEntity;
import com.cyberhuskies.travellersearchapp.domain.entites.Status;

public class GetUsersListUseCase {
    private final UserRepository repo;

    public GetUsersListUseCase(UserRepository repo) {
        this.repo = repo;
    }

    public void execute(@NonNull Consumer<Status<List<ItemUserEntity>>> callback) {
        repo.getAllUsers(callback);
    }
}
