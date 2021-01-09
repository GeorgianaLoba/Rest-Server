package ro.ubb.movies.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ClientsDto {
    private Set<ClientDto> clients;

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        clients.forEach(c->{
            builder.append(c);
            builder.append('\n');
        });
        return builder.toString();
    }
}
