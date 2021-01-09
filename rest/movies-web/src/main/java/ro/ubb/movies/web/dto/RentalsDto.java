package ro.ubb.movies.web.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RentalsDto {
    private Set<RentalDto> rentals;


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        rentals.forEach(r->{
            builder.append(r);
            builder.append('\n');
        });
        return builder.toString();
    }
}
