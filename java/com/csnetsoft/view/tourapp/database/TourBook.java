package com.csnetsoft.view.tourapp.database;

public class TourBook {
	
	
	int id ;
	String name,email,phone,age,address,city,gender, tourid;
	///set 
	

	public void setID(int value)
		{
		id=value;
		}
	public void setTourid(String value)
	{
	     tourid=value;
	}

	public void setName(String value)
		{
		name=value;
		}
	public void setEmail(String value)
		{
		email=value;
		}
	public void setPhone(String value)
		{
		phone=value;
		}
	public void setAddress(String value)
		{
		address=value;
		}
	public void setCity(String value)
		{
		city=value;
		}
	public void setAge(String value)
		{
		age=value;
		}
	public void setGender(String value)
		{
		gender=value;
		}

	
	//GET
	public int getID()
		{
		return id;
		}
	
	public String getName()
		{
		return name;
		}
	public String getEmail()
		{
		return email;
		}
	public String getPhone()
		{
		return phone;
		}
	public String getAddress()
		{
		return address;
		}
	public String getGender()
		{
		return gender;
		}
	public String getAge()
		{
		return age;
		}
	public String getCity()
		{
		return city;
		}

	
	public String getTourid()
	{
	return tourid;
	}

}



