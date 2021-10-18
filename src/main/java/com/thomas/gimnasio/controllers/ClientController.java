package com.thomas.gimnasio.controllers;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thomas.gimnasio.entities.Client;
import com.thomas.gimnasio.services.ClientService;

@RestController
@RequestMapping("/api/Client")
public class ClientController {
	@Autowired
	private ClientService clientService;

	// @CrossOrigin(origins = "http://132.226.240.254")
	@GetMapping("/all")
	public List<Client> getClients() {
		return clientService.getAll();
	};

	// @CrossOrigin(origins = "http://132.226.240.254")
	@GetMapping("/{id}")
	public Optional<Client> getClient(@PathVariable("id") int clientId) {
		return clientService.getClient(clientId);
	}

	// @CrossOrigin(origins = "http://132.226.240.254")
	@PostMapping("/save")
	public Client save(@RequestBody Client client) {
		return clientService.save(client);
	};
	/*
	 * @PutMapping("/update") public Custome update(@RequestBody Custome custome)
	 * {return customeService.update(custome);};
	 * 
	 * @DeleteMapping("/{id}") public void delete(@PathVariable("id") int customeId)
	 * { customeService.deleteCustome(customeId); }
	 * 
	 */
}
