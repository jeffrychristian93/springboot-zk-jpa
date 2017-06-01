package com.jeffrychristian.app.domain.parameter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by jeffry.christian on 4/15/2017.
 */
@Entity
@Table(name = "mst_parameter")
public class Parameter implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PARAMETER_SEQ")
    @SequenceGenerator(name="PARAMETER_SEQ", sequenceName="PARAMETER_SEQ", allocationSize=1)
    private Long id;
    @Column(name = "code")          private String code;
    @Column(name = "value")         private String value;
    @Column(name = "description")   private String description;

    @ManyToOne
    @JoinColumn(name = "categoryid", referencedColumnName = "id")
    private ParameterCategory category;

    public Parameter() {}

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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ParameterCategory getCategory() {
        return category;
    }

    public void setCategory(ParameterCategory category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Parameter{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", value='" + value + '\'' +
                ", description='" + description + '\'' +
                ", category=" + category +
                '}';
    }
}
