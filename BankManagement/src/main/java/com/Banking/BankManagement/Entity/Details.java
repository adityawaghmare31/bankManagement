package com.Banking.BankManagement.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Details {
@Id
//@GeneratedValue(strategy = GenerationType.SEQUENCE)
private int	account;
private String	name;
private String username;
private String password;
private int amount;
private int contact;
private String type;
private String profilepassword;

public Details() {
	super();
	// TODO Auto-generated constructor stub
}

public Details(int account, String name, String username, String password, int amount, int contact, String type,
		String profilepassword) {
	super();
	this.account = account;
	this.name = name;
	this.username = username;
	this.password = password;
	this.amount = amount;
	this.contact = contact;
	this.type = type;
	this.profilepassword = profilepassword;
}

public int getAccount() {
	return account;
}

public void setAccount(int account) {
	this.account = account;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public int getAmount() {
	return amount;
}

public void setAmount(int amount) {
	this.amount = amount;
}

public int getContact() {
	return contact;
}

public void setContact(int contact) {
	this.contact = contact;
}

public String getType() {
	return type;
}

public void setType(String type) {
	this.type = type;
}

public String getProfilepassword() {
	return profilepassword;
}

public void setProfilepassword(String profilepassword) {
	this.profilepassword = profilepassword;
}

@Override
public String toString() {
	return "Details [account=" + account + ", name=" + name + ", username=" + username + ", password=" + password
			+ ", amount=" + amount + ", contact=" + contact + ", type=" + type + ", profilepassword=" + profilepassword
			+ "]";
}


}