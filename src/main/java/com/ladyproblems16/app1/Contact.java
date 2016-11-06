package com.ladyproblems16.app1;

public class Contact implements IContact { 

	private String name;
	private String number;
	private int id;
	
	public Contact(String name, String number) {
		setName(name);
		setNumber(number);
	}

	public Contact(ISerializable params) {
		setName(params.getString("name"));
		setNumber(params.getString("number"));
		setId(params.getInt("id"));
	}
	
	@Override
	public void setName(String theName) {
		this.name = theName;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void setNumber(String theNumber) {
		this.number = theNumber;
	}

	@Override
	public String getNumber() {
		return this.number;
	}

	@Override
	public void setId(int theId) {
		this.id = theId;
	}
	
	@Override
	public int getId() {
		return id;
	}
}
