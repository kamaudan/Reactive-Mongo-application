package com.github.kamaudan.Services;

import com.github.kamaudan.model.Movie;
import com.github.kamaudan.model.MovieEvents;
import com.github.kamaudan.repository.MovieRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Date;
import java.util.Random;
import java.util.stream.Stream;

public class MovieService {

    private final MovieRepository movieRepository;

    public Flux<MovieEvents> streamStreams(Movie movie) {
        Flux<Long> interval = Flux.interval(Duration.ofSeconds(1));
        Flux<MovieEvents> events = Flux.fromStream(Stream.generate(() -> new MovieEvents(movie, new Date(), randomUser())));

        return Flux.zip(interval, events).map(x -> x.getT2());
    }

    private String randomUser() {
        String [] users = "Savio, Swathi, Sunil, Sumit, Priya, Laxmi".split(",");
        return users[new Random().nextInt(users.length)];
    }

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }


    public Mono<Movie> byId(String id) {
        return movieRepository.findById(id);
    }


    public Flux<Movie> all() {
        return movieRepository.findAll();
    }
}
