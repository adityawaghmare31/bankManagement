package com.Banking.BankManagement.Dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Banking.BankManagement.Entity.Details;

@Repository
public class BankDao {
	@Autowired
	SessionFactory sf;

	public String CreateAccount(Details details) {
		Session session =sf.openSession();
		Transaction tr=session.beginTransaction();
			session.save(details);
		tr.commit();
		sf.close();
		
		return "Data Save Successfully";
	}
	
	public Details AllList(Details details) {
		Session session=sf.openSession();
	    Details detailsfromdatabase=session.get(Details.class, details.getAccount());
		return  detailsfromdatabase;
		
	}

	public List<Details> CheckAccount(Details detail) {
		Session session=sf.openSession();
		Criteria criteria=session.createCriteria(Details.class);
		List<Details>list=new ArrayList<>();
	    Details details=session.get(Details.class, detail.getAccount());
		list.add(details);
	    return list;
	}
	
	
}
