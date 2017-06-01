package com.jeffrychristian.app.repository;

import com.jeffrychristian.app.domain.movie.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by jeffry.christian on 4/16/2017.
 */
@Repository
public interface MovieRepository extends JpaRepository<Movie, Long>{

    Page<Movie> findByTitleIgnoreCaseContaining(String title, Pageable pageable);
}
