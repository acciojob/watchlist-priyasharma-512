package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@Service
public class MovieService {

    @Autowired
    MovieRepository movierepository;

    public void addMovie(Movie movie)
    {
        movierepository.addMovietoDB(movie);
    }

    public void addDirector(Director director)
    {
        movierepository.addDirectortoDB(director);
    }

    public void addMovieDirectorPair(String movie,String director)
    {
        return movierepository.addMovieDirectorPairtoDB(director);
    }

    public Movie getMovieByName(String name)
    {
        return movierepository.getMovieByNametoDB(name);
    }

    public Director getDirectorByName(String name)
    {
        return movierepository.getDirectorByNametoDB(name);
    }

    public List<String> getMoviesByDirectorName(String director)
    {
        return movierepository.getMoviesByDirectorNametoDB(director);
    }

    public List<String> findAllMovies()
    {
        return movierepository.findAllMoviestoDB();
    }

    public void deleteDirectorByName(String director)
    {
        movierepository.deleteDirectorByNametoDB(director);
    }

    public void deleteAllDirectors()
    {
        movierepository.deleteAllDirectorstoDB();
    }

}
