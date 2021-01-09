package ro.ubb.movies.core.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.ubb.movies.core.model.Rental;
import ro.ubb.movies.core.repository.ClientRepository;
import ro.ubb.movies.core.repository.MovieRepository;
import ro.ubb.movies.core.repository.RentalRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RentalServiceImplementation implements RentalService{
    private static final Logger log = LoggerFactory.getLogger(RentalServiceImplementation.class);

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private RentalRepository rentalRepository;

    @Override
    public List<Rental> findAll() {
        log.trace("findAll --- method entered");
        List<Rental> rentals = rentalRepository.findAll();
        log.trace("findAll: rentals={}", rentals);
        return rentals;
    }

    @Override
    public void saveRental(Rental rental) {
        log.trace("saveRental: rental={}", rental);
        if (!movieRepository.existsById(rental.getMovieId())){
            log.trace("saveRental - method finished unsuccessfully - movieId doesn't exist. ");
            return;
        }
        if (!clientRepository.existsById(rental.getClientId())){
            log.trace("saveRental - method finished unsuccessfully - clientId doesn't exist. ");
            return;
        }
        rentalRepository.save(rental);
        log.trace("SaveRental --- method finished");
    }

    @Override
    public void deleteRental(Long id) {
        log.trace("deleteRental: id={}", id);
        rentalRepository.deleteById(id);
        log.trace("deleteRental --- method finished");
    }

    @Override
    public boolean isPresent(Rental rental) {
        log.trace("isPresent: rental={}", rental);
        boolean response = rentalRepository.findById(rental.getId()).isPresent();
        log.trace("isPresent --- method finished");
        return response;
    }

    @Override
    public void deleteRentalsOfMovie(Long movieId) {
        rentalRepository.findAll().forEach(p->{
           if (p.getMovieId().equals(movieId)){
               deleteRental(p.getId());
           }
        });
    }

    @Override
    public void deleteRentalsOfClient(Long clientId) {
        rentalRepository.findAll().forEach(p->{
            if (p.getClientId().equals(clientId)){
                deleteRental(p.getId());
            }
        });
    }
}
