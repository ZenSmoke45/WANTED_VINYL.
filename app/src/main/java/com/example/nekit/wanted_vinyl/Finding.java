package com.example.nekit.wanted_vinyl;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Finding {
    @FormUrlEncoded
    @POST("/demo0013/")
    Call<Object> performPostCall(@FieldMap HashMap<String, String> postDataParams);
}
