package com.thomas.gimnasio.entities;
import org.springframework.data.repository.CrudRepository;

public interface ReservationCrud extends CrudRepository<Reservation, Integer> {
    
}
