package org.lactor.consultant.core.webrequests;

import org.lactor.consultant.authentication.webrequests.AccountCreationRequest;
import org.lactor.consultant.authentication.webrequests.LoginRequest;
import org.lactor.consultant.authentication.webrequests.LoginResult;
import org.lactor.consultant.displaydata.webrequests.DiaryDataResponse;
import org.lactor.consultant.notifications.model.NotificationResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface LactorApi {

    @POST("/account/create")
    Call<LoginResult> createAccount(
            @Body AccountCreationRequest accountRequest
    );

    @POST("/account/login")
    Call<LoginResult> login(
            @Body LoginRequest loginrequest
    );

    @GET("/account/verify_token")
    Call<Boolean> verifyToken(
            @Query("authToken") String authToken
    );

 /*   @GET("/account/scientist")
    Call <Boolean> verifyToken(
            @Query("authToken") String authToken
    ); */

    @GET("/mothers")
    Call<MothersResult> getListOfMothers(
            @Query("authToken") String authToken
    );

    @GET("/diary")
    Call<DiaryDataResponse> getDiaryData(
            @Query("authToken") String authToken,
            @Query("motherId") int motherId,
            @Query("startDate") String startDate,
            @Query("endDate") String endDate,
            @Query("breastfeeding") boolean breastfeeding,
            @Query("supplement") boolean supplement,
            @Query("output") boolean output,
            @Query("healthIssues") boolean healthIssues
    );

    @GET("/notifications")
    Call<NotificationResponse> getNotifications(
            @Query("authToken") String authToken,
            @Query("motherId") int motherId
    );

    @GET("/diary")
    Call<DiaryDataResponse> getDiaryData(
            @Query("authToken") String authToken,
            @Query("motherId") int motherId
    );
}
