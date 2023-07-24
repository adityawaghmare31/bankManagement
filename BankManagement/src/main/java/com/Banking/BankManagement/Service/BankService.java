package com.Banking.BankManagement.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Banking.BankManagement.Dao.BankDao;
import com.Banking.BankManagement.Entity.Details;

@Service
public class BankService {
	@Autowired
	BankDao BD;
	
	public String CreateAccount(Details details) {
		BD.CreateAccount(details);
		return "Data Save Successfuly";
		
	}
	
	public Details AllList(Details detailsfromBrowser) {
		 Details detailsfromdatabse=BD.AllList(detailsfromBrowser);
		 return detailsfromdatabse;
	}
		 
	public List<Details> CheckAccount(Details detailsfromBrowser) {
		 List<Details> list=BD.CheckAccount(detailsfromBrowser);
		return list;
		 
	}
		
	


}



	


