package com.cyberhuskies.travellersearchapp.data;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import com.cyberhuskies.travellersearchapp.data.dto.UserDto;
import com.cyberhuskies.travellersearchapp.data.network.RetrofitFactory;
import com.cyberhuskies.travellersearchapp.data.source.UserApi;
import com.cyberhuskies.travellersearchapp.data.utils.CallToConsumer;
import com.cyberhuskies.travellersearchapp.domain.UserRepository;
import com.cyberhuskies.travellersearchapp.domain.entites.FullUserEntity;
import com.cyberhuskies.travellersearchapp.domain.entites.ItemUserEntity;
import com.cyberhuskies.travellersearchapp.domain.entites.Status;

public class UserRepositoryImpl implements UserRepository {
    private static UserRepositoryImpl INSTANCE;
    private final UserApi userApi = RetrofitFactory.getInstance().getUserApi();

    private UserRepositoryImpl() {}

    public static synchronized UserRepositoryImpl getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new UserRepositoryImpl();
        }
        return INSTANCE;
    }

    @Override
    public void getAllUsers(@NonNull Consumer<Status<List<ItemUserEntity>>> callback) {
        userApi.getAll().enqueue(new CallToConsumer<>(
                callback,
                usersDto -> {
                    ArrayList<ItemUserEntity> result = new ArrayList<>(usersDto.size());
                    for (UserDto user : usersDto) {
                        final String id = user.id;
                        final String name = user.name;
                        if (id != null && name != null) {
                            result.add(new ItemUserEntity(id, name));
                        }
                    }
                    return result;
                }
        ));
    }

    @Override
    public void getUser(@NonNull String id, @NonNull Consumer<Status<FullUserEntity>> callback) {
        userApi.getById(id).enqueue(new CallToConsumer<>(
                callback,
                user -> {
                    final String resultId = user.id;
                    final String name = user.name;
                    if (resultId != null && name != null) {
                        return new FullUserEntity(
                                resultId,
                                name,
                                user.photoUrl,
                                user.email,
                                user.phone,
                                user.travelId
                        );
                    } else {
                        return null;
                    }
                }
        ));

    }
}
