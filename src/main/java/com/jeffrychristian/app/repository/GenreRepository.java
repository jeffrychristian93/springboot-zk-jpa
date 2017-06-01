package com.jeffrychristian.app.repository;

import com.jeffrychristian.app.domain.genre.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by jeffry.christian on 5/1/2017.
 */
@Repository
public interface GenreRepository extends JpaRepository<Genre, Long>{

}
