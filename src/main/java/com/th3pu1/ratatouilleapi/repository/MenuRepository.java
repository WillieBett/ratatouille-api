package com.th3pu1.ratatouilleapi.repository;

import com.th3pu1.ratatouilleapi.entity.Menu;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by pchaivong on 9/3/2017 AD.
 */

@Repository
public interface MenuRepository extends CrudRepository<Menu, Long> {
}
