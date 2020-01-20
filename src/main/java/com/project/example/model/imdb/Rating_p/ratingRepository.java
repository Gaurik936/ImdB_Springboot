package com.project.example.model.imdb.Rating_p;

import com.sun.xml.bind.v2.schemagen.episode.SchemaBindings;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ratingRepository extends JpaRepository<rating , Integer> {

    Page<rating> findRatingByUserId(Integer id, Pageable pageable);

    //Optional findByIdAndRatingId(Integer user_id, Integer rating_id);
}
