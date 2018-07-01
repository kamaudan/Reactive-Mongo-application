package com.github.kamaudan.repository;

import com.github.kamaudan.model.Movie;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MovieRepository extends ReactiveMongoRepository<Movie, String> {




}
