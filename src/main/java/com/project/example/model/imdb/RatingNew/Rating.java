package com.project.example.model.imdb.RatingNew;

import com.project.example.model.imdb.Audit;
import com.project.example.model.imdb.MovieNew.Movie;
import com.project.example.model.imdb.UserNew.User;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Rating extends Audit {

    @Id
    @Column(name = "rating_id")
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer id;

    private Long ratings;

    @Column(name = "text_review")
    private String review;

    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name="movie_id")
    private Movie movie;

    public Integer getId() {
        return id;
    }

    public void setId(Integer ratingId) {
        this.id = ratingId;
    }

    public Long getRatings() {
        return ratings;
    }

    public void setRatings(Long ratings) {
        this.ratings = ratings;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
