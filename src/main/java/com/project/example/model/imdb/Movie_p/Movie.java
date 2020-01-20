package com.project.example.model.imdb.Movie_p;

import com.project.example.model.imdb.Audit;
import com.project.example.model.imdb.Genre_p.Genre;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table
public class Movie extends Audit {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    @Id
    private int movieId;

    @Column(name = "movie_name")
    private String movieName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "genre_id")
    private Genre genre;

   /* @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<Movie> movies= new ArrayList<Movie>();*/

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

}
