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
import com.thomas.gimnasio.entities.Reservation;
import com.thomas.gimnasio.services.ReservationService;

@RestController
@RequestMapping("/api/Reservation")
public class ReservationController {
	@Autowired
	private ReservationService reservationService;

	// @CrossOrigin(origins = "http://132.226.240.254")
	@GetMapping("/all")
	public List<Reservation> getReservation() {
		return reservationService.getAll();
	};

	// @CrossOrigin(origins = "http://132.226.240.254")
	@GetMapping("/{id}")
	public Optional<Reservation> getReservation(@PathVariable("id") int reservationId) {
		return reservationService.getReservation(reservationId);
	}

	// @CrossOrigin(origins = "http://132.226.240.254")
	@PostMapping("/save")
	public Reservation save(@RequestBody Reservation reservation) {
		return reservationService.save(reservation);
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
