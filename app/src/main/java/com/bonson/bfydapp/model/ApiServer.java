package com.bonson.bfydapp.model;

import com.google.gson.JsonObject;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiServer {
    @POST("wap")
    Observable<JsonObject> post(@Body Object map);

    @POST("wap")
    Call<JsonObject> get(@Body Object map);
}
