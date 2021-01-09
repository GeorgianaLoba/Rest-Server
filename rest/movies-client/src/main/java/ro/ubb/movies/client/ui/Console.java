package ro.ubb.movies.client.ui;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;
import ro.ubb.movies.core.model.Client;
import ro.ubb.movies.core.model.Movie;
import ro.ubb.movies.core.model.Rental;
import ro.ubb.movies.web.dto.*;

import java.util.Scanner;

public class Console {
    private final String moviesURL = "http://localhost:8080/api/movies";
    private final String clientsURL = "http://localhost:8080/api/clients";
    private final String rentalsURL = "http://localhost:8080/api/rentals";

    @Autowired
    RestTemplate restTemplate;

    public void runConsole(){
        printMenu();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running){
            try {
                int input = scanner.nextInt();
                switch (input) {
                    case 1:
                        addMovie();
                        break;
                    case 2:
                        addClient();
                        break;
                    case 3:
                        addRental();
                        break;
                    case 4:
                        printAllMovies();
                        break;
                    case 5:
                        printAllClients();
                        break;
                    case 6:
                        printAllRentals();
                        break;
                    case 7:
                        updateMovie();
                        break;
                    case 8:
                        updateClient();
                        break;
                    case 9:
                        deleteMovie();
                        break;
                    case 10:
                        deleteClient();
                        break;
                    case 11:
                        deleteRental();
                        break;
                    case 0:
                        running = false;
                        break;
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }
            printMenu();
        }
        System.out.println("seeya!");
    }

    private void deleteRental() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the id of the rental you want to delete: ");
        Long id = scanner.nextLong();
        restTemplate.delete(rentalsURL + "/{id}", id);
    }

    private void deleteClient() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the id of the client you want to delete: ");
        Long id = scanner.nextLong();
        restTemplate.delete(clientsURL + "/{id}", id);
        restTemplate.delete(rentalsURL + "/client{clientId}", id);
    }

    private void deleteMovie() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the id of the movie you want to delete: ");
        Long id = scanner.nextLong();
        restTemplate.delete(moviesURL + "/{id}", id);
        restTemplate.delete(rentalsURL + "/movie{movieID}", id);
    }

    private void updateClient() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the id of the client you want to update: ");
        Long id = scanner.nextLong();
        Client client = readClient();
        restTemplate.put(clientsURL + "/{id}", client, id);

    }

    private void updateMovie() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the id of the movie you want to update: ");
        Long id = scanner.nextLong();
        Movie movie = readMovie();
        restTemplate.put(moviesURL + "/{id}", movie, id);
    }

    private void printAllRentals() {
        RentalsDto rentals = restTemplate.getForObject(rentalsURL, RentalsDto.class);
        System.out.println(rentals);
    }

    private void printAllClients() {
        ClientsDto clients = restTemplate.getForObject(clientsURL, ClientsDto.class);
        System.out.println(clients);
    }

    private void printAllMovies() {
        MoviesDto movies = restTemplate.getForObject(moviesURL, MoviesDto.class);
        System.out.println(movies);
    }

    private void addRental() {
        Rental rental = readRental();
        restTemplate.postForObject(rentalsURL, rental, RentalDto.class);
    }

    private void addClient() {
        Client client = readClient();
        restTemplate.postForObject(clientsURL, client, ClientDto.class);
    }

    private void addMovie() {
        Movie movie = readMovie();
        restTemplate.postForObject(moviesURL,movie, MovieDto.class);
    }


    private void printMenu(){
        System.out.println("What do u wanna do: ");
        System.out.println("Press 1 to add movie.");
        System.out.println("Press 2 to add client");
        System.out.println("Press 3 to add rental");
        System.out.println("Press 4 to print all movies.");
        System.out.println("Press 5 to print all clients.");
        System.out.println("Press 6 to print all rentals.");
        System.out.println("Press 7 to update movie");
        System.out.println("Press 8 to update client");
        System.out.println("Press 9 to delete movie");
        System.out.println("Press 10 to delete client");
        System.out.println("Press 11 to delete rental");
        System.out.println("Press 0 to exit");
    }

    private Movie readMovie(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Title: ");
        String title = scanner.nextLine();
        System.out.println("Director: ");
        String director = scanner.nextLine();
        System.out.println("Rating: ");
        Integer rating = scanner.nextInt();
        System.out.println("Release Year: ");
        Integer releaseYear = scanner.nextInt();
        return new Movie(title, director, rating, releaseYear);
    }

    private Client readClient(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Name: ");
        String name = scanner.nextLine();
        System.out.println("City: ");
        String city = scanner.nextLine();
        System.out.println("Birth Year: ");
        Integer birthYear = scanner.nextInt();
        return new Client(name, city, birthYear);
    }

    private Rental readRental(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the id of the movie you want to rent: ");
        Long movieId = scanner.nextLong();
        System.out.println("Enter your client id: ");
        Long clientId = scanner.nextLong();
        return new Rental(movieId, clientId);
    }

}
