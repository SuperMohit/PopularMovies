package com.udacity.talniya.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

/**
 * Created by talniya on 18/2/16.
 */

@Generated("org.jsonschema2pojo")
public class PopularMovies {

    @SerializedName("page")
    @Expose
    private Integer page;

    @SerializedName("results")
    @Expose
    private List<Movie> movies = new ArrayList<>();

    @SerializedName("total_results")
    @Expose
    private Integer totalResults;

    @SerializedName("total_pages")
    @Expose
    private Integer totalPages;



    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Integer getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }



    public Integer getPage() {
        return page;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setPage(Integer page) {
        this.page = page;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    /**
     *
     * @param movies
     * The movies
     */
    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
}
