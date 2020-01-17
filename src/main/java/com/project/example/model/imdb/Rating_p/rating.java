package com.project.example.model.imdb.Rating_p;

import com.project.example.model.imdb.Movie_p.movie;
import com.project.example.model.imdb.User_p.user;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class rating {

    @Id
    @Column(name = "rating_id")
    private int rating_id;

    @Column(name = "movie_id")
    private int movie_id;

    @Column(name = "user_id")
    private int user_id;

    @Column(name = "ratings")
    private int ratings;

    @Column(name = "text_review")
    private String review;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date created_at;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date updated_at;

    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name="user_id")
    private user User;

    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name="movie_id")
    private movie Movie;

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public int getRating_id() {
        return rating_id;
    }

    public void setRating_id(int rating_id) {
        this.rating_id = rating_id;
    }

    public int getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
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

    public void setUser(user user) {
        User = user;
    }

    public void setMovie(movie movie) {
        Movie = movie;
    }
}
