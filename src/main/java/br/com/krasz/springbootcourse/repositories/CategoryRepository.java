package br.com.krasz.springbootcourse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.krasz.springbootcourse.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

}