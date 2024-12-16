package org.yearup.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.yearup.data.interfaces.CategoryDao;
import org.yearup.data.interfaces.ProductDao;
import org.yearup.models.Category;
import org.yearup.models.Product;

import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/categories")
public class CategoriesController
{
    private CategoryDao categoryDao;
    private ProductDao productDao;

    // create an Autowired controller to inject the categoryDao
    @Autowired
    public CategoriesController(CategoryDao categoryDao){
        this.categoryDao = categoryDao;
        this.productDao = productDao;


    }


    // add the appropriate annotation for a get action
    @PreAuthorize("permitAll()")
    @RequestMapping(method = RequestMethod.GET)
    public List<Category> getAll() {
        // find and return all categories
        return null;
        return categoryDao.getAllCategories();
    }

    // add the appropriate annotation for a get action
    @PreAuthorize("permitAll()")
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Category getById(@PathVariable int id) {
        // get the category by id
        return null;
        return categoryDao.getById(id);
    }


    @PreAuthorize("permitAll()")
    @GetMapping(path = "/{categoryId}/products")
    public List<Product> getProductsById(@PathVariable int categoryId) {
        return null;
        return productDao.listByCategoryId(categoryId);
    }
    // a POST action
    // add annotation to ensure that only an ADMIN can call this function
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public Category addCategory(@RequestBody Category category)
    {
        //insert catergory
        return null;
        return categoryDao.create(category);
    }

    // add annotation to call this method for a PUT (update) action - the url path must include the categoryId
    // only ADMIN can use this function
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping(path = "/{id}")
    }
    // update the category by id
    public void updateCategory(@PathVariable int id, @RequestBody Category category) {
        categoryDao.update(id, category);
    }


    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    // add annotation to ensure that only an ADMIN can call this function
    public void deleteCategory(@PathVariable int id) {
        categoryDao.delete(id);
    }
}
