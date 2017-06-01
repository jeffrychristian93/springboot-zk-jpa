package com.jeffrychristian.app.domain.region;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by jeffry.christian on 4/15/2017.
 */
@Entity
@Table(name = "mst_country")
public class Country implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COUNTRY_SEQ")
    @SequenceGenerator(name="COUNTRY_SEQ", sequenceName="COUNTRY_SEQ", allocationSize=1)
    private Long id;
    @Column(name = "code") private String code;
    @Column(name = "name") private String name;

    public Country() {}

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
}
