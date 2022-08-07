package com.wal.project.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.wal.project.dao.booking.IBookingDao;
import com.wal.project.dao.customer.ICustomerDao;
import com.wal.project.dao.employee.IEmployeeDao;
import com.wal.project.dto.booking.BookingDTO;
import com.wal.project.dto.booking.BookingInsertDTO;
import com.wal.project.models.Booking;
import com.wal.project.models.Customer;
import com.wal.project.models.Employee;
import com.wal.project.service.booking.impl.BookingServiceImpl;

public class BookingServiceTest {
	
	
	
	 IBookingDao bookingDao = mock(IBookingDao.class);
	
	 ICustomerDao customerDao = mock(ICustomerDao.class);
	
	 IEmployeeDao employeeDao = mock(IEmployeeDao.class);
	 
	 BookingServiceImpl bookingService;
	 
	 
	 
	 @BeforeEach
	 public void setUp() {
		 
		 bookingService = new BookingServiceImpl(bookingDao, customerDao, employeeDao);
	 }
	 
	 
	 
	 
	 @Test
	 public void getBookingsTest() {
	
		 List<BookingDTO> data = new ArrayList<>();
		 
		 
		 Booking bookingDataTest = new Booking();
		 Customer customerDataTest = new Customer();
		 Employee employeeDataTest = new Employee();
		 
		 
		 
		 customerDataTest.setIdCustomer(1);
		 employeeDataTest.setIdEmployee(1);
		 bookingDataTest.setIdBooking(1);
		 
		 bookingDataTest.setCustomer(customerDataTest);
		 bookingDataTest.setEmployee(employeeDataTest);
		 bookingDataTest.setBookingAtentionDate(new Date());
		 bookingDataTest.setBookingCreationDate(new Date());
		 
		 List<Booking> bookingList = new ArrayList<>();
		 
		 bookingList.add(bookingDataTest);
		 
		 
		 when(bookingDao.findAll()).thenReturn(bookingList);
		 
		data = bookingService.getBookings();
		 
		 assertEquals(1, data.size());
		  
		 
	 }
	 
	 
	 
	 @Test
	 public void insertBookingFailTest() {
		 
		 BookingDTO bookingDto;
		 
		 when(customerDao.findById(Mockito.any())).thenReturn(Optional.empty());
		 when(employeeDao.findById(Mockito.any())).thenReturn(Optional.empty());
		 
		 BookingInsertDTO  insertDTO = new BookingInsertDTO();
		 
		 bookingDto =  bookingService.insertBooking(insertDTO);
		 
		 
		 assertEquals(null, bookingDto);
		 
	 }
	 
	 
	 @Test
	 public void InsertBookingTestSuccess() {
		 
	
		 BookingDTO bookingDTO;
		 //bookingDTO.setIdBooking(1);
		 
		 BookingInsertDTO  insertData = new BookingInsertDTO();
		 
		 Customer customer = new Customer();
		 customer.setIdCustomer(1);
		 
		 Employee employee = new Employee();
		 employee.setIdEmployee(1);
		 
		 Booking bookingData = new Booking();
		 
		 bookingData.setIdBooking(1);
		 bookingData.setEmployee(employee);
		 bookingData.setCustomer(customer);
		 bookingData.setBookingCreationDate(new Date());
		 bookingData.setBookingAtentionDate(new Date());
		 
		 
		 
		 
		 
		 when(customerDao.findById(Mockito.any())).thenReturn(Optional.of(customer));
		 when(employeeDao.findById(Mockito.any())).thenReturn(Optional.of(employee));
		 when(bookingDao.save(Mockito.any(Booking.class))).thenReturn(bookingData);
		 
		 
		 bookingDTO = bookingService.insertBooking(insertData);
		 
		 
		 assertEquals(bookingDTO.getIdBooking(), bookingData.getIdBooking() );
		 
		 
	 }
	 
	 
	 
	 @Test
	 public void updateBookingTestFail() {
		 
		 BookingDTO bookingDto;
		 
		 BookingDTO bookingInsert = new BookingDTO();
		 
		 when(customerDao.findById(Mockito.any())).thenReturn(Optional.empty());
		 when(employeeDao.findById(Mockito.any())).thenReturn(Optional.empty());
		 when(bookingDao.findById(Mockito.any())).thenReturn(Optional.empty());
		 
		 bookingDto = bookingService.updateBooking(bookingInsert);
		 
		 
		 assertEquals(null, bookingDto);
		 
		 
	 }
	 
	 
	 
	 @Test
	 public void updateBookingTestSuccess() {
		 
		 
	 }
	 
	 
	 
	 
	 
	

}
