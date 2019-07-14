package br.com.krasz.springbootcourse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.krasz.springbootcourse.entities.State;

@Repository
public interface StateRepository extends JpaRepository<State, Integer> {

}