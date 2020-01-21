package com.project.example.model.imdb.MovieNew;

import com.project.example.model.imdb.Audit;
import com.project.example.model.imdb.GenreNew.Genre;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Movie extends Audit {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    @Id
    private int id;

    @Column(name = "movie_name")
    private String movieName;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "genre_id")
    private Genre genre;

    /*@OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<Movie> movies= new ArrayList<Movie>();
*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
