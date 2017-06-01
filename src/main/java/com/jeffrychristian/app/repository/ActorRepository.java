package com.jeffrychristian.app.repository;

import com.jeffrychristian.app.domain.actor.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by jeffry.christian on 4/17/2017.
 */
@Repository
public interface ActorRepository extends JpaRepository<Actor, Long>{

}
