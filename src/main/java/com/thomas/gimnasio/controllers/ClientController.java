package com.thomas.gimnasio.controllers;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.thomas.gimnasio.entities.Category;
import com.thomas.gimnasio.entities.Client;
import com.thomas.gimnasio.services.ClientService;

@RestController
@RequestMapping("/api/Client")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
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
	@ResponseStatus(HttpStatus.CREATED)
	public Client save(@RequestBody Client client) {
		return clientService.save(client);
	};
	
	@PutMapping("/update")
	@ResponseStatus(HttpStatus.CREATED)
	public Client update(@RequestBody Client client) {
		return clientService.update(client);
	};

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public boolean delete(@PathVariable("id") int clientId) {
		return clientService.deleteClient(clientId);
	};
}
