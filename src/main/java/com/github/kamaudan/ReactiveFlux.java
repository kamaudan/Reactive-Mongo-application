package com.github.kamaudan;

import com.github.kamaudan.model.Movie;
import com.github.kamaudan.repository.MovieRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;
import java.util.stream.Stream;


@SpringBootApplication
public class ReactiveFlux {

	@Bean
	CommandLineRunner movies(MovieRepository movieRepository) {

		return args -> {
			movieRepository
					.deleteAll()
                    .subscribe(null, null, () -> {

				Stream.of(new Movie(UUID.randomUUID().toString(),"Black Panther", 5L),
						new Movie(UUID.randomUUID().toString(), "Infinity War", 8L),
						new Movie(UUID.randomUUID().toString(), "Thor", 10L),
						new Movie(UUID.randomUUID().toString(),"Back to the Future", 15L),
						new Movie(UUID.randomUUID().toString(),"Wonder woman", 18L),
						new Movie(UUID.randomUUID().toString(),"12 strong", 16L),
						new Movie(UUID.randomUUID().toString(),"Designated Survivor", 35L),
						new Movie(UUID.randomUUID().toString(),"Scorpion", 29L),
						new Movie(UUID.randomUUID().toString(),"Suits", 32L),
						new Movie(UUID.randomUUID().toString(),"Wisdom of the crowd", 17L),
						new Movie(UUID.randomUUID().toString(),"Deep State", 27L),
						new Movie(UUID.randomUUID().toString(),"Reed  between the lines", 2L),
						new Movie(UUID.randomUUID().toString(),"Moana", 40L),
						new Movie(UUID.randomUUID().toString(),"Zootopia", 22L)
						)
						.forEach(movie -> {
				movieRepository
						.save(movie)
						.subscribe(System.out::println);

						});

			})
			;
		};

	}

    public static void main(String[] args) {
        SpringApplication.run(ReactiveFlux.class, args);
    }

}
