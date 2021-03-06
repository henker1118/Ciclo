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
import com.thomas.gimnasio.entities.Reservation;
import com.thomas.gimnasio.reports.CountClient;
import com.thomas.gimnasio.reports.ReservationStatus;
import com.thomas.gimnasio.services.ReservationService;

@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
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
	@ResponseStatus(HttpStatus.CREATED)
	public Reservation save(@RequestBody Reservation reservation) {
		return reservationService.save(reservation);
	};

	@PutMapping("/update")
	@ResponseStatus(HttpStatus.CREATED)
	public Reservation update(@RequestBody Reservation reservation) {
		return reservationService.update(reservation);
	};

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public boolean delete(@PathVariable("id") int reservationId) {
		return reservationService.deleteReservation(reservationId);
	}
	
	@GetMapping("/report-status")
    public ReservationStatus getReservationsStatusReport(){
        return reservationService.getReservationStatusReport();
    }

    @GetMapping("/report-dates/{dateOne}/{dateTwo}")
    public List<Reservation> getReservationReportDate(@PathVariable("dateOne") String dateOne, @PathVariable("dateTwo") String dateTwo){
        return reservationService.getReservationPeriod(dateOne,dateTwo);
    }

    @GetMapping("/report-clients")
    public List<CountClient> getClients(){
        return reservationService.getTopClients();
    }
}
