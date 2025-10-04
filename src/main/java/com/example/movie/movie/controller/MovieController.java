package com.example.movie.movie.controller;


import com.example.movie.movie.model.Movie;
import com.example.movie.movie.service.MovieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    public MovieService mvs;

    public MovieController(MovieService mvs){
        this.mvs = mvs;
    }

    @GetMapping
    public List<Movie> getAllMovie(){
        return mvs.getMovies();
    }

    @GetMapping("{id}")
    public Movie getMovieId(@PathVariable Long id){
        return mvs.getMovie(id);
    }

    @PostMapping
    public Movie postNewMovie(@RequestBody Movie movie){
        return mvs.createMovie(movie);
    }

    @PutMapping("/id")
    public Movie updateMovie(@RequestBody Movie movie,@PathVariable Long id){
        return mvs.updateMovie(id,movie);
    }

    @DeleteMapping("/id")
    public void deleteMovie(@PathVariable Long id){
        mvs.deleteMovie(id);
    }

}

