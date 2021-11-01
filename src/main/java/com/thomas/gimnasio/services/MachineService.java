package com.thomas.gimnasio.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thomas.gimnasio.dao.MachineRepository;
import com.thomas.gimnasio.entities.Category;
import com.thomas.gimnasio.entities.Machine;

@Service
public class MachineService {
	@Autowired
	MachineRepository machineRepository;

	public List<Machine> getAll() {
		return (List<Machine>) machineRepository.getAll();
	};

	public Optional<Machine> getMachine(int id) {
		return machineRepository.getMachine(id);
	};

	public Machine save(Machine machine) {
		if (machine.getId() == null) {
			return machineRepository.save(machine);
		} else {
			Optional<Machine> co = machineRepository.getMachine(machine.getId());
			if (co.isEmpty()) {
				return machineRepository.save(machine);
			} else {
				return machine;
			}
		}
	}

	public Machine update(Machine machine){
        if(machine.getId()!=null){
            Optional<Machine> e=machineRepository.getMachine(machine.getId());
            if(!e.isEmpty()){
                if(machine.getName()!=null){
                    e.get().setName(machine.getName());
                }
                if(machine.getBrand()!=null){
                    e.get().setBrand(machine.getBrand()); ;
                }
                if(machine.getYear() !=null){
                    e.get().setYear(machine.getYear());
                }
                if(machine.getDescription()!=null){
                    e.get().setDescription(machine.getDescription());
                }
                if(machine.getCategory()!=null){
                    e.get().setCategory(machine.getCategory());
                }
                machineRepository.save(e.get());
                return e.get();
            }else{
                return machine;
            }
        }else{
            return machine;
        }
    }

	public boolean deleteMachine(int id) {
		Boolean result = getMachine(id).map(machine -> {
			machineRepository.delete(machine);
			return true;
		}).orElse(false);
		return result;
	}
}
