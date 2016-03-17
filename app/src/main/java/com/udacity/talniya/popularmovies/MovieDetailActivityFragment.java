package com.udacity.talniya.popularmovies;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.graphics.Palette;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.udacity.talniya.entity.Movie;

/**
 * A placeholder fragment containing a simple view.
 */
public class MovieDetailActivityFragment extends Fragment {

    private static final String imgBaseURL = "http://image.tmdb.org/t/p/w154";
    private static final String posterURL = "http://image.tmdb.org/t/p/w500";

    public MovieDetailActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_movie_detail, container, false);

        getDataFromIntent(view);

        return view;
    }

    private void getDataFromIntent(View view) {

        Intent intent = getActivity().getIntent();
        Movie movie = (Movie) intent.getSerializableExtra("Movie");

        if (movie != null)
            initViewData(movie, view);

    }

    private void initViewData(Movie movie, View view) {

        ImageView coverImage = (ImageView) view.findViewById(R.id.coverImage);
        ImageView profImage = (ImageView) view.findViewById(R.id.profView);
        TextView title = (TextView) view.findViewById(R.id.title);
        TextView year = (TextView) view.findViewById(R.id.year);
        TextView duration = (TextView) view.findViewById(R.id.duration);
        TextView ratings = (TextView) view.findViewById(R.id.ratings);
        TextView overview = (TextView) view.findViewById(R.id.overview);

        Picasso.with(getContext()).load(posterURL + movie.getPosterPath()).into(coverImage);
        Picasso.with(getContext()).load(imgBaseURL + movie.getPosterPath()).into(profImage);

        title.setText(movie.getOriginalTitle());
        year.setText(movie.getReleaseDate());
        duration.setText("120 minutes");
        ratings.setText(movie.getVoteAverage() + "");
        overview.setText(movie.getOverview());
        view.findViewById(R.id.loadingPaneldetail).setVisibility(View.GONE);
    }

//
//    private void initBackgroundColor() {
//
//        Palette.PaletteAsyncListener paletteListener = new Palette.PaletteAsyncListener() {
//            public void onGenerated(Palette palette) {
//
//            }
//        };
//
//        Bitmap myBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.nyancat);
//        if (myBitmap != null && !myBitmap.isRecycled())
//            Palette.from(myBitmap).generate(paletteListener);
//
//
//    }
}