package br.com.krasz.springbootcourse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.krasz.springbootcourse.entities.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {
    
}