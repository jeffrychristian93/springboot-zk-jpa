package com.jeffrychristian.app.domain.actor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by jeffry.christian on 4/15/2017.
 */
@Entity
@Table(name = "mst_actor")
public class Actor implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ACTOR_SEQ")
    @SequenceGenerator(name="ACTOR_SEQ", sequenceName="ACTOR_SEQ", allocationSize=1)
    private Long id;
    @Column(name = "firstname") private String firstName;
    @Column(name = "lastname")  private String lastName;

    public Actor() {}

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