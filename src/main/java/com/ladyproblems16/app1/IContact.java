package com.ladyproblems16.app1;

public interface IContact {

	void setName(String theName);
	String getName();

	void setNumber(String theNumber);
	String getNumber();

	void setFromSerializable(ISerializable in);

}
