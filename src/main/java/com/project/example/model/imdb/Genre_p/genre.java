package com.project.example.model.imdb.Genre_p;

import com.project.example.model.imdb.Audit;
import com.project.example.model.imdb.Movie_p.movie;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table
public class genre extends Audit {

    @Id
    @Column(name = "genre_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int genre_id;

    @Column(name ="genre_title", nullable = false)
    private String genre_title;

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
