package com.thomas.gimnasio.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.thomas.gimnasio.dao.ReservationRepository;
import com.thomas.gimnasio.entities.Reservation;
import com.thomas.gimnasio.reports.CountClient;
import com.thomas.gimnasio.reports.ReservationStatus;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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
			Optional<Reservation> e = reservationRepository.getReservation(reservation.getIdReservation());
			if (!e.isEmpty()) {
				if (reservation.getStartDate() != null) {
					e.get().setStartDate(reservation.getStartDate());
				}
				if (reservation.getDevolutionDate() != null) {
					e.get().setDevolutionDate(reservation.getDevolutionDate());
				}
				if (reservation.getStatus() != null) {
					e.get().setStatus(reservation.getStatus());
				}
				reservationRepository.save(e.get());
				return e.get();

			} else {
				return reservation;
			}
		} else {
			return reservation;
		}
	}

	public boolean deleteReservation(int id) {
		Boolean result = getReservation(id).map(reservation -> {
			reservationRepository.delete(reservation);
			return true;
		}).orElse(false);
		return result;
	}

	public ReservationStatus getReservationStatusReport() {
		List<Reservation> completed = reservationRepository.getReservationByStatus("completed");
		List<Reservation> cancelled = reservationRepository.getReservationByStatus("cancelled");
		return new ReservationStatus(completed.size(), cancelled.size());
	}

	public List<Reservation> getReservationPeriod(String dateOne, String dateTwo) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date startDate = dateFormat.parse(dateOne);
			Date endDate = dateFormat.parse(dateTwo);
			if (startDate.before(endDate)) {
				return reservationRepository.getReservationPeriod(startDate, endDate);
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return new ArrayList<>();
	}

	public List<CountClient> getTopClients() {
		return reservationRepository.getTopClient();
	}
}
