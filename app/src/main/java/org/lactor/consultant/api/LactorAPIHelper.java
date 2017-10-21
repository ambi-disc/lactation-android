package org.lactor.consultant.api;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LactorAPIHelper {
    private static LactorApi lactorApi;
    private static String apiUrl = "http://eclipse.matthewpage.xyz:5000/";

    public static LactorAPI getInstance() {
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
