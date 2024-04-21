package com.cyberhuskies.travellersearchapp.data;

import com.cyberhuskies.travellersearchapp.data.network.RetrofitFactory;
import com.cyberhuskies.travellersearchapp.data.source.TravelApi;
import com.cyberhuskies.travellersearchapp.data.source.UserApi;

public class TravelRepositoryImpl {

    private static TravelRepositoryImpl INSTANCE;
    private final TravelApi travelApi = RetrofitFactory.getInstance().getTravelApi();
    private TravelRepositoryImpl() {}
    public static synchronized TravelRepositoryImpl getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new TravelRepositoryImpl();
        }
        return INSTANCE;
    }


}
