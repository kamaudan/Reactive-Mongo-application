package com.github.kamaudan.resource;

import com.github.kamaudan.repository.MovieRepository;
import com.github.kamaudan.model.Movie;
import com.github.kamaudan.model.MovieEvents;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import java.time.Duration;
import java.util.Date;
import java.util.Random;
import java.util.stream.Stream;

@RestController
@RequestMapping("/")
public class MovieResource {


    private MovieRepository movieRepository;

    public MovieResource(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @GetMapping("/all")
    public Flux<Movie> getAll() {
        return movieRepository
                .findAll();
    }

    @GetMapping("/{id}")
    public Mono<Movie> getId(@PathVariable("id") final String id) {
        return movieRepository.findById(id);
    }


    @GetMapping(value = "/{id}/events", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<MovieEvents> getEvents(@PathVariable("id")
                                    final String id) {
        return movieRepository.findById(id)
                .flatMapMany(movie -> {

                    Flux<Long> interval = Flux.interval(Duration.ofSeconds(2));

                    Flux<MovieEvents> movieEventsFlux =

                            Flux.fromStream(
                                    Stream.generate(() -> new MovieEvents(movie,
                                            new Date(),randomUser()))
                            );


                    return Flux.zip(interval, movieEventsFlux)
                            .map(Tuple2::getT2);

                });

    }

    private String randomUser() {
        String[] users = " Dan, Carol, Peris, David, Josiah, Ian, Didi, Uhuru, Ruto, Magreat, Samuel".split(",");
        return users[new Random().nextInt(users.length)];
    }






}
