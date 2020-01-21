package com.project.example.model.imdb.GenreNew;

import com.project.example.model.imdb.Audit;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;


@Entity()
@Table
@EntityListeners(AuditingEntityListener.class)
public class Genre extends Audit {

    @Id
    @Column(name = "genre_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer genreId;

    @Column(name ="genre_title", nullable = false)
    private String genreTitle;

  /*  @OneToMany(mappedBy = "genre", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<Movie> movies =new ArrayList<Movie>();*/

    public Integer getGenreId() {
        return genreId;
    }

    public void setGenreId(Integer genreId) {
        this.genreId = genreId;
    }

    public String getGenreTitle() {
        return genreTitle;
    }

    public void setGenreTitle(String genreTitle) {
        this.genreTitle = genreTitle;
    }
}
