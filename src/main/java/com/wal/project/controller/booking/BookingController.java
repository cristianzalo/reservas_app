package com.wal.project.controller.booking;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wal.project.dto.booking.BookingInsertDTO;
import com.wal.project.dto.booking.BookingDTO;
import com.wal.project.service.booking.IBookingService;

@RestController
@RequestMapping("/api/reservas")
public class BookingController {
	
	
	private IBookingService bookingService;
	
	
	
	
	public BookingController(IBookingService bookingService) {
		this.bookingService = bookingService;
	}



	
	@GetMapping("/bookings")
	public ResponseEntity<List<BookingDTO>> getBookings(){
		
		return new ResponseEntity<List<BookingDTO>>(bookingService.getBookings(),HttpStatus.OK);
		
	}
	
	
	@PostMapping("/booking")
	public ResponseEntity<BookingDTO> insertBooking(@RequestBody BookingInsertDTO booking){
		
		BookingDTO addedBooking = bookingService.insertBooking(booking);
		
		if(addedBooking == null) {
			
			return new ResponseEntity<BookingDTO>(addedBooking,HttpStatus.CONFLICT);
		}
		
		
		return new ResponseEntity<BookingDTO>(addedBooking,HttpStatus.CREATED);
		
	}
	
	@PostMapping("/updateBooking")
	public ResponseEntity<BookingDTO> updateBooking(@RequestBody BookingDTO bookingUpdate){
		
		BookingDTO updatedBooking = bookingService.updateBooking(bookingUpdate);
		
		if(updatedBooking == null) {
			
			return new ResponseEntity<BookingDTO>(updatedBooking,HttpStatus.CONFLICT);
		}
		
		
		return new ResponseEntity<BookingDTO>(updatedBooking,HttpStatus.ACCEPTED);
	
		
	}
	
	

	@DeleteMapping("/deleteBooking/{id}")
	public ResponseEntity<BookingDTO> deleteBooking(@PathVariable Integer id){
		
		BookingDTO deletedBooking = bookingService.deleteBooking(id);
		
		if (deletedBooking == null) {
			
			return new ResponseEntity<BookingDTO>(deletedBooking,HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<BookingDTO>(deletedBooking,HttpStatus.OK);
		
	}
}
