package tmdb.models;

import info.movito.themoviedbapi.model.Genre;

public interface GenreList {

    Genre getById(int id);
    Genre getByName(String name);
}
