package com.project.example.model.imdb.Rating_p;

import com.project.example.model.imdb.Movie_p.movieRepository;
import com.project.example.model.imdb.User_p.user;
import com.project.example.model.imdb.User_p.userRepository;
import com.project.example.model.imdb.imdbException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class ratingController {

    @Autowired
    public userRepository userrepository;

    @Autowired
    public ratingRepository ratingrepository;

    @Autowired
    public movieRepository movierepository;

    @GetMapping("/user/{id}/ratings")
    public Page<rating> getAllRatings(@PathVariable Integer id, Pageable pageable){
        return ratingrepository.findRatingByUserId(id, pageable);
    }

    @GetMapping("/user/{user_id}/ratings/{id}")
    public rating getRating(@PathVariable Integer id){
        return ratingrepository.findById(id).orElseThrow(() -> new imdbException("Rating", "id", id));
    }

    @PostMapping("/user/{id}/ratings")
    public rating createRating(@PathVariable Integer id, @Valid @RequestBody rating rating){
        return userrepository.findById(id).map(user -> {rating.setUser(user);
        return ratingrepository.save(rating);}).orElseThrow(() -> new imdbException("Rating", "id", id));
    }

    @PutMapping("/user/{user_id}/ratings/{rating_id}")
    public rating updateRating(@PathVariable Integer rating_id, @PathVariable Integer user_id, @Valid @RequestBody rating rating_new){
        if(!userrepository.existsById(user_id))
            throw new imdbException("User", "id", user_id);

        rating temp = ratingrepository.findById(rating_id).orElseThrow(() -> new imdbException("Rating", "id", rating_id));
        temp.setRatings(rating_new.getRatings());
        temp.setReview(rating_new.getReview());
        rating new_rating = ratingrepository.save(temp);
        return new_rating;

    }

    /*@DeleteMapping("/user/{user_id}/ratings/{rating_id}")                                           //DELETE USER
    public ResponseEntity<?> deleteRating(@PathVariable Integer user_id, @PathVariable Integer rating_id){
        return ratingrepository.findByIdAndRatingId(user_id, rating_id).map(rating -> {
            ratingrepository.delete(rating);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new imdbException("Rating", "id" , rating_id));

    }*/


}
