package ro.ubb.movies.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.ubb.movies.core.service.RentalService;
import ro.ubb.movies.web.converter.RentalConverter;
import ro.ubb.movies.web.dto.RentalDto;
import ro.ubb.movies.web.dto.RentalsDto;

@RestController
public class RentalController {
    public static final Logger log= LoggerFactory.getLogger(ClientController.class);
    @Autowired
    private RentalService rentalService;
    @Autowired
    private RentalConverter rentalConverter;


    @RequestMapping(value = "/rentals", method= RequestMethod.GET)
    RentalsDto getRentals(){
        log.trace("getRentals --- method started");
        RentalsDto rentals = new RentalsDto(rentalConverter.convertModelsToDtos(rentalService.findAll()));
        log.trace("getRentals: rentals={}", rentals);
        return rentals;
    }

    @RequestMapping(value= "/rentals", method = RequestMethod.POST)
    ResponseEntity<?> saveRental(@RequestBody RentalDto rentalDto){
        log.trace("saveRental: rental={}", rentalDto);
        rentalService.saveRental(rentalConverter.convertDtoToModel(rentalDto));
        log.trace("saveRental --- method finished");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value="/rentals/{id}", method = RequestMethod.DELETE)
    ResponseEntity<?> deleteRental(@PathVariable Long id){
        log.trace("deleteRental: id={}", id);
        rentalService.deleteRental(id);
        log.trace("deleteRental -- method finished");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value="/rentals/movie{movieId}", method = RequestMethod.DELETE)
    ResponseEntity<?> deleteRentalsOfMovie(@PathVariable Long movieId){
        log.trace("deleteRentalsOfMovie: id={}", movieId);
        rentalService.deleteRentalsOfMovie(movieId);
        log.trace("deleteRentalsOfMovie -- method finished");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value="/rentals/client{clientId}", method = RequestMethod.DELETE)
    ResponseEntity<?> deleteRentalsOfClient(@PathVariable Long clientId){
        log.trace("deleteRentalsOfClient: id={}", clientId);
        rentalService.deleteRentalsOfClient(clientId);
        log.trace("deleteRentalsOfClient -- method finished");
        return new ResponseEntity<>(HttpStatus.OK);
    }




}
