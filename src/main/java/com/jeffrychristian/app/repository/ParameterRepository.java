package com.jeffrychristian.app.repository;

import com.jeffrychristian.app.domain.parameter.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by jeffry.christian on 4/17/2017.
 */
@Repository
public interface ParameterRepository extends JpaRepository<Parameter, Long> {

    @Query("select p from Parameter p, ParameterCategory pc " +
            "where " +
            "pc.code = :code " +
            "and " +
            "p.category = pc.id")
    List<Parameter> findAllByCategoryCode(@Param("code") String categoryCode);

    Parameter findByCode(String code);
}
