package org.lactor.consultant.core.webrequests;

import org.lactor.consultant.authentication.webrequests.AccountCreationRequest;
import org.lactor.consultant.authentication.webrequests.LoginRequest;
import org.lactor.consultant.authentication.webrequests.LoginResult;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface LactorApiBlah {

    @POST("/account/create")
    Call<LoginResult> createAccount(@Body AccountCreationRequest accountRequest);

    @POST("/account/login")
    Call<LoginResult> login(@Body LoginRequest loginrequest);

    @GET("/account/verify_token")
    Call<Boolean> verifyToken(@Query("authToken") String authToken);
}
