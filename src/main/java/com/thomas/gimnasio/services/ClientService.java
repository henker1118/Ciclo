package com.thomas.gimnasio.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.thomas.gimnasio.dao.ClientRepository;
import com.thomas.gimnasio.entities.Category;
import com.thomas.gimnasio.entities.Client;

@Service
public class ClientService {
	@Autowired
	ClientRepository clientRepository;

	public List<Client> getAll() {
		return (List<Client>) clientRepository.getAll();
	};

	public Optional<Client> getClient(int id) {
		return clientRepository.getClient(id);
	};

	public Client save(Client client) {
		if (client.getIdClient() == null) {
			return clientRepository.save(client);
		} else {
			Optional<Client> co = clientRepository.getClient(client.getIdClient());
			if (co.isEmpty()) {
				return clientRepository.save(client);
			} else {
				return client;
			}
		}
	}
	
	public Client update(Client client){
        if (client.getIdClient() != null) {
           Optional<Client> e = clientRepository.getClient(client.getIdClient());
           if (!e.isEmpty()) {
               if (client.getEmail() != null) {
                   e.get().setEmail(client.getEmail());
               }
               if (client.getPassword() != null) {
                   e.get().setPassword(client.getPassword());
               }
               if (client.getName() != null) {
                   e.get().setName(client.getName());
               }
               if (client.getAge() != null) {
                   e.get().setAge(client.getAge());
               }
               clientRepository.save(e.get());
               return e.get();

           } else {
               return client;
           }
       } else {
           return client;
       }
}

	public boolean deleteClient(int id) {
		Boolean result = getClient(id).map(category -> {
			clientRepository.delete(category);
			return true;
		}).orElse(false);
		return result;
	}
}
