package com.project.example.model.imdb.Genre_p;

import com.project.example.model.imdb.Movie_p.movieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class genreController {

    @Autowired
    public genreRepository genrerepository;

    @Autowired
    public movieRepository movierepository;

}
