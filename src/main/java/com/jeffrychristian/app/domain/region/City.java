package com.jeffrychristian.app.domain.region;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by jeffry.christian on 12/13/2016.
 */
@Entity
@Table(name = "mst_city")
public class City implements Serializable{

    private static final long serialVersionUID = 6180281381218674538L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CITY_SEQ")
    @SequenceGenerator(name="CITY_SEQ", sequenceName="CITY_SEQ", allocationSize=1)
    private long id;

    @Column(name = "code")  private String code;
    @Column(name = "name")  private String name;

    @ManyToOne
    @JoinColumn(name = "stateid", referencedColumnName = "id")
    private State state;

    public City() {
    }

    public City(String code, String name, State state) {
        this.code = code;
        this.name = name;
        this.state = state;
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

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
