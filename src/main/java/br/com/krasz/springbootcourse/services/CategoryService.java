package br.com.krasz.springbootcourse.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.krasz.springbootcourse.entities.Category;
import br.com.krasz.springbootcourse.exceptions.ObjectNotFoundException;
import br.com.krasz.springbootcourse.repositories.CategoryRepository;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repo;

    public Category getCategoryById(int id){
        Optional<Category> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
            "The requested object cannot be found! - Id: " + id + ", Type: " + Category.class.getName()
        ));
    }
}