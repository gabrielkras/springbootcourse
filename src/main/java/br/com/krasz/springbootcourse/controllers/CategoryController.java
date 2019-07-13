package br.com.krasz.springbootcourse.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.krasz.springbootcourse.entities.*;

@RestController
@RequestMapping(value = "/categories")
public class CategoryController {

    @RequestMapping(method = RequestMethod.GET)
    public List<Category> list(){

        Category cat1 = new Category();
        cat1.setId(1);
        cat1.setName("informatic");

        Category cat2 = new Category();
        cat2.setId(2);
        cat2.setName("office");

        List<Category> list = new ArrayList<>();
        list.add(cat1);
        list.add(cat2);

        return list;
    }
}