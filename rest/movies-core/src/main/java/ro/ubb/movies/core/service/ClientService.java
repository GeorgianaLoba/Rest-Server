package ro.ubb.movies.core.service;

import ro.ubb.movies.core.model.Client;

import java.util.List;


public interface ClientService {
    List<Client> findAll();
    Client updateClient(Long id, Client client);
    Client saveClient(Client client);
    boolean isPresent(Long id);
    void deleteClient(Long id);
}
