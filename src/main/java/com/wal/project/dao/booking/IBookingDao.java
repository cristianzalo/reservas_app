package com.wal.project.dao.booking;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wal.project.models.Booking;

@Repository
public interface IBookingDao extends JpaRepository<Booking, Integer> {

}
