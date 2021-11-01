package com.thomas.gimnasio.dao;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.thomas.gimnasio.entities.Machine;
import com.thomas.gimnasio.entities.MachineCrud;

@Repository
public class MachineRepository {
	@Autowired
	private MachineCrud machineCrudRepository;

	public List<Machine> getAll() {
		return (List<Machine>) machineCrudRepository.findAll();
	};

	public Optional<Machine> getMachine(int id) {
		return machineCrudRepository.findById(id);
	};

	public Machine save(Machine machines) {
		return machineCrudRepository.save(machines);
	};

	public void delete(Machine machine) {
		machineCrudRepository.delete(machine);
	};

}
