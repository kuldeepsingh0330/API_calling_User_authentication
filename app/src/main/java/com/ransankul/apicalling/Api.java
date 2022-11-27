package com.ransankul.apicalling;

import com.ransankul.apicalling.ModelResponse.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Api {

    @FormUrlEncoded
    @POST("login.php")
    Call<LoginResponse> login(
      @Field("formnumber") String formnumber,
      @Field("password") String password
    );

}
