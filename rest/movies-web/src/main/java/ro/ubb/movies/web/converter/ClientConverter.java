package ro.ubb.movies.web.converter;

import org.springframework.stereotype.Component;
import ro.ubb.movies.core.model.Client;
import ro.ubb.movies.web.dto.ClientDto;

@Component
public class ClientConverter extends BaseConverter<Client, ClientDto> {
    @Override
    public Client convertDtoToModel(ClientDto dto) {
        Client client = Client.builder()
                .name(dto.getName())
                .city(dto.getCity())
                .birthYear(dto.getBirthYear())
                .build();
        client.setId(dto.getId());
        return client;
    }

    @Override
    public ClientDto convertModelToDto(Client client) {
        ClientDto clientDto = ClientDto.builder()
                .name(client.getName())
                .city(client.getCity())
                .birthYear(client.getBirthYear())
                .build();
        clientDto.setId(client.getId());
        return clientDto;
    }
}
