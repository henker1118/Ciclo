package com.thomas.gimnasio.entities;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface ReservationCrud extends CrudRepository<Reservation, Integer> {
	public List<Reservation> findAllByStatus(String status);

	public List<Reservation> findAllByStartDateAfterAndStartDateBefore(Date dateOne, Date dateTwo);

	@Query("SELECT c.client, COUNT(c.client) FROM Reservation AS c group by c.client order by COUNT(c.client)DESC")
	public List<Object[]> countTotalReservationByClient();
}
