package br.com.krasz.springbootcourse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.krasz.springbootcourse.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {
    
}