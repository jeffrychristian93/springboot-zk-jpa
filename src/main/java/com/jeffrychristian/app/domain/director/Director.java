package com.jeffrychristian.app.domain.director;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by jeffry.christian on 4/15/2017.
 */
@Entity
@Table(name = "mst_director")
public class Director implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DIRECTOR_SEQ")
    @SequenceGenerator(name="DIRECTOR_SEQ", sequenceName="DIRECTOR_SEQ", allocationSize=1)
    private Long id;
    @Column(name = "firstname") private String firstName;
    @Column(name = "lastname")  private String lastName;

    public Director() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


}
