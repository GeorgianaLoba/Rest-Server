package ro.ubb.movies.web.converter;

import org.springframework.stereotype.Component;
import ro.ubb.movies.core.model.Movie;
import ro.ubb.movies.web.dto.MovieDto;

@Component
public class MovieConverter extends BaseConverter<Movie, MovieDto> {
    @Override
    public Movie convertDtoToModel(MovieDto dto) {
        Movie movie = Movie.builder()
                .title(dto.getTitle())
                .director(dto.getDirector())
                .rating(dto.getRating())
                .releaseYear(dto.getReleaseYear())
                .build();
        movie.setId(dto.getId());
        return movie;
    }
    @Override
    public MovieDto convertModelToDto(Movie movie) {
        MovieDto movieDto = MovieDto.builder()
                .title(movie.getTitle())
                .director(movie.getDirector())
                .rating(movie.getRating())
                .releaseYear(movie.getReleaseYear())
                .build();
        movieDto.setId(movie.getId());
        return movieDto;
    }
}
