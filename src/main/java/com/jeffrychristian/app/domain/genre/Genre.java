package com.jeffrychristian.app.domain.genre;

import com.jeffrychristian.app.domain.movie.Movie;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by jeffry.christian on 4/29/2017.
 */
@Entity
@Table(name = "mst_genre")
public class Genre implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GENRE_SEQ")
    @SequenceGenerator(name="GENRE_SEQ", sequenceName="GENRE_SEQ", allocationSize=1)
    private Long id;

    @Column(name = "code") private String code;
    @Column(name = "name") private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movieid", referencedColumnName = "id")
    private Movie movie;

    public Genre() {}

    public Genre(String code, String name, Movie movie) {
        this.code = code;
        this.name = name;
        this.movie = movie;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
