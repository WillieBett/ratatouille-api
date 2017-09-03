package com.th3pu1.ratatouilleapi.repository;

import com.th3pu1.ratatouilleapi.entity.Ingredient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by pchaivong on 9/2/2017 AD.
 */

@Repository
public interface IngredientRepository extends CrudRepository<Ingredient, Long> {

}
