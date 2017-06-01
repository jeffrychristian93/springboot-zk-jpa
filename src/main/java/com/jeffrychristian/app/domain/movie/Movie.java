package com.jeffrychristian.app.domain.movie;

import com.jeffrychristian.app.common.types.MovieFilterType;
import com.jeffrychristian.app.domain.cover.Cover;
import com.jeffrychristian.app.domain.genre.Genre;
import com.jeffrychristian.app.domain.parameter.Parameter;
import com.jeffrychristian.app.domain.region.Country;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by jeffry.christian on 4/15/2017.
 */
@Entity
@Table(name = "mst_movie")
public class Movie implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MOVIE_SEQ")
    @SequenceGenerator(name="MOVIE_SEQ", sequenceName="MOVIE_SEQ", allocationSize=1)
    private Long id;

    @Column(name = "title", unique = true, nullable = true)
    private String title;          //Semua judul dibuat huruf kecil untuk penyeragaman dan performance

    @Column(name = "rating")        private Double  rating;         //IMDB rating
    @Column(name = "releaseyear")   private String  releaseYear;    //tahun
    @Column(name = "releasedate")   private Date    releaseDate;    //tanggal
    @Column(name = "synopsis")      private String  synopsis;       //sinopsis
    @Column(name = "production")    private String  production;
    @Column(name = "trailer")       private String  trailer;
    @Column(name = "minute")        private int     minute;
    @Column(name = "writers")       private String  writers;
    @Column(name = "directors")     private String  directors;
    @Column(name = "actors")        private String  actors; //Pemain
    @Column(name = "producers")     private String  producers; //Produser

    @Enumerated(EnumType.STRING)
    @Column(name = "filter")        private MovieFilterType filter;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "coverid", referencedColumnName = "id")
    private Cover cover;

    @ManyToOne
    @JoinColumn(name = "countryid", referencedColumnName = "id")
    private Country country;

    @ManyToOne
    @JoinColumn(name = "subtitleid", referencedColumnName = "id")
    private Parameter subtitle;

    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "movie", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Genre> genres = new ArrayList<>();

    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "movie", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<MovieFile> movieFile = new ArrayList<>();

    public Movie() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getProduction() {
        return production;
    }

    public void setProduction(String production) {
        this.production = production;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public MovieFilterType getFilter() {
        return filter;
    }

    public void setFilter(MovieFilterType filter) {
        this.filter = filter;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public String getWriters() {
        return writers;
    }

    public void setWriters(String writers) {
        this.writers = writers;
    }

    public String getDirectors() {
        return directors;
    }

    public void setDirectors(String directors) {
        this.directors = directors;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getProducers() {
        return producers;
    }

    public void setProducers(String producers) {
        this.producers = producers;
    }

    public Cover getCover() {
        return cover;
    }

    public void setCover(Cover cover) {
        this.cover = cover;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Parameter getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(Parameter subtitle) {
        this.subtitle = subtitle;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public List<MovieFile> getMovieFile() {
        return movieFile;
    }

    public void setMovieFile(List<MovieFile> movieFile) {
        this.movieFile = movieFile;
    }
}