package com.example.kl7304qk.dahnkyfinal.API;

import com.example.kl7304qk.dahnkyfinal.model.Subscriber;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Kyle on 12/8/2017.
 */

public interface SubscriberService {
    @POST("subscribe")
    @FormUrlEncoded
    Call<Subscriber> subscribe(@Field("email") String email);
}
