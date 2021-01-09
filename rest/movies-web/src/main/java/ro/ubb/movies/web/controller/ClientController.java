package ro.ubb.movies.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.ubb.movies.core.service.ClientService;
import ro.ubb.movies.web.converter.ClientConverter;
import ro.ubb.movies.web.dto.ClientDto;
import ro.ubb.movies.web.dto.ClientsDto;

@RestController
public class ClientController {
    public static final Logger log= LoggerFactory.getLogger(ClientController.class);
    @Autowired
    private ClientService clientService;
    @Autowired
    private ClientConverter clientConverter;

    @RequestMapping(value = "/clients", method = RequestMethod.GET)
    ClientsDto getClients(){
        log.trace("getClients --- method started");
        ClientsDto clients = new ClientsDto(clientConverter.convertModelsToDtos(clientService.findAll()));
        log.trace("getClients: clients={}", clients);
        return clients;
    }

    @RequestMapping(value = "/clients", method = RequestMethod.POST)
    ClientDto saveClient(@RequestBody ClientDto clientDto){
        log.trace("saveClient: client={}", clientDto);
        ClientDto client = clientConverter.convertModelToDto(clientService.saveClient(clientConverter.convertDtoToModel(clientDto)));
        log.trace("saveClient --- method finished");
        return client;
    }

    @RequestMapping(value="/clients/{id}", method = RequestMethod.PUT)
    ClientDto updateClient(@PathVariable Long id, @RequestBody ClientDto clientDto){
        log.trace("updateClient: id={}, client={}", id, clientDto);
        ClientDto client = clientConverter.convertModelToDto(clientService.updateClient(id, clientConverter.convertDtoToModel(clientDto)));
        log.trace("updateClient: client={}", client);
        return client;
    }

    @RequestMapping(value = "/clients/{id}", method = RequestMethod.DELETE)
    ResponseEntity<?> deleteClient(@PathVariable Long id){
        log.trace("deleteClient: id={}", id);
        clientService.deleteClient(id);
        log.trace("deleteClient --- method finished");
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
