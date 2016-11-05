package com.ladyproblems2016.app1;

public class Contact implements IContact {

	private String name;
	private String number;
	private int id;
	
	public Contact(String name, String number) {
		this.name = setName(name);
		this.number = setNumber(number);
	}
	
	@Override
	public void setName(String theName) {
		this.name = theName;
	}

	@Override
	public String getName();
		return this.name;

	@Override
	public void setNumber(String theNumber) {
		this.number = theNumber;
	}

	@Override
	public String getNumber() {
		return this.number;
	}

	public int setId(int theId) {
		this.id = theId;
	} 

	@Override
	void setFromSerializable(ISerializable in) {

	}
}