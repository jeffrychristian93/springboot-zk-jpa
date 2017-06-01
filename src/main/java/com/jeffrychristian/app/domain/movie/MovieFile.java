package com.jeffrychristian.app.domain.movie;

import com.jeffrychristian.app.common.types.QualityType;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by jeffry.christian on 4/16/2017.
 */
@Entity
@Table(name = "mst_movie_file")
public class MovieFile implements Serializable{

    // link/url file = (path+fileName+fileExtension)

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MOVIE_FILE_SEQ")
    @SequenceGenerator(name="MOVIE_FILE_SEQ", sequenceName="MOVIE_FILE_SEQ", allocationSize=1)
    private Long id;

    @Column(name = "quality")
    @Enumerated(EnumType.STRING)
    private QualityType quality;     //LOW - ULTRA_HIGH (240p-4320p)

    @Column(name = "filename")  private String fileName;    // nama file
    @Column(name = "format")    private String format;  // ekstensi file
    @Column(name = "type")      private String type;        //content type

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movieid", referencedColumnName = "id")
    private Movie movie;

    public MovieFile() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public QualityType getQuality() {
        return quality;
    }

    public void setQuality(QualityType quality) {
        this.quality = quality;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}