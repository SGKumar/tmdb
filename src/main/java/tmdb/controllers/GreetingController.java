package tmdb.controllers;

import java.util.concurrent.atomic.AtomicLong;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Value;

import tmdb.models.*;
//import info.movito.themoviedbapi.TmdbMovies;
import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.model.MovieDb;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Value("${tmdb.key}")
    private String tmdbKey;
    private TmdbApi tmdbApi;

    @PostConstruct
    public void initialize() {
        tmdbApi = new TmdbApi(tmdbKey);
    }

    @RequestMapping("/api/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {

        //TmdbMovies movies = new TmdbApi("<apikey>").getMovies();
        //MovieDb movie = movies.getMovie(5353, "en");
        MovieDb movie = tmdbApi.getMovies().getMovie(5353, "en");

        // TODO movie could be null, check that later
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name + " " + movie.getTitle()));
    }
}