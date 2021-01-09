package ro.ubb.movies.core.service;

import ro.ubb.movies.core.model.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> findAll();
    Movie updateMovie(Long id, Movie movie);
    Movie saveMovie(Movie movie);
    void deleteMovie(Long id);
    boolean isPresent(Long id);
}
