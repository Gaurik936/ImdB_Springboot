package com.project.example.model.imdb.RatingNew;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ratingRepository extends JpaRepository<Rating, Integer> {

    Page<Rating> findRatingByUserId(Integer id, Pageable pageable);

    Page<Rating> findRatingByMovieId(Integer id, Pageable pageable);

    //Optional findByIdAndRatingId(Integer user_id, Integer rating_id);
}
