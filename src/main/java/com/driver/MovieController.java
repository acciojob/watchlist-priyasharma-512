package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.HttpSessionRequiredException;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@Controller
public class MovieController {

    @Autowired
    MovieService movieservice;

    @PostMapping("/movies/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie)
    {
        movieservice.addMovie(movie);
        return new ResponseEntity("Hurrah! Movie is added" , HttpStatus.CREATED);
    }

    @PostMapping("/movies/add-director")
    public ResponseEntity<String> addDirector(@RequestBody Director director)
    {
        movieservice.addDirector(director);
        return new ResponseEntity(" director added", HttpStatus.CREATED);
    }

    @PutMapping("/movies/add-movie-director-pair")
    public  ResponseEntity<String> addMovieDirectorPair(@RequestParam String movie, @RequestParam String director)
    {
        movieservice.addMovieDirectorPair(movie,director);
        retuen new ResponseEntity("created!!", HttpStatus.CREATED);
    }

    @GetMapping("/movies/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable String name)
    {
        Movie movie = movieservice.getMovieByName(name);
        return new ResponseEntity<>(movie, HttpStatus.CREATED);
    }

    @GetMapping("/movies/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable String name)
    {
        Director director = movieservice.getDirectorByName(name);
        return new ResponseEntity(director, HttpStatus.CREATED);
    }

    @GetMapping("/movies/get-movies-by-director-name/{director}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable String director)
    {
       List<String> movies = movieservice.getMoviesByDirectorName(director);
        return new ResponseEntity(movies, HttpStatus.CREATED);
    }

    @GetMapping("/movies/get-all-movies")
    public ResponseEntity<List<String>> findAllMovies()
    {
        List<String> movies = movieservice.findAllMovies();
        return new ResponseEntity(movies,HttpStatus.CREATED);
    }

    @DeleteMapping("/movies/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam String director)
    {
        movieservice.deleteDirectorByName(director);
        return new ResponseEntity("deletion sucessfull", HttpStatus.CREATED);
    }

    @DeleteMapping("/movies/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors()
    {
        movieservice.deleteAllDirectors();
        return new ResponseEntity("Deleted all directors successfully", HttpStatus.CREATED);
    }
}
