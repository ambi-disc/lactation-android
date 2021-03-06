package org.lactor.consultant.core.webrequests;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LactorApiHelper {
    private static LactorApi lactorApi;
    private static String apiUrl = "http://hypermoon.matthewpage.xyz:5000/";

    public static LactorApi getInstance() {
        if (lactorApi == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(apiUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            lactorApi = retrofit.create(LactorApi.class);
        }

        return lactorApi;
    }
}
