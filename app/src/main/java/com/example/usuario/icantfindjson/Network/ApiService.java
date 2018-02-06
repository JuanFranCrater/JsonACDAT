package com.example.usuario.icantfindjson.Network;

import com.example.usuario.icantfindjson.pojo.Repo;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;


public interface ApiService {

    @GET("/users/{user}/repos")
    Call<ArrayList<Repo>> reposForUser(@Path("user") String user);

}
