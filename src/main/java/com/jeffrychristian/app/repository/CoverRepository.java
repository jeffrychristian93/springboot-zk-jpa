package com.jeffrychristian.app.repository;

import com.jeffrychristian.app.domain.cover.Cover;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by jeffry.christian on 4/16/2017.
 */
@Repository
public interface CoverRepository extends JpaRepository<Cover, Long> {

    List<Cover> findAll();

}
