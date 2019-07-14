package br.com.krasz.springbootcourse.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.krasz.springbootcourse.entities.Client;
import br.com.krasz.springbootcourse.exceptions.ObjectNotFoundException;
import br.com.krasz.springbootcourse.repositories.ClientRepository;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repo;

    public Client getClientById(Integer id) {
        Optional<Client> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
            "The requested object cannot be found! - Id: " + id + ", Type: " + Client.class.getName()
        ));
    }


}