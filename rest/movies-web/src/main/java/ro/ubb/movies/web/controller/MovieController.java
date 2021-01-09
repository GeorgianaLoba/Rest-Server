package ro.ubb.movies.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.ubb.movies.core.service.MovieService;
import ro.ubb.movies.web.converter.MovieConverter;
import ro.ubb.movies.web.dto.MovieDto;
import ro.ubb.movies.web.dto.MoviesDto;

@RestController
public class MovieController {
    public static final Logger log= LoggerFactory.getLogger(MovieController.class);
    @Autowired
    private MovieService movieService;
    @Autowired
    private MovieConverter movieConverter;

    @RequestMapping(value = "/movies", method = RequestMethod.GET)
    MoviesDto getMovies() {
        log.trace("getMovies: --- method started");
        MoviesDto movies =  new MoviesDto(movieConverter
                .convertModelsToDtos(movieService.findAll()));
        log.trace("getMovies: movies={}", movies);
        return movies;
    }

    @RequestMapping(value = "/movies", method = RequestMethod.POST)
    MovieDto saveMovie(@RequestBody MovieDto movieDto) {
        log.trace("saveMovie: movie={}", movieDto);
        MovieDto movie= movieConverter.convertModelToDto(movieService.saveMovie(
                movieConverter.convertDtoToModel(movieDto)));
        log.trace("saveClient --- method finished");
        return movie;
    }

    @RequestMapping(value = "/movies/{id}", method = RequestMethod.PUT)
    MovieDto updateMovie(@PathVariable Long id,
                             @RequestBody MovieDto movieDto) {
        //todo: log
        return movieConverter.convertModelToDto( movieService.updateMovie(id,
                movieConverter.convertDtoToModel(movieDto)));
    }

    @RequestMapping(value = "/movies/{id}", method = RequestMethod.DELETE)
    ResponseEntity<?> deleteStudent(@PathVariable Long id){
        movieService.deleteMovie(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
