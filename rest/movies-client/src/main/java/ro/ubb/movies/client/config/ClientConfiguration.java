package ro.ubb.movies.client.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import ro.ubb.movies.client.ui.Console;

/**
 * Created by radu.
 */
@Configuration
public class ClientConfiguration {
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
    @Bean
    Console console(){ return new Console();}
}
