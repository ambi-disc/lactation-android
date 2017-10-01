package org.lactor.consultant.api;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by nbeesett on 10/1/17.
 */
public interface LactorAPI {

    @POST("/account/create")
    Call<LoginReturn> createAccount(@Body AccountRequest accountRequest);

    @POST("/account/login")
    Call<LoginReturn> login(@Body LoginRequest loginrequest);

    @GET("/account/verify_token")
    Call<Boolean> verifyToken(@Query("authToken") String authToken);


}
