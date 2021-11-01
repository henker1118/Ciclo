package com.thomas.gimnasio.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.thomas.gimnasio.dao.ReservationRepository;
import com.thomas.gimnasio.entities.Category;
import com.thomas.gimnasio.entities.Reservation;

@Service
public class ReservationService {
	@Autowired
	ReservationRepository reservationRepository;

	public List<Reservation> getAll() {
		return (List<Reservation>) reservationRepository.getAll();
	};

	public Optional<Reservation> getReservation(int id) {
		return reservationRepository.getReservation(id);
	};

	public Reservation save(Reservation reservation) {
		if (reservation.getIdReservation() == null) {
			return reservationRepository.save(reservation);
		} else {
			Optional<Reservation> co = reservationRepository.getReservation(reservation.getIdReservation());
			if (co.isEmpty()) {
				return reservationRepository.save(reservation);
			} else {
				return reservation;
			}
		}
	}

	public Reservation update(Reservation reservation) {
		if (reservation.getIdReservation() != null) {
			Optional<Reservation> co = reservationRepository.getReservation(reservation.getIdReservation());
			if (co.isEmpty()) {
				return reservationRepository.save(reservation);
			}
		}
		return reservation;
	}

	public boolean deleteReservation(int id) {
		Boolean result = getReservation(id).map(reservation -> {
			reservationRepository.delete(reservation);
			return true;
		}).orElse(false);
		return result;
	}
}
