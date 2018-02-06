package com.example.usuario.icantfindjson.Network;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by usuario on 6/02/18.
 */

public class ApiAdapter {
    private static ApiService API_SERVICE;

    public static ApiService getApiService()
    {
        // Creamos un interceptor y le indicamos el log level a usar
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        // Asociamos el interceptor a las peticiones
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);

        String baseUrl = "https://mi-pagina.com/api/";

        if (API_SERVICE == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient.build()) // <-- usamos el log level
                    .build();
            API_SERVICE = retrofit.create(MyApiService.class);
        }

        return API_SERVICE;
    }

    public interface MyApiService {

        @GET("diseases")
        Call<DiseasesResponse> getDiseases();

        @FormUrlEncoded
        @POST("upload/photo")
        Call<SimpleResponse> postPhoto(
                @Field("image") String base64,
                @Field("extension") String extension,
                @Field("user_id") String user_id
        );

        @GET("login")
        Call<LoginResponse> getLogin(
                @Query("username") String username,
                @Query("password") String password
        );

        @FormUrlEncoded
        @POST("product")
        Call<SimpleResponse> postNewProduct(
                @Field("code") String code,
                @Field("name") String name,
                @Field("description") String description
        );

    }
}
