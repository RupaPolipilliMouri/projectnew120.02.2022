package com.mouritech.onlinebookstoremanagement.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mouritech.onlinebookstoremanagement.entity.SalesRecord;
import com.mouritech.onlinebookstoremanagement.exception.CustomerNotFoundException;
import com.mouritech.onlinebookstoremanagement.exception.SalesRecordNotFoundException;
import com.mouritech.onlinebookstoremanagement.repository.CustomerRepository;
import com.mouritech.onlinebookstoremanagement.repository.SalesRecordRepository;


@Service
public class SalesRecordServiceImpl implements SalesRecordService {

	@Autowired
	private SalesRecordRepository salesRecordRepository;
	@Autowired
	CustomerRepository customerRepository;

	@Override
	public SalesRecord insertSalesRecord(SalesRecord newSalesRecord) {
		return salesRecordRepository.save(newSalesRecord);
	}

	@Override
	public SalesRecord showSalesRecordById(Long SalesId) throws SalesRecordNotFoundException {
		return salesRecordRepository.findById(SalesId)
				.orElseThrow(() -> new SalesRecordNotFoundException("salesRecord not found with salesId "));
	}

	@Override
	public List<SalesRecord> showAllSalesRecords() {
		return salesRecordRepository.findAll();
	}

	@Override
	public SalesRecord updateSalesRecordById(Long SalesId, SalesRecord salesRecord) throws SalesRecordNotFoundException {
		SalesRecord newSalesRecord = salesRecordRepository.findById(SalesId)
				.orElseThrow(() -> new SalesRecordNotFoundException("SalesRecord not found with salesId"));
		newSalesRecord.setAmountToPay(salesRecord.getAmountToPay());
		newSalesRecord.setAmountPaid(salesRecord.getAmountPaid());
		newSalesRecord.setBalance(salesRecord.getBalance());
		newSalesRecord.setNoOfCopies(salesRecord.getNoOfCopies());
		return newSalesRecord;

	}

	@Override
	public void deleteSalesRecordById(Long SalesId) throws SalesRecordNotFoundException {
		SalesRecord salesRecord = salesRecordRepository.findById(SalesId)
				.orElseThrow(() -> new SalesRecordNotFoundException("sales id not found"));
		salesRecordRepository.delete(salesRecord);

	}

	@Override
	public ResponseEntity<List<SalesRecord>> getAllSalesRecordsByCustomerId(Long cid) throws CustomerNotFoundException {
		if(!customerRepository.existsCustomerByCustomerId(cid)) {
			throw new CustomerNotFoundException("Category not found with id = " + cid);
			}
			List<SalesRecord> sales = salesRecordRepository.findByCustomer_CustomerId(cid);
			return new ResponseEntity<List<SalesRecord>>(sales,HttpStatus.OK);
			}

	@Override
	public ResponseEntity<SalesRecord> createSalesRecord(Long cid, SalesRecord salesRecord) throws CustomerNotFoundException {
		SalesRecord salesRecord1 = customerRepository.findById(cid).map(
				customer ->{
					salesRecord.setCustomer(customer);
					
					return salesRecordRepository.save(salesRecord);
				}).orElseThrow(()-> new CustomerNotFoundException("customer not found with id = "  + cid));
		return new ResponseEntity<SalesRecord>(salesRecord,HttpStatus.CREATED);
	}

}
