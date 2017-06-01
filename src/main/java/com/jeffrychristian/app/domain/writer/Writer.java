package com.jeffrychristian.app.domain.writer;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by jeffry.christian on 4/15/2017.
 */
@Entity
@Table(name = "mst_writer")
public class Writer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "WRITER_SEQ")
    @SequenceGenerator(name="WRITER_SEQ", sequenceName="WRITER_SEQ", allocationSize=1)
    private Long id;
    private String firstName;
    private String lastName;

    public Writer() {}

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
