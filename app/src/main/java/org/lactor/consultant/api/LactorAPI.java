package org.lactor.consultant.api;

import org.lactor.consultant.modules.authorization.webrequests.AccountCreationRequest;
import org.lactor.consultant.modules.authorization.webrequests.LoginRequest;
import org.lactor.consultant.modules.authorization.webrequests.LoginResult;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface LactorAPI {

    @POST("/account/create")
    Call<LoginResult> createAccount(@Body AccountCreationRequest accountRequest);

    @POST("/account/login")
    Call<LoginResult> login(@Body LoginRequest loginrequest);

    @GET("/account/verify_token")
    Call<Boolean> verifyToken(@Query("authToken") String authToken);
}
