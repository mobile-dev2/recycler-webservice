package com.example.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET(Constants.API_USERS)
    Call<Response> getUsers();
}
