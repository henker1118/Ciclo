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
import com.thomas.gimnasio.entities.Machine;
import com.thomas.gimnasio.services.MachineService;

@RestController
@RequestMapping("/api/Machine")
public class MachineController {
	@Autowired
	private MachineService machineService;

	// @CrossOrigin(origins = "http://132.226.240.254")
	@GetMapping("/all")
	public List<Machine> getMachine() {
		return machineService.getAll();
	};

	// @CrossOrigin(origins = "http://132.226.240.254")
	@GetMapping("/{id}")
	public Optional<Machine> getMachine(@PathVariable("id") int machineId) {
		return machineService.getMachine(machineId);
	}

	// @CrossOrigin(origins = "http://132.226.240.254")
	@PostMapping("/save")
	@ResponseStatus(HttpStatus.CREATED)
	public Machine save(@RequestBody Machine machine) {
		return machineService.save(machine);
	};

	@PutMapping("/update")
	@ResponseStatus(HttpStatus.CREATED)
	public Machine update(@RequestBody Machine machine) {
		return machineService.update(machine);
	};

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public boolean delete(@PathVariable("id") int machineId) {
		return machineService.deleteMachine(machineId);
	};
}
