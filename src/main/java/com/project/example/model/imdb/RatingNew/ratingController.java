package com.project.example.model.imdb.RatingNew;

import com.project.example.model.imdb.MovieNew.movieRepository;
import com.project.example.model.imdb.UserNew.userRepository;
import com.project.example.model.imdb.imdbException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class ratingController {

    @Autowired
    public userRepository userrepository;

    @Autowired
    public ratingRepository ratingrepository;

    @Autowired
    public movieRepository movierepository;

    @GetMapping("/user/{id}/ratings")
    public Page<Rating> getAllRatings(@PathVariable Integer id, Pageable pageable){
        return ratingrepository.findRatingByUserId(id, pageable);
    }

    @GetMapping("/user/{userId}/ratings/{id}")
    public Rating getRating(@PathVariable Integer id){
        return ratingrepository.findById(id).orElseThrow(() -> new imdbException("Rating", "id", id));
    }

    @PostMapping("/user/{id}/ratings")
    public Rating createRating(@PathVariable Integer id, @Valid @RequestBody Rating rating){
        return userrepository.findById(id).map(user -> {rating.setUser(user);
        return ratingrepository.save(rating);}).orElseThrow(() -> new imdbException("Rating", "id", id));
    }

    @PutMapping("/user/{userId}/ratings/{ratingId}")
    public Rating updateRating(@PathVariable Integer ratingId, @PathVariable Integer userId, @Valid @RequestBody Rating ratingNew){
        if(!userrepository.existsById(userId))
            throw new imdbException("User", "id", userId);

        Rating temp = ratingrepository.findById(ratingId).orElseThrow(() -> new imdbException("Rating", "id", ratingId));
        temp.setRatings(ratingNew.getRatings());
        temp.setReview(ratingNew.getReview());
        Rating newRating = ratingrepository.save(temp);
        return newRating;

    }

    /*@DeleteMapping("/user/{user_id}/ratings/{rating_id}")                                           //DELETE USER
    public ResponseEntity<?> deleteRating(@PathVariable Integer user_id, @PathVariable Integer rating_id){
        return ratingrepository.findByIdAndRatingId(user_id, rating_id).map(rating -> {
            ratingrepository.delete(rating);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new imdbException("Rating", "id" , rating_id));

    }*/

    @GetMapping("/movie/{id}/ratings")
    public Page<Rating> getAllMovieRatings(@PathVariable Integer id, Pageable pageable){
        return ratingrepository.findRatingByMovieId(id, pageable);
    }

    @GetMapping("/movie/{movieId}/ratings/{id}")
    public Rating getMovieRating(@PathVariable Integer id){
        return ratingrepository.findById(id).orElseThrow(() -> new imdbException("Rating", "id", id));
    }

}
