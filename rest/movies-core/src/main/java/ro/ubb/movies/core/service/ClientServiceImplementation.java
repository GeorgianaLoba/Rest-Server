package ro.ubb.movies.core.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.ubb.movies.core.model.Client;
import ro.ubb.movies.core.repository.ClientRepository;

import java.util.List;

@Service
public class ClientServiceImplementation implements ClientService{
   private static final Logger log = LoggerFactory.getLogger(ClientServiceImplementation.class);

   @Autowired
   private ClientRepository clientRepository;

    @Override
    public List<Client> findAll() {
        log.trace("findAll --- method entered");
        List<Client> clients = clientRepository.findAll();
        log.trace("findAll: clients={}", clients);
        return clients;
    }

    @Override
    @Transactional
    public Client updateClient(Long id, Client client) {
        log.trace("updateClient: id={}, client={}", id, client);
        Client update = clientRepository.findById(id).orElse(client);
        update.setName(client.getName());
        update.setCity(client.getCity());
        update.setBirthYear(client.getBirthYear());
        log.trace("updateClient: client={}", update);
        return update;
    }

    @Override
    public Client saveClient(Client client) {
        log.trace("saveClient: client={}", client);
        Client c = clientRepository.save(client);
        log.trace("saveClient --- method finished");
        return c;
    }

    @Override
    public boolean isPresent(Long id) {
        return clientRepository.existsById(id);
    }

    @Override
    public void deleteClient(Long id) {
        log.trace("deleteClient: id={}", id);
        clientRepository.deleteById(id);
        log.trace("deleteClient --- method finished");
    }
}
