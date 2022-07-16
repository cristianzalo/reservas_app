package com.wal.project.service.booking.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.wal.project.dao.booking.IBookingDao;
import com.wal.project.dao.customer.ICustomerDao;
import com.wal.project.dao.employee.IEmployeeDao;
import com.wal.project.dto.booking.BookingInsertDTO;
import com.wal.project.dto.booking.BookingDTO;
import com.wal.project.models.Booking;
import com.wal.project.models.Customer;
import com.wal.project.models.Employee;
import com.wal.project.service.booking.IBookingService;

@Service
public class BookingServiceImpl implements IBookingService {
	
	
	private IBookingDao bookingDao;
	
	private ICustomerDao customerDao;
	
	private IEmployeeDao employeeDao;
	
	
	public BookingServiceImpl(IBookingDao bookingDao,ICustomerDao customerDao,IEmployeeDao employeeDao) {
		this.bookingDao = bookingDao;
		
		this.customerDao = customerDao;
		
		this.employeeDao= employeeDao;
	}
	
	

	@Override
	public List<BookingDTO> getBookings() {
		List<Booking> bookings = bookingDao.findAll();
		
		
		
		List<BookingDTO> bookingsDto = new ArrayList<>();
		
		for (Booking booking : bookings) {
			
			BookingDTO bookingDto = new BookingDTO();
			
			bookingDto.setIdBooking(booking.getIdBooking());
			bookingDto.setIdCustomer(booking.getCustomer().getIdCustomer());
			bookingDto.setIdEmployee(booking.getEmployee().getIdEmployee());
			bookingDto.setBookingCreationDate(booking.getBookingCreationDate());
			bookingDto.setBookingAtentionDate(booking.getBookingAtentionDate());
			
			bookingsDto.add(bookingDto);
			
			
		}
		
		
		return bookingsDto;
	}
	
	

	@Override
	public BookingDTO insertBooking(BookingInsertDTO booking) {
		
		Booking bookingInsert;
		
		BookingDTO bookingAdded;
		
		Optional<Customer> customer = customerDao.findById(booking.getId_customer());
		Optional<Employee> employee = employeeDao.findById(booking.getId_employee());
		
		if (customer.isPresent() && employee.isPresent()) {
			
			bookingInsert= new Booking();
			
			bookingAdded = new BookingDTO();
			
			bookingInsert.setCustomer(customer.get());
			bookingInsert.setEmployee(employee.get());
			bookingInsert.setBookingAtentionDate(booking.getBookingAtentionDate());
			bookingInsert.setBookingCreationDate(booking.getBookingCreationDate());
			
			bookingInsert = bookingDao.save(bookingInsert);
			
			
			bookingAdded.setIdBooking(bookingInsert.getIdBooking());
			bookingAdded.setIdEmployee(bookingInsert.getEmployee().getIdEmployee());
			bookingAdded.setIdCustomer(bookingInsert.getCustomer().getIdCustomer());
			bookingAdded.setBookingAtentionDate(bookingInsert.getBookingAtentionDate());
			bookingAdded.setBookingCreationDate(bookingInsert.getBookingCreationDate());
			
			
		} else {
			
			bookingAdded = null;
			
		}
		
	
		return bookingAdded;
	}

	@Override
	public BookingDTO updateBooking(BookingDTO booking) {
		Booking bookingUpdate;
		
		BookingDTO bookingUpdated;
		
		Optional<Customer> customer = customerDao.findById(booking.getIdCustomer());
		Optional<Employee> employee = employeeDao.findById(booking.getIdCustomer());
		Optional<Booking> bookingToUpdate = bookingDao.findById(booking.getIdBooking());
		
		if (customer.isPresent() && employee.isPresent() &&  bookingToUpdate.isPresent()) {
			
			bookingUpdate= bookingToUpdate.get() ;
			
			bookingUpdated = new BookingDTO();
			
			bookingUpdate.setCustomer(customer.get());
			bookingUpdate.setEmployee(employee.get());
			bookingUpdate.setBookingAtentionDate(booking.getBookingAtentionDate());
			bookingUpdate.setBookingCreationDate(booking.getBookingCreationDate());
			
			bookingUpdate = bookingDao.save(bookingUpdate);
			
			
			bookingUpdated.setIdBooking(bookingUpdate.getIdBooking());
			bookingUpdated.setIdEmployee(bookingUpdate.getEmployee().getIdEmployee());
			bookingUpdated.setIdCustomer(bookingUpdate.getCustomer().getIdCustomer());
			bookingUpdated.setBookingAtentionDate(bookingUpdate.getBookingAtentionDate());
			bookingUpdated.setBookingCreationDate(bookingUpdate.getBookingCreationDate());
			
			
		} else {
			
			bookingUpdated = null;
			
		}
		
	
		return bookingUpdated;
	}

	@Override
	public BookingDTO deleteBooking(Integer id) {
		
		Optional<Booking> bookingDelete= bookingDao.findById(id);
		
		BookingDTO deletedBooking;
		
		
		if (bookingDelete.isPresent()) {
			
			deletedBooking =  new BookingDTO();
			
			Booking bookingToDelete =  bookingDelete.get();
			
			deletedBooking.setIdBooking(bookingToDelete.getIdBooking());
			deletedBooking.setIdCustomer(bookingToDelete.getCustomer().getIdCustomer());
			deletedBooking.setIdEmployee(bookingToDelete.getEmployee().getIdEmployee());
			deletedBooking.setBookingCreationDate(bookingToDelete.getBookingCreationDate());
			deletedBooking.setBookingAtentionDate(bookingToDelete.getBookingAtentionDate());
			
			bookingDao.deleteById(bookingToDelete.getIdBooking());
			
			
		}else {
			
			deletedBooking = null;
		}
		
		
		return deletedBooking;
	}

}
