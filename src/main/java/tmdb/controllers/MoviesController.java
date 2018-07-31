package tmdb.controllers;

import java.util.Collection;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import javax.validation.constraints.Min;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Value;

import tmdb.models.*;
//import info.movito.themoviedbapi.TmdbMovies;
import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.model.MovieDb;
import info.movito.themoviedbapi.model.people.PersonCast;
import info.movito.themoviedbapi.model.people.PersonCrew;
import info.movito.themoviedbapi.model.core.ResponseStatusException;

@RestController
public class MoviesController {

    @Value("${tmdb.key}")
    private String tmdbKey;
    private TmdbApi tmdbApi;

    @PostConstruct
    public void initialize() {
        tmdbApi = new TmdbApi(tmdbKey);
    }

    // default has NO DEEP FETCH - no cast, crew etc.,
    @GetMapping("/api/movies/{movieId}")
    public TMDBMovie getMovie(@Min(1) @PathVariable Integer movieId, @RequestParam(value="deep", defaultValue="false") boolean deep) {

        try {
            // TODO movie could be null, check that later
            MovieDb movie = tmdbApi.getMovies().getMovie(movieId, "en");
            List<PersonCast> cast = null;
            List<PersonCrew> crew = null;
            if(deep) {
                cast = tmdbApi.getMovies().getCredits(movieId).getCast();
                crew = tmdbApi.getMovies().getCredits(movieId).getCrew();
            }
            return new TMDBMovie.MovieBuilder(movie).setCast(cast).setCrew(crew).build();
        }
        catch(ResponseStatusException e) {
            //log it here.
            throw e;
        }
    }

    @GetMapping("/api/movies/{movieId}/cast")
    public Collection<PersonCast> getMovieActors(@Min(1) @PathVariable Integer movieId) {

        try {
            return tmdbApi.getMovies().getCredits(movieId).getCast();
        }
        catch(ResponseStatusException e) {
            //log it here.
            throw e;
        }
    }

    @GetMapping("/api/movies/{movieId}/crew")
    public Collection<PersonCrew> getMovieCrew(@Min(1) @PathVariable Integer movieId) {

        try {
            return tmdbApi.getMovies().getCredits(movieId).getCrew();
        }
        catch(ResponseStatusException e) {
            //log it here.
            throw e;
        }
    }
}