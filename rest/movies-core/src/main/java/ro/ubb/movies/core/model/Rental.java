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
public class Rental extends BaseEntity<Long>{
    private Long movieId;
    private Long clientId;
}
