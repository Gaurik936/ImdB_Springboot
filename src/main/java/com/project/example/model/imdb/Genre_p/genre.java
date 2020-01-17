package com.project.example.model.imdb.Genre_p;

import com.project.example.model.imdb.Movie_p.movie;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class genre {

    @Id
    @Column(name = "genre_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int genre_id;

    @Column(name ="genre_title", nullable = false)
    private String genre_title;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date created_at;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date updated_at;

    @OneToOne(mappedBy = "movie", cascade = CascadeType.ALL)
    private movie Movie;

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public void setMovie(movie movie) {
        Movie = movie;
    }

    public int getGenre_id() {
        return genre_id;
    }

    public void setGenre_id(int genre_id) {
        this.genre_id = genre_id;
    }

    public String getGenre() {
        return genre_title;
    }

    public void setGenre(String genre) {
        this.genre_title = genre_title;
    }
}
