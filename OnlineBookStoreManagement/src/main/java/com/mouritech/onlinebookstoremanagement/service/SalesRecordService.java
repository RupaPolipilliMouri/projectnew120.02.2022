package com.mouritech.onlinebookstoremanagement.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.mouritech.onlinebookstoremanagement.entity.SalesRecord;
import com.mouritech.onlinebookstoremanagement.exception.CustomerNotFoundException;
import com.mouritech.onlinebookstoremanagement.exception.SalesRecordNotFoundException;
public interface SalesRecordService {

	
	SalesRecord insertSalesRecord(SalesRecord newSalesRecord);

	SalesRecord showSalesRecordById(Long SalesId) throws SalesRecordNotFoundException;

	List<SalesRecord> showAllSalesRecords();

	SalesRecord updateSalesRecordById(Long SalesId, SalesRecord salesRecord) throws SalesRecordNotFoundException;

	void deleteSalesRecordById(Long SalesId) throws  SalesRecordNotFoundException;

	ResponseEntity<List<SalesRecord>> getAllSalesRecordsByCustomerId(Long cid) throws CustomerNotFoundException;

	ResponseEntity<SalesRecord> createSalesRecord(Long cid, SalesRecord salesRecord) throws CustomerNotFoundException;

	

	

}
