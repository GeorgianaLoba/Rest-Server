package ro.ubb.movies.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MoviesDto {
    private Set<MovieDto> movies;

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        movies.forEach(m->{
            builder.append(m);
            builder.append('\n');
        });
        return builder.toString();
    }
}
