package com.cyberhuskies.travellersearchapp.domain;

import androidx.annotation.NonNull;

import com.cyberhuskies.travellersearchapp.domain.entites.FullUserEntity;
import com.cyberhuskies.travellersearchapp.domain.entites.Status;

import java.util.function.Consumer;

public class PutUserUseCase {

    private final UserRepository repo;

    public PutUserUseCase(UserRepository repo) {
        this.repo = repo;
    }

    public void execute(@NonNull String id, @NonNull Consumer<Status<FullUserEntity>> callback) {
        repo.update(id, callback);
    }

}
