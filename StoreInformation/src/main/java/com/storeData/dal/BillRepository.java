package com.storeData.dal;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.storeData.modal.Bill;

public interface BillRepository extends MongoRepository<Bill, String>{
	Bill findByBillId(int BillId);
}
