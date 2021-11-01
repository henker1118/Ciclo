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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.thomas.gimnasio.entities.Category;
import com.thomas.gimnasio.entities.Message;
import com.thomas.gimnasio.services.MessageService;



@RestController
@RequestMapping("/api/Message")
public class MessageController {
	@Autowired
	private MessageService messageService;

	// @CrossOrigin(origins = "http://132.226.240.254")
	@GetMapping("/all")
	public List<Message> getMessage() {
		return messageService.getAll();
	};

	// @CrossOrigin(origins = "http://132.226.240.254")
	@GetMapping("/{id}")
	public Optional<Message> getMessage(@PathVariable("idMessage") int messageId) {
		return messageService.getMessage(messageId);
	}

	// @CrossOrigin(origins = "http://132.226.240.254")
	@PostMapping("/save")
	@ResponseStatus(HttpStatus.CREATED)
	public Message save(@RequestBody Message message) {
		return messageService.save(message);
	};
	
	@PutMapping("/update")
	@ResponseStatus(HttpStatus.CREATED)
	public Message update(@RequestBody Message message) {
		return messageService.update(message);
	};

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public boolean delete(@PathVariable("id") int messageId) {
		return messageService.deleteMessage(messageId);
	};
}
