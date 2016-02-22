package com.udacity.talniya.service;

import com.udacity.talniya.entity.PopularMovies;

import java.util.List;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by talniya on 18/2/16.
 */
public interface MovieDbAPI {

   @GET ("3/discover/movie/")
   Call<PopularMovies> getPopularMovies(@Query("sort_by") String sort_by, @Query("api_key") String key);


}
