package com.th3pu1.ratatouilleapi.repository;

import com.th3pu1.ratatouilleapi.entity.Ingredient;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by pchaivong on 9/2/2017 AD.
 */

@Repository
public interface IngredientRepository extends CrudRepository<Ingredient, Long> {

    @Query("FROM Ingredient i WHERE i.category.id = :categoryId")
    public List<Ingredient> findByCategory(@Param("categoryId")Long categoryId);

}
