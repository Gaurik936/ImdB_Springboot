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
    public List<movie> getAllMovies(){
        return movierepository.findAll();
    }

    @GetMapping("/movie/{id}")                                              //GET MOVIE BY ID
    public movie getMovie(@PathVariable Integer id){
        return movierepository.findById(id).orElseThrow(() -> new imdbException("Movie", "id", id));
    }

    @PostMapping("/movie")                                                  //INSERT MOVIE
    public void createMovie(@Valid @RequestBody movie movie){
        movierepository.save(movie);
    }

    @PutMapping("/movie/{id}")                                              //EDIT MOVIE DETAILS
    public movie updateMovie(@PathVariable Integer id, @Valid @RequestBody movie movie_new){
        movie temp = movierepository.findById(id).orElseThrow(() -> new imdbException("Movie", "id", id));
        temp.setMovie_name(movie_new.getMovie_name());
        movie new_movie = movierepository.save(temp);
        return new_movie;

    }
    @DeleteMapping("/movie/{id}")                                           //DELETE MOVIE
    public void deleteMovie(@PathVariable Integer id){
        movierepository.deleteById(id);
    }
}
