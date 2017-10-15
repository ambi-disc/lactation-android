package org.lactor.consultant.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LactorAPIHelper {
    private static LactorAPI lactorAPI;
    private static String APIurl = "http://eclipse.matthewpage.xyz:5000/";


        public static LactorAPI getInstance() {
            if (lactorAPI == null) {

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(APIurl)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                lactorAPI = retrofit.create(LactorAPI.class);
            }

            return lactorAPI;
        }
    }
}
