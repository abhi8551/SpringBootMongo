package com.storeData.controller;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.storeData.dal.BillRepository;
import com.storeData.modal.Bill;
import com.storeData.modal.ErrorHandling;

@RestController
@RequestMapping(value = "/")
public class BillInformationController {

	private final Logger LOG = LoggerFactory.getLogger(getClass());

	private final BillRepository billRepository;

	public BillInformationController(BillRepository billRepository) {
		this.billRepository = billRepository;
	}

	@RequestMapping(value = "/bills", method = RequestMethod.GET)
	public List<Bill> getAllBills() {
		LOG.info("Getting all users.");
		return billRepository.findAll();
	}

	@RequestMapping(value = "/bills/{billId}", method = RequestMethod.GET)
	public Bill getBill(@PathVariable int billId) {
		LOG.info("Getting bill with billId: {}.", billId);
		return billRepository.findByBillId(billId);
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public Object addNewBill(@RequestBody Bill bill) {
		LOG.info("Saving bill information.");
		final int[] sum = {0};
		bill.getProductDetails().forEach(billInstance -> {
			int sumTemp = 0;
			sumTemp += billInstance.getPerPiece() * billInstance.getQuantity();
			billInstance.setTotal(sumTemp);
			sum[0] = sum[0] + billInstance.getTotal();
		});
		bill.setDate(new Date());
		bill.setTotalAmount(sum[0]);
		if(!StringUtils.isEmpty(billRepository.findByBillId(bill.getBillId()).toString())) {
			ErrorHandling error = new ErrorHandling();
			error.setErrorMessage("Bill Id already exists. Please try with Different Bill Id");
			return error;
		}
		return billRepository.save(bill);
	}
}
