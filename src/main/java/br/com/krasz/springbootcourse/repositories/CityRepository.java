package br.com.krasz.springbootcourse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.krasz.springbootcourse.entities.City;

public interface CityRepository extends JpaRepository<City, Integer> {
    
}