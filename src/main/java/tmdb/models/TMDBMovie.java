package tmdb.models;

import java.util.List;
import info.movito.themoviedbapi.model.MovieDb;
import info.movito.themoviedbapi.model.people.PersonCast;
import info.movito.themoviedbapi.model.people.PersonCrew;

public class TMDBMovie {
	
	//required parameter
	private MovieDb movie;
	
	//optional parameters
    private List<PersonCast> cast;
    private List<PersonCrew> crew;

	public MovieDb getMovie() {
		return movie;
	}

	public List<PersonCast> getCast() {
		return cast;
	}

    public List<PersonCrew> getCrew() {
		return crew;
	}
	
	private TMDBMovie(MovieBuilder builder) {
		this.movie=builder.movie;
		this.cast=builder.cast;
		this.crew=builder.crew;
	}
	
	//Builder Class
	public static class MovieBuilder {

        //required parameter
        private MovieDb movie;
        
        //optional parameters
        private List<PersonCast> cast;
        private List<PersonCrew> crew;
		
		public MovieBuilder(MovieDb movie) {
			this.movie = movie;
		}

		public MovieBuilder setCast(List<PersonCast> cast) {
			this.cast = cast;
			return this;
		}

		public MovieBuilder setCrew(List<PersonCrew> crew) {
			this.crew = crew;
			return this;
		}
		
		public TMDBMovie build() {
			return new TMDBMovie(this);
		}

	}

}