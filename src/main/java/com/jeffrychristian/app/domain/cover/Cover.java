package com.jeffrychristian.app.domain.cover;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by jeffry.christian on 4/16/2017.
 */
@Entity
@Table(name = "mst_cover")
public class Cover implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COVER_SEQ")
    @SequenceGenerator(name="COVER_SEQ", sequenceName="COVER_SEQ", allocationSize=1)
    private Long id;
    @Column(name = "filename")  private String fileName;    // nama file
    @Column(name = "format")    private String format;  // format file
    @Column(name = "ext")       private String ext;  // ekstensi file
    @Column(name = "type")      private String type;        //content type

    public Cover() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }
}
