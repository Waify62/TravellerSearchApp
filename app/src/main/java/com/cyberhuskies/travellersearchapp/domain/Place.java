package com.cyberhuskies.travellersearchapp.domain;

import com.google.android.gms.maps.model.LatLng;
@Deprecated
public class Place {


    private final String city;

    private final LatLng coordinates;

    public Place(String city, LatLng coordinates){

        this.city=city;
        this.coordinates=coordinates;
    }


}
