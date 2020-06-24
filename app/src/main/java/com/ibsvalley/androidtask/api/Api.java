package com.ibsvalley.androidtask.api;


import com.ibsvalley.androidtask.model.carsModel;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface Api {

    @GET("cars")
    Single<carsModel> getLanguage_Model(@Query("page") int page);


}
