package org.superbiz.moviefun.moviesapi;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestOperations;

import java.util.Arrays;
import java.util.List;

public class MoviesClient {

    private String moviesUrl;
    private RestOperations restOperations;

    public MoviesClient(String moviesUrl, RestOperations restOperations) {
        this.moviesUrl = moviesUrl;
        this.restOperations = restOperations;
    }

    public MovieInfo find(Long id) {
        MovieInfo resp = restOperations.getForObject(moviesUrl +    "/movies/{id}", MovieInfo.class, id);
        return resp;
    }

    public void addMovie(MovieInfo movie) {
        restOperations.postForObject(moviesUrl + "/movies", movie, Void.class);
    }

    public void updateMovie(MovieInfo movie) {
        restOperations.put(moviesUrl + "/movies", movie);
    }

    public void deleteMovie(MovieInfo movie) {
        restOperations.delete(moviesUrl + "/movies", movie);
    }

    public void deleteMovieId(long id) {
        restOperations.delete(moviesUrl + "/movies/{i}", id);
    }

    public List<MovieInfo> getMovies() {
        MovieInfo[] movies = restOperations.getForObject(moviesUrl + "/movies", MovieInfo[].class);
        return Arrays.asList(movies);
    }

    public List<MovieInfo> findAll(int firstResult, int maxResults) {
        MovieInfo[] movies = restOperations.getForObject(moviesUrl + "/movies/search?firstResult={firstResult}&maxResults={maxResults}", MovieInfo[].class, firstResult, maxResults);
        return Arrays.asList(movies);
    }

    public int countAll() {
        return restOperations.getForObject(moviesUrl + "/movies/count", Integer.class);
    }

    public int count(String field, String searchTerm) {

        return restOperations.getForObject(moviesUrl + "/movies/countByTerm?field={field}&searchTerm={searchTerm}", Integer.class, field, searchTerm);
    }

    public List<MovieInfo> findRange(String field, String searchTerm, int firstResult, int maxResults) {
        MovieInfo[] movies = restOperations.getForObject(moviesUrl + "/movies/range?field={field}&searchTerm={searchTerm}&firstResult={firstResult}&maxResults={maxResults}", MovieInfo[].class,
                field, searchTerm, firstResult, maxResults);
        return Arrays.asList(movies);
    }

    public void clean() {
        restOperations.delete(moviesUrl + "/movies/clean");
    }
}
