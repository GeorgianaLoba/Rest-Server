package ro.ubb.movies.core.service;

import ro.ubb.movies.core.model.Rental;

import java.util.List;

public interface RentalService {
    List<Rental> findAll();
    void saveRental(Rental rental);
    void deleteRental(Long id);
    boolean isPresent(Rental rental);
    void deleteRentalsOfMovie(Long movieId);
    void deleteRentalsOfClient(Long clientId);

}
