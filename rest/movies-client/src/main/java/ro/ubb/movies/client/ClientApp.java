package ro.ubb.movies.client;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.client.RestTemplate;
import ro.ubb.movies.client.ui.Console;
import ro.ubb.movies.web.dto.MovieDto;
import ro.ubb.movies.web.dto.MoviesDto;

/**
 * Created by radu.
 */
public class ClientApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(
                        "ro.ubb.movies.client.config"
                );

        Console console = context.getBean(Console.class);
        console.runConsole();
    }
}