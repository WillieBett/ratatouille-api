package com.th3pu1.ratatouilleapi.entity;

import com.th3pu1.ratatouilleapi.repository.IngredientRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class IngredientTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private IngredientRepository ingredientRepository;


    @Test
    public void testPersist(){
        Ingredient ingredient = new Ingredient();
        ingredient.setName("Test");
        ingredient.setPrice(BigDecimal.valueOf(2.0));

        entityManager.persist(ingredient);

        Ingredient found = ingredientRepository.findOne((long)1);

        assertThat(found.getName()).isEqualTo(ingredient.getName());
    }
}
