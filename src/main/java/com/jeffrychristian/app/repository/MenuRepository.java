package com.jeffrychristian.app.repository;

import com.jeffrychristian.app.domain.menu.Menu;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by jeffry.christian on 11/15/2016.
 */
@Repository
public interface MenuRepository extends CrudRepository<Menu, Long> {

    Menu findByCode(String code);

}