package org.superbiz.moviefun.movies;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MoviesController {

    private MoviesBean moviesBean;

    public MoviesController(MoviesBean moviesBean) {
        this.moviesBean = moviesBean;
    }

    @GetMapping("/movies/{id}")
    public @ResponseBody Movie find(@PathVariable Long id) {
        return moviesBean.find(id);
    }

    @PostMapping("/movies")
    public @ResponseBody void addMovie(@RequestBody Movie movie) {
        moviesBean.addMovie(movie);
    }

    @PutMapping("/movies")
    public @ResponseBody void updateMovie(@RequestBody Movie movie) {
        moviesBean.updateMovie(movie);
    }

    @DeleteMapping("/movies")
    public @ResponseBody void deleteMovie(@RequestBody Movie movie) {
        moviesBean.deleteMovie(movie);
    }

    @DeleteMapping("/movies/{i}")
    public @ResponseBody void deleteMovieId(@PathVariable long id) {
        moviesBean. deleteMovieId(id);
    }

    @GetMapping("/movies")
    public @ResponseBody List<Movie> getMovies() {
        return moviesBean.getMovies();
    }

    @GetMapping("/movies/search")
    public @ResponseBody List<Movie> findAll(@RequestParam int firstResult, @RequestParam int maxResults) {
        return moviesBean.findAll(firstResult, maxResults);
    }

    @GetMapping("/movies/count")
    public @ResponseBody int countAll() {
        return moviesBean.countAll();
    }

    @GetMapping("/movies/countByTerm")
    public @ResponseBody int count(@RequestParam String field, @RequestParam String searchTerm) {
        return moviesBean.count(field, searchTerm);
    }

    @GetMapping("/movies/range")
    public @ResponseBody List<Movie> findRange(@RequestParam String field, @RequestParam String searchTerm, @RequestParam int firstResult, @RequestParam int maxResults) {
        return moviesBean.findRange(field, searchTerm, firstResult, maxResults);
    }

    @DeleteMapping("/movies/clean")
    public @ResponseBody void clean() {
        moviesBean.clean();
    }
}
