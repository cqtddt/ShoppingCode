package com.shoping.mall.study.retrofit2.api;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;

import com.shoping.mall.study.retrofit2.model.User;



public interface GitHubService {
    @GET("/users/{username}")
    Call<User> getUser(@Path("username") String username);
}
