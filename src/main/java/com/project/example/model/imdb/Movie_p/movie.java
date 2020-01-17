package com.project.example.model.imdb.Movie_p;

import com.project.example.model.imdb.Genre_p.genre;
import com.project.example.model.imdb.Rating_p.rating;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class movie implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int movie_id;

    private String movie_name;

    private int genre_id;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date created_at;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date updated_at;

    @OneToMany(mappedBy="rating", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<rating> Rating;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "genre_id")
    private genre Genre;

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public void setRating(List<rating> rating) {
        Rating = rating;
    }

    public void setGenre(genre genre) {
        Genre = genre;
    }

    public int getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }

    public String getMovie_name() {
        return movie_name;
    }

    public void setMovie_name(String movie_name) {
        this.movie_name = movie_name;
    }

    public int getGenre_id() {
        return genre_id;
    }

    public void setGenre_id(int genre_id) {
        this.genre_id = genre_id;
    }
}
