package com.thomas.gimnasio.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.thomas.gimnasio.dao.ClientRepository;
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
}
