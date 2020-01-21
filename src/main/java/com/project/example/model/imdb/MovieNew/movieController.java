package com.project.example.model.imdb.MovieNew;

import com.project.example.model.imdb.GenreNew.genreRepository;
import com.project.example.model.imdb.imdbException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class movieController {

    @Autowired
    public movieRepository movierepository;

    @Autowired
    public genreRepository genrerepository;

    @GetMapping("genre/{id}/movie")                                                   //GET ALL MOVIES
    public List<Movie> getAllMovies(){
        return movierepository.findAll();
    }

    @GetMapping("genre/{genreId}/movie/{id}")                                              //GET MOVIE BY ID
    public Movie getMovie(@PathVariable Integer id){
        return movierepository.findById(id).orElseThrow(() -> new imdbException("Movie", "id", id));
    }

    @PostMapping("genre/{genreId}/movie")                                                  //INSERT MOVIE
    public Movie createMovie(@PathVariable Integer genreId , @Valid @RequestBody Movie movie){
        return genrerepository.findById(genreId).map(genre -> {movie.setGenre(genre);
            return movierepository.save(movie);}).orElseThrow(() -> new imdbException("Movie", "id", genreId));

    }


    @PutMapping("/genre/{genreId}/movie/{movieId}")
    public Movie updateMovie(@PathVariable Integer movieId, @PathVariable Integer genreId, @Valid @RequestBody Movie movieNew){
        if(!genrerepository.existsById(genreId))
            throw new imdbException("Genre", "id", genreId);

        Movie temp = movierepository.findById(movieId).orElseThrow(() -> new imdbException("Movie", "id", movieId));
        temp.setMovieName(movieNew.getMovieName());
        Movie newMovie = movierepository.save(temp);
        return newMovie;

    }

    /*@DeleteMapping("/movie/{id}")                                           //DELETE MOVIE
    public void deleteMovie(@PathVariable Integer id){
        movierepository.deleteById(id);
    }
*/
    /*@GetMapping("/movie/{id}")                                                   //GET ALL MOVIES
    public Optional<Genre> getMovieGenre(@PathVariable Integer id){
        Movie temp = movierepository.findById(id).orElseThrow(() -> new imdbException("Movie", "id", id));
        Integer newID = temp.getId();
        return genrerepository.findById(newID);
    }

    @PutMapping("/movie/{id}")                                              //EDIT MOVIE DETAILS
    public Genre updateGenre(@PathVariable Integer id, @Valid @RequestBody Genre genreNew){
        Genre temp = genrerepository.findById(id).orElseThrow(() -> new imdbException("Movie", "id", id));
        temp.setGenreTitle(genreNew.getGenreTitle());
        Genre newGenre = genrerepository.save(temp);
        return newGenre;

    }*/

}
