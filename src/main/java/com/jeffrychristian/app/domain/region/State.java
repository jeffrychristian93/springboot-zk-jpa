package com.jeffrychristian.app.domain.region;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by jeffry.christian on 12/13/2016.
 */
@Entity
@Table(name = "mst_state")
public class State implements Serializable{

    private static final long serialVersionUID = 4626332494285848409L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STATE_SEQ")
    @SequenceGenerator(name="STATE_SEQ", sequenceName="STATE_SEQ", allocationSize=1)
    private long id;

    @Column(name = "code")  private String code;
    @Column(name = "name")  private String name;

    @ManyToOne
    @JoinColumn(name = "countryid", referencedColumnName = "id")
    private Country country;

    public State() {
    }

    public State(String code, String name, Country country) {
        this.code = code;
        this.name = name;
        this.country = country;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}