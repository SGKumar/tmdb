package tmdb.models;

//import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;

import info.movito.themoviedbapi.model.Genre;
import info.movito.themoviedbapi.TmdbApi;
//import info.movito.themoviedbapi.TmdbGenre;
//import info.movito.themoviedbapi.model.MovieDb;

import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;
import java.util.List;

@Component
public class TMDBGenreList implements GenreList {
    private Map<Integer, Genre> genreIds;
    private Map<String, Genre> genres;

    @Value("${tmdb.key}")
    private String tmdbKey;

    @PostConstruct
    public void initialize() {
        List<Genre> list = new TmdbApi(tmdbKey).getGenre().getGenreList("en");
        genreIds = new ConcurrentHashMap<Integer, Genre>();
        genres = new ConcurrentHashMap<String, Genre>();

        for(Genre g : list) {
            genreIds.put(g.getId(), g);
            genres.put(g.getName(), g);
        }
    }

    @Override
    public Genre getById (int id) {
        return genreIds.get(id);
    }

    @Override
    public Genre getByName (String name) {
        return genres.get(name);
    }
}
