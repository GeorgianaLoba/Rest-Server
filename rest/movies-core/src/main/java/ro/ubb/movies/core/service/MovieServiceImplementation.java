package ro.ubb.movies.core.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.ubb.movies.core.model.Movie;
import ro.ubb.movies.core.repository.MovieRepository;

import java.util.List;

@Service
public class MovieServiceImplementation implements MovieService {
        private static final Logger log = LoggerFactory.getLogger(MovieServiceImplementation.class);

        @Autowired
        private MovieRepository movieRepository;

        @Override
        public List<Movie> findAll() {
            log.trace("findAll --- method entered");
            List<Movie> movies = movieRepository.findAll();
            log.trace("findAll: movies={}", movies);
            return movies;
        }

        @Override
        @Transactional
        public Movie updateMovie(Long id, Movie movie) {
            log.trace("updateMovie: id={}, movie={}", id, movie);
            Movie update = movieRepository.findById(id).orElse(movie);
            update.setTitle(movie.getTitle());
            update.setDirector(movie.getDirector());
            update.setRating(movie.getRating());
            update.setReleaseYear(movie.getReleaseYear());
            log.trace("updateMovie: movie={}", update);
            return update;
        }

        @Override
        public Movie saveMovie(Movie movie) {
            log.trace("saveMovie: movie={}", movie);
            Movie m = movieRepository.save(movie);
            log.trace("saveMovie --- method finished");
            return m;
        }

        @Override
        public void deleteMovie(Long id) {
            log.trace("deleteMovie: id={}", id);
            movieRepository.deleteById(id);
            log.trace("deleteMovie --- method finished");
        }

        @Override
        public boolean isPresent(Long id) {
            return movieRepository.existsById(id);
        }
}


