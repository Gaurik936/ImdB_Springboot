package com.project.example.model.imdb.Movie_p;

import com.project.example.model.imdb.Audit;
import com.project.example.model.imdb.Genre_p.genre;
import com.project.example.model.imdb.Rating_p.rating;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table
public class movie extends Audit {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int movie_id;

    private String movie_name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "genre_id")
    private genre Genre;

    public int getMovie_id() {
        return movie_id;
    }
    /*@OneToMany(mappedBy = "Movie", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<movie> movies= new ArrayList<movie>();
*/
    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }

    public String getMovie_name() {
        return movie_name;
    }

    public void setMovie_name(String movie_name) {
        this.movie_name = movie_name;
    }

    public genre getGenre() {
        return Genre;
    }

    public void setGenre(genre genre) {
        Genre = genre;
    }
}
