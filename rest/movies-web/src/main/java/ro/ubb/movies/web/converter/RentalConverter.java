package ro.ubb.movies.web.converter;

import org.springframework.stereotype.Component;
import ro.ubb.movies.core.model.Rental;
import ro.ubb.movies.web.dto.RentalDto;

@Component
public class RentalConverter extends BaseConverter<Rental, RentalDto> {
    @Override
    public Rental convertDtoToModel(RentalDto dto) {
        Rental rental = Rental.builder()
                .movieId(dto.getMovieId())
                .clientId(dto.getClientId())
                .build();
        rental.setId(dto.getId());
        return rental;
    }

    @Override
    public RentalDto convertModelToDto(Rental rental) {
        RentalDto rentalDto = RentalDto.builder()
                .movieId(rental.getMovieId())
                .clientId(rental.getClientId())
                .build();
        rentalDto.setId(rental.getId());
        return rentalDto;
    }
}
