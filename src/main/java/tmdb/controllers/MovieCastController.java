package tmdb.controllers;

import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import javax.validation.constraints.Size;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Value;

import info.movito.themoviedbapi.TmdbPeople.PersonResultsPage;

import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.model.Discover;
import info.movito.themoviedbapi.model.core.MovieResultsPage;
import info.movito.themoviedbapi.model.core.ResponseStatusException;

@RestController
public class MovieCastController {

    @Value("${tmdb.key}")
    private String tmdbKey;
    private TmdbApi tmdbApi;

    @PostConstruct
    public void initialize() {
        tmdbApi = new TmdbApi(tmdbKey);
    }

    // default has NO DEEP FETCH - no cast, crew etc.,
    @GetMapping("/api/cast")
    public PersonResultsPage getActor(@RequestParam @Size(min = 3, message = "actor name should be atleast 3 chars") String name) {
        try {
            // TODO movie could be null, check that later
            // PersonResultsPage cast = tmdbApi.getSearch().searchPerson(name, false, 1);
            return tmdbApi.getSearch().searchPerson(name, false, 1);
        }
        catch(ResponseStatusException e) {
            //log it here.
            throw e;
        }
    }

    @GetMapping("/api/cast/{actorId}/movies")
    public MovieResultsPage getMovies(@PathVariable Integer actorId, @RequestParam(value="coActors", defaultValue="") String coActors) {

        try {
            Discover d = new Discover();
            Map<String, String> params = d.getParams();
            StringBuilder allActors = new StringBuilder(128);
            allActors.append(actorId);
            if(!"".equals(coActors)) {
                allActors.append(",").append(coActors);
            }
            params.put("with_cast", allActors.toString());

            return tmdbApi.getDiscover().getDiscover(d);
        }
        catch(ResponseStatusException e) {
            //log it here.
            throw e;
        }
    }
}