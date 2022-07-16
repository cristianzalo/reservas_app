package com.wal.project.service.booking;

import java.util.List;

import com.wal.project.dto.booking.BookingInsertDTO;
import com.wal.project.dto.booking.BookingDTO;

public interface IBookingService {
	
	public List<BookingDTO> getBookings();
	
	public BookingDTO insertBooking(BookingInsertDTO booking);
	
	public BookingDTO updateBooking(BookingDTO booking);
	
	public BookingDTO deleteBooking(Integer id);
	
	
	
	
	

}
