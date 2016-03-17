package com.udacity.talniya.popularmovies;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.udacity.talniya.entity.Movie;
import com.udacity.talniya.entity.PopularMovies;
import com.udacity.talniya.service.MovieDbAPI;
import com.udacity.talniya.util.ImageAdapter;
import com.udacity.talniya.util.UdacityUtil;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements View.OnClickListener {

    private static final String baseURL = "http://api.themoviedb.org/";
    private static final String POPULARITY = "popularity.desc";
    private static final String RATED = "vote_average.desc";
    private static final String key ="995ea1569ea5c8712ad558a07ab83e90";
    private static final String imgBaseURL = "http://image.tmdb.org/t/p/w154";
    private PopularMovies popularMovies = null;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main, container, false);
        setHasOptionsMenu(true);
    //    addClickHandler( view );

        getMoviesBy( POPULARITY );


        return view;
    }



    private void getMoviesBy( String sortBy ){


        Retrofit retrofit = UdacityUtil.getRetrofit(baseURL);

        MovieDbAPI movieAPI = retrofit.create(MovieDbAPI.class);

        Call<PopularMovies> call =  movieAPI.getPopularMovies(sortBy, key);

        call.enqueue(new Callback<PopularMovies>() {
            @Override
            public void onResponse(Response<PopularMovies> response, Retrofit retrofit) {

                getView().findViewById(R.id.loadingPanel).setVisibility(View.GONE);

                popularMovies = response.body();


                if (popularMovies != null && popularMovies.getMovies().size() > 0)

                    initPopularMovieDashboard();

            }

            @Override
            public void onFailure(Throwable t) {

            }
        });


    }



    public void initPopularMovieDashboard(){


        GridView gridView = (GridView) getView().findViewById(R.id.gridView1);

        ImageAdapter imageAdapter = new ImageAdapter(getContext());
        imageAdapter.setBaseURL(imgBaseURL);

        String[] imgURLs = new String[20];

        int index = 0;

        for( Movie movie : popularMovies.getMovies() ) {
            imgURLs[index] = movie.getPosterPath();
            index ++;
        }

        imageAdapter.setImgURL(imgURLs);

        gridView.setAdapter(imageAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position > -1) {
                    Intent intent = new Intent(getActivity(), MovieDetailActivity.class);
                    intent.putExtra("Movie", popularMovies.getMovies().get(position));

                    startActivity(intent);

                }
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        Log.d("Debug information","Item clicked");
        switch (item.getItemId()) {
            case R.id.highest_rated:
                 getMoviesBy(RATED);
                return true;
            case R.id.most_popular:
                 getMoviesBy(POPULARITY);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }


    }


    @Override
    public void onClick(View v) {



    }
}
