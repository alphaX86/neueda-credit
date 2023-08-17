package com.citi.credit;

import com.citi.credit.customExceptions.RecordNotFoundException;
import com.citi.credit.data.customers;
import com.citi.credit.data.transactions;
import com.citi.credit.dataRepo.ICustomerData;
import com.citi.credit.dataRepo.ITransactionData;
import com.citi.credit.service.CreditService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CreditApplicationTests {

	@Mock
	private ICustomerData customerRepo;

	@Mock
	private ITransactionData transactionRepo;

	@InjectMocks
	private CreditService creditService;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void testGetAllCustomers() {
		List<customers> customersList = new ArrayList<>();
		when(customerRepo.findAll()).thenReturn(customersList);

		List<customers> result = creditService.getAllCustomers();

		assertEquals(customersList, result);
	}

	@Test
	public void testGetAllTransactions() {
		List<transactions> transactionsList = new ArrayList<>();
		when(transactionRepo.findAll()).thenReturn(transactionsList);

		List<transactions> result = creditService.getAllTransactions();

		assertEquals(transactionsList, result);
	}

	@Test
	public void testGetCustomerByID() throws RecordNotFoundException {
		int customerId = 1;
		customers customer = new customers();
		when(customerRepo.findBycustomerID(customerId)).thenReturn(customer);

		customers result = creditService.getCustomerByID(customerId);

		assertEquals(customer, result);
	}

	@Test
	public void testGetCustomerByID_RecordNotFoundException() {
		int customerId = 1;
		when(customerRepo.findBycustomerID(customerId)).thenReturn(null);

		assertThrows(RecordNotFoundException.class, () -> {
			creditService.getCustomerByID(customerId);
		});
	}

	@Test
	public void testTransactionByCustID() throws RecordNotFoundException {
		int customerId = 1;
		customers customer = new customers();
		when(customerRepo.findBycustomerID(customerId)).thenReturn(customer);

		List<transactions> transactionsList = new ArrayList<>();
		when(transactionRepo.findBycustomerID(customerId)).thenReturn(transactionsList);

		List<transactions> result = creditService.transactionByCustID(customerId);

		assertEquals(transactionsList, result);
	}

	@Test
	public void testTransactionByCustID_RecordNotFoundException() {
		int customerId = 1;
		when(customerRepo.findBycustomerID(customerId)).thenReturn(null);

		assertThrows(RecordNotFoundException.class, () -> {
			creditService.transactionByCustID(customerId);
		});
	}

	// Continue with tests for other methods

	@Test
	public void testAddCustomer() throws RecordNotFoundException {
		String firstName = "John";
		String lastName = "Doe";
		String dob = "1990-01-01";
		String gender = "Male";
		String job = "Engineer";

		customers newCustomer = new customers(firstName, lastName, dob, job, gender, -1);
		when(customerRepo.count()).thenReturn(0L);
		when(customerRepo.save(newCustomer)).thenReturn(newCustomer);

		customers result = creditService.addCustomer(firstName, lastName, dob, gender, job);

		assertEquals(newCustomer, result);
	}

	@Test
	public void testDeleteCustomer() throws RecordNotFoundException {
		int customerId = 1;
		customers customer = new customers();
		when(customerRepo.findBycustomerID(customerId)).thenReturn(customer);

		customers result = creditService.deleteCustomer(customerId);

		assertEquals(customer, result);
	}

	@Test
	public void testDeleteCustomer_RecordNotFoundException() {
		int customerId = 1;
		when(customerRepo.findBycustomerID(customerId)).thenReturn(null);

		assertThrows(RecordNotFoundException.class, () -> {
			creditService.deleteCustomer(customerId);
		});
	}
}