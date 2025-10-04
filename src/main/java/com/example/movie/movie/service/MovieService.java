package com.example.movie.movie.service;

import com.example.movie.movie.exceptions.MovieNotFoundException;
import com.example.movie.movie.model.Movie;
import com.example.movie.movie.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }

    public List<Movie> getMovies(){
        return movieRepository.findAll();
    }

    public Movie getMovie(Long id){
        return movieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Movie not found with id: " + id));
    }

    public Movie createMovie(Movie movie){
        return movieRepository.save(movie);
    }

    public Movie updateMovie(Long id,Movie updateMovie){
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new MovieNotFoundException(""));
        movie.setTitle(updateMovie.getTitle());
        movie.setDirector(updateMovie.getDirector());
        movie.setReleaseYear(updateMovie.getReleaseYear());
        movie.setRating(updateMovie.getRating());
        return movieRepository.save(movie);
    }

    public void deleteMovie(Long id){
        movieRepository.deleteById(id);
    }




}
