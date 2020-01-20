package com.project.example.model.imdb.Movie_p;

import com.project.example.model.imdb.imdbException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class movieController {

    @Autowired
    public movieRepository movierepository;

    @GetMapping("/movie")                                                   //GET ALL MOVIES
    public List<Movie> getAllMovies(){
        return movierepository.findAll();
    }

    @GetMapping("/movie/{id}")                                              //GET MOVIE BY ID
    public Movie getMovie(@PathVariable Integer id){
        return movierepository.findById(id).orElseThrow(() -> new imdbException("Movie", "id", id));
    }

    @PostMapping("/movie")                                                  //INSERT MOVIE
    public void createMovie(@Valid @RequestBody Movie movie){
        movierepository.save(movie);
    }

    @PutMapping("/movie/{id}")                                              //EDIT MOVIE DETAILS
    public Movie updateMovie(@PathVariable Integer id, @Valid @RequestBody Movie movieNew){
        Movie temp = movierepository.findById(id).orElseThrow(() -> new imdbException("Movie", "id", id));
        temp.setMovieName(movieNew.getMovieName());
        Movie newMovie = movierepository.save(temp);
        return newMovie;

    }
    @DeleteMapping("/movie/{id}")                                           //DELETE MOVIE
    public void deleteMovie(@PathVariable Integer id){
        movierepository.deleteById(id);
    }
}
