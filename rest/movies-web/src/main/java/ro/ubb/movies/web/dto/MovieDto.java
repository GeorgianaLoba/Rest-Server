package ro.ubb.movies.web.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
public class MovieDto extends BaseDto {
    private String title;
    private String director;
    private Integer rating;
    private Integer releaseYear;
}

