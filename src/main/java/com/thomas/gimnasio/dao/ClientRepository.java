package com.thomas.gimnasio.dao;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.thomas.gimnasio.entities.Client;
import com.thomas.gimnasio.entities.ClientCrud;

@Repository
public class ClientRepository {
	@Autowired
	private ClientCrud clientCrudRepository;

	public List<Client> getAll() {
		return (List<Client>) clientCrudRepository.findAll();
	};

	public Optional<Client> getClient(int id) {
		return clientCrudRepository.findById(id);
	};

	public Client save(Client client) {
		return clientCrudRepository.save(client);
	};
	/*
	 * public void delete(Category category )
	 * {categoryCrudRepository.delete(category);};
	 */
}
