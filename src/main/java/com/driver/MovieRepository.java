package com.driver;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MovieRepository {

    Map<String, Movie> movieHashMap = new HashMap<>();
    Map<String, Director> directorHashMap = new HashMap<>();
    Map<String, List<String>> directormovieHashMap = new HashMap<>();

    public void addMovietoDB(Movie movie)
    {
        movieHashMap.put(movie.getName(),movie);
    }

    public void addDirectortoDB(Director director)
    {
        directorHashMap.put(director.getName(),director);
    }

    public void addMovieDirectorPairtoDB(String movie, String director)
    {
        List<String> existingmovies = new ArrayList<String>();
        if (directorHashMap.containsKey(director))
            existingmovies = directormovieHashMap.get(director);
        existingmovies.add(movie);
        directormovieHashMap.put(director, existingmovies);
    }

    public Movie getMovieByNametoDB(String movie)
    {
        return movieHashMap(movie);
    }

    public Director getDirectorByNametoDB(String director)
    {
        return directorHashMap(director);
    }

    public List<String> getMoviesByDirectorNametoDB(String director)
    {
        List<String> movieList = new ArrayList<>();
        if(directormovieHashMap.containsKey(director))
            movieList = directormovieHashMap.get(director);
        return movieList;
    }

    public List<String> findAllMoviestoDB()
    {
        return new ArrayList<>(movieHashMap.keySet());
    }

    public void deleteDirectorByNametoDB(String director)
    {
        List<String> movies = new ArrayList<String>();
        if(directormovieHashMap.containsKey(director)){
            movies = directormovieHashMap.get(director);
            for(String movie: movies){
                if(movieHashMap.containsKey(movie)){
                    movieHashMap.remove(movie);
                }
            }
            directormovieHashMap.remove(director);
        }
        if(directorHashMap.containsKey(director)){
            directorHashMap.remove(director);
        }
    }

    public void deleteAllDirectorstoDB()
    {
        HashSet<String> moviesSet = new HashSet<String>();
        for(String director: directormovieHashMap.keySet()){
            for(String movie: directormovieHashMap.get(director)){
                moviesSet.add(movie);
            }
        }
        for(String movie: moviesSet){
            if(movieHashMap.containsKey(movie)){
                movieHashMap.remove(movie);
            }
        }
    }
}
