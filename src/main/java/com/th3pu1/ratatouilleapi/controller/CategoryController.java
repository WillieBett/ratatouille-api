package com.th3pu1.ratatouilleapi.controller;

import com.th3pu1.ratatouilleapi.model.CategoryRequest;
import com.th3pu1.ratatouilleapi.model.CategoryResponse;
import com.th3pu1.ratatouilleapi.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.th3pu1.ratatouilleapi.controller.exception.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

/**
 * Controller for category CRUD operations
 *
 */

@RestController
public class CategoryController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @CrossOrigin("*")
    @RequestMapping(value = "/api/categories", method = RequestMethod.POST)
    @ResponseStatus(code = HttpStatus.CREATED, value = HttpStatus.CREATED)
    public CategoryResponse createCategory(@RequestBody CategoryRequest request){
        logger.info("Create new category");
        logger.debug(request.toString());

        Optional<CategoryResponse> category = categoryService.addCategory(request.getName(),
                request.isKitchen_enabled());

        return category.orElseThrow(ResourceNotFoundException::new);
    }

    /**
     * Get category detail by specific ID
     */
    @CrossOrigin("*")
    @RequestMapping(value = "/api/categories/{id}", method = RequestMethod.GET)
    @ResponseStatus(code = HttpStatus.OK, value = HttpStatus.OK)
    public CategoryResponse getCategoryDetail(@PathVariable Long id){
        logger.debug("Get Category detail by ID: " + id);
        Optional<CategoryResponse> category = categoryService.getCategoryDetail(id);
        return category.orElseThrow(ResourceNotFoundException::new);
    }


    /**
     * Get categories list
     * @return List\<CategoryResponse\>
     */
    @CrossOrigin("*")
    @RequestMapping(value = "/api/categories", method = RequestMethod.GET)
    @ResponseStatus(code = HttpStatus.OK, value = HttpStatus.OK)
    public List<CategoryResponse> getCategoryList(){
        logger.debug("Get list of categories");
        return categoryService.getCategoryList();
    }

    @CrossOrigin("*")
    @RequestMapping(value = "/api/categories/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(code = HttpStatus.NO_CONTENT, value = HttpStatus.NO_CONTENT)
    public void deleteCategory(@PathVariable Long id){
        categoryService.deleteCategory(id);
    }

    @CrossOrigin("*")
    @RequestMapping(value = "/api/categories/{id}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK, code = HttpStatus.OK)
    public CategoryResponse updateCategory(@PathVariable Long id,
                                           @RequestBody CategoryRequest request){
        Optional<CategoryResponse> saved = categoryService.updateCategory(id, request);
        return saved.orElseThrow(ResourceNotFoundException::new);
    }


}
