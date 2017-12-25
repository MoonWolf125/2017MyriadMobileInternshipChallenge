package com.example.kl7304qk.dahnkyfinal.API;

import com.example.kl7304qk.dahnkyfinal.model.Subscriber;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Kyle on 12/8/2017.
 */

interface SubscriberService {
    @POST("v1/subscribe")
    @FormUrlEncoded
    Call<Subscriber> subscribe(@Field("email") String email);
}
