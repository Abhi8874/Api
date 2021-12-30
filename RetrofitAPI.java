package com.aws.apiproject;

import com.aws.apiproject.model.SocialLoginModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface RetrofitAPI {

    @FormUrlEncoded
    @POST(Constants.API_SOCIAL)
    Call<SocialLoginModel> socialLogin(
            @Field("email") String email,
            @Field("aouth") String aouth
    );
}
