package br.com.krasz.springbootcourse.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.krasz.springbootcourse.entities.*;
import br.com.krasz.springbootcourse.services.CategoryService;

@RestController
@RequestMapping(value = "/categories")
public class CategoryController {

    @Autowired
    private CategoryService service;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getCategoryById(@PathVariable Integer id){
        Category cat = service.getCategoryById(id);

        return ResponseEntity.ok().body(cat);
    }
}