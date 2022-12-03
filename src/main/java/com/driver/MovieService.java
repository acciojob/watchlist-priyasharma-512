package com.driver;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public void addMovie(Movie movie){
        movieRepository.addMovieRepo(movie);
    }

    public void addDirector(Director director){
        movieRepository.addDirectorRepo(director);
    }

    public void addMovieDirectorPairService(String movie, String director){
        movieRepository.addMovieDirectorPairRepo(movie, director);
    }

    public Movie getMovieByNameService(String movieName){
        return movieRepository.getMovieByNameRepo(movieName);
    }

    public Director getDirectorByNameService(String directorName){
        return movieRepository.getDirectorByNameRepo(directorName);
    }

    public List<String> getMoviesByDirectorNameService(String director){
        return movieRepository.getMoviesByDirectorNameRepo(director);
    }

    public List<String> findAllMoviesService(){
        return movieRepository.findAllMoviesRepo();
    }

    public void deleteDirectorByNameService(String director){
        movieRepository.deleteDirectorByNameRepo(director);
    }

    public void deleteAllDirectorsService(){
        movieRepository.deleteAllDirectorRepo();
    }
}