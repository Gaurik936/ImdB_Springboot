package com.project.example.model.imdb.GenreNew;

import com.project.example.model.imdb.imdbException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class genreController {

    @Autowired
    public genreRepository genrerepository;

    @GetMapping("/genre")                                                   //GET ALL GENRES
    public List<Genre> getAllGenres(){
        return genrerepository.findAll();
    }

    @GetMapping("/genre/{id}")                                              //GET GENRE BY ID
    public Genre getGenres(@PathVariable Integer id){
        return genrerepository.findById(id).orElseThrow(() -> new imdbException("Genre", "id", id));
    }

    @PostMapping("/genre")                                                  //INSERT GENRE
    public void createGenre(@Valid @RequestBody Genre genre){
        genrerepository.save(genre);
    }

    @PutMapping("/genre/{id}")                                              //EDIT GENRE DETAILS
    public Genre updateGenre(@PathVariable Integer id, @Valid @RequestBody Genre genreNew){
        Genre temp = genrerepository.findById(id).orElseThrow(() -> new imdbException("Genre", "id", id));
        temp.setGenreTitle(genreNew.getGenreTitle());
        Genre newGenre = genrerepository.save(temp);
        return newGenre;
    }

}
