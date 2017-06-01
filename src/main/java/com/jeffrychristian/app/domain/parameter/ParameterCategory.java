package com.jeffrychristian.app.domain.parameter;

import com.jeffrychristian.app.common.types.ParameterCategoryType;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by jeffry.christian on 4/15/2017.
 */
@Entity
@Table(name = "mst_parameter_category")
public class ParameterCategory implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PARAMETER_CATEGORY_SEQ")
    @SequenceGenerator(name="PARAMETER_CATEGORY_SEQ", sequenceName="PARAMETER_CATEGORY_SEQ", allocationSize=1)
    private Long id;
    private String code;
    private String name;

    @Enumerated(EnumType.STRING)
    private ParameterCategoryType type;

    public ParameterCategory() {}

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

    public ParameterCategoryType getType() {
        return type;
    }

    public void setType(ParameterCategoryType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "ParameterCategory{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", type=" + type +
                '}';
    }
}