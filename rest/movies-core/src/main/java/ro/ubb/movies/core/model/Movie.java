package ro.ubb.movies.core.model;

import lombok.*;

import javax.persistence.Entity;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
public class Movie extends BaseEntity<Long>{
    private String title;
    private String director;
    private Integer rating;
    private Integer releaseYear;
}
