package com.thomas.gimnasio.dao;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.thomas.gimnasio.entities.Client;
import com.thomas.gimnasio.entities.Reservation;
import com.thomas.gimnasio.entities.ReservationCrud;
import com.thomas.gimnasio.reports.CountClient;

@Repository
public class ReservationRepository {
	@Autowired
	private ReservationCrud reservationCrudRepository;

	public List<Reservation> getAll() {
		return (List<Reservation>) reservationCrudRepository.findAll();
	};

	public Optional<Reservation> getReservation(int idReservation) {
		return reservationCrudRepository.findById(idReservation);
	};

	public Reservation save(Reservation reservation) {
		return reservationCrudRepository.save(reservation);
	};

	public void delete(Reservation reservation) {
		reservationCrudRepository.delete(reservation);
	}
	
	public List<Reservation> getReservationByStatus(String status){
        return reservationCrudRepository.findAllByStatus(status);
    }

    public List<Reservation> getReservationPeriod(Date dateOne, Date dateTwo){
        return reservationCrudRepository.findAllByStartDateAfterAndStartDateBefore(dateOne,dateTwo);
    }

    public List<CountClient> getTopClient(){
        List<CountClient> clientList = new ArrayList<>();
        List<Object[]> report = reservationCrudRepository.countTotalReservationByClient();
        for(int i=0;i<report.size();i++){
            clientList.add(new CountClient((Long) report.get(i)[1] ,(Client)report.get(i)[0]));
            }
        return clientList;
    }
}
