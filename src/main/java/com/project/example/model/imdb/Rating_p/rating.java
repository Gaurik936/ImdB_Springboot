package com.project.example.model.imdb.Rating_p;

import com.project.example.model.imdb.Audit;
import com.project.example.model.imdb.Movie_p.movie;
import com.project.example.model.imdb.User_p.user;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "rating")
public class rating extends Audit {

    @Id
    @Column(name = "rating_id")
    private int rating_id;

    @Column(name = "ratings")
    private int ratings;

    @Column(name = "text_review")
    private String review;

    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name="user_id")
    private user User;

    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name="movie_id")
    private movie Movie;

    public int getRating_id() {
        return rating_id;
    }

    public void setRating_id(int rating_id) {
        this.rating_id = rating_id;
    }

    public int getRatings() {
        return ratings;
    }

    public void setRatings(int ratings) {
        this.ratings = ratings;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

}
