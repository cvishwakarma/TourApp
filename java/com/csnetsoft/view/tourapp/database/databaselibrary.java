package com.csnetsoft.view.tourapp.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class databaselibrary {

	
Context activityContext;
	
	final String DATABASENAME="worldtourappdb";
	final int DATABASEVERSION=1;
	
	final String TABLENAME="mtourappbooking";
	
	final String KEY_ID="_id";
	final String FIELD_NAME="name";
	final String FIELD_EMAIL="email";
	final String FIELD_CITY="city";
	final String FIELD_GENDER="gender";
	final String FIELD_PHONE="phone";
	final String FIELD_ADDRESS="address";
	final String FIELD_AGE="age";
	
SQLiteDatabase sqLiteDatabase;
	
	LocalDataBase mDataBase;
	
	public  databaselibrary(Context context)
	{
	activityContext = context;	
	mDataBase=new LocalDataBase(activityContext, DATABASENAME, null, DATABASEVERSION);
	
	}

	
	public void Open()
	{
		sqLiteDatabase = mDataBase.getWritableDatabase();
	}
	
	public  void Close()
	{
		sqLiteDatabase.close();	
		
 	}
	
	class LocalDataBase extends SQLiteOpenHelper
	{

		public LocalDataBase(Context context, String name,
				CursorFactory factory, int version) {
			super(context, name, factory, version);
			// TODO Auto-generated constructor stub
			
			
			
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			// TODO Auto-generated method stub
			String mSql = "create table " + TABLENAME + 
					"(" + KEY_ID +   " Integer PRIMARY KEY autoincrement , "
					+ FIELD_NAME +    "  Text , " + FIELD_GENDER + " Text , " +  FIELD_CITY  + " Text , " 
					+  FIELD_EMAIL +  " Text , " + FIELD_ADDRESS   +  " Text , "
					+  FIELD_PHONE + " Text,"+  FIELD_AGE + " Text)";
			
			
			db.execSQL(mSql);
				
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// TODO Auto-generated method stub
			
			if(oldVersion != newVersion)
			{
				
				db.execSQL("drop table " + TABLENAME);
				onCreate(db);
				
			}
			
			
		}

			
	}//inner class
	
	public void newTourRecord(TourBook tBook)
	{
		ContentValues cValues=new ContentValues();
		
		cValues.put(FIELD_NAME, tBook.getName());
		cValues.put(FIELD_PHONE,tBook.getPhone());
		cValues.put(FIELD_EMAIL, tBook.getEmail());
		cValues.put(FIELD_AGE, tBook.getAge().toString());
		cValues.put(FIELD_ADDRESS, tBook.getAddress());
		cValues.put(FIELD_GENDER, tBook.getGender());
		cValues.put(FIELD_CITY, tBook.getCity());
		
		
		sqLiteDatabase.insertOrThrow(TABLENAME, null, cValues);
		
		return;
		
	}
	
	public void deleteTourRecord(int id)
	{
		String whereCond = KEY_ID + "= ?";
		
		String idvalue = String.valueOf(id);
		
		String[] CondiValues = {idvalue};
		
		sqLiteDatabase.delete(TABLENAME, whereCond, CondiValues);
		
		return;
		
	}
	
	
	public String ReadAllDetails()
	{
		String output="DataBase Records\n";
		
		String[] ColumnsList={ KEY_ID, FIELD_NAME,FIELD_EMAIL,FIELD_CITY,FIELD_PHONE,FIELD_GENDER,FIELD_AGE,FIELD_ADDRESS};
		
		Cursor cursor=sqLiteDatabase.query(TABLENAME, ColumnsList, 
				null, null, null, null, null);
		
		if(cursor.getCount() == 0)
		{
			output +=  "Empty Data SET";
		}
		else	
		{
			int counter=cursor.getCount();
			
			//readl all Index...
			int id_ind,name_ind,email_ind,address_ind,phone_ind,age_ind,gender_ind,city_ind;
			String name,email,phone,gender,city,age,address;
			int id;
			
			id_ind = cursor.getColumnIndex(KEY_ID);
			name_ind =  cursor.getColumnIndex(FIELD_NAME);
			age_ind = cursor.getColumnIndex(FIELD_AGE);
			address_ind = cursor.getColumnIndex(FIELD_ADDRESS);
			city_ind = cursor.getColumnIndex(FIELD_CITY);
			gender_ind = cursor.getColumnIndex(FIELD_GENDER);
			phone_ind = cursor.getColumnIndex(FIELD_PHONE);
			email_ind = cursor.getColumnIndex(FIELD_EMAIL);
			
			
			
			
			cursor.moveToFirst();	
			do
			{
				//to read all Column...
				//to read CurrentROW...
				id = cursor.getInt(id_ind);
				name=cursor.getString(name_ind);
				email= cursor.getString(email_ind);
				gender = cursor.getString(gender_ind);
				phone=cursor.getString(phone_ind);
				address= cursor.getString(address_ind);
				city=cursor.getString(city_ind);
				age= cursor.getString(age_ind);
				
				output += id + "\n" + name + "\n" + email + "\n" + 
								phone + "\n" + address + "\n" + age + "\n" + city +"\n" + gender + "\n\n";
				
				cursor.moveToNext();
				counter--;
			}while(counter>0);
		}
		return output;
	}
	
	
	
	public ArrayList<TourBook> TourList()
	{
		ArrayList<TourBook> tList;
		TourBook tbook;
		
		String[] ColumnsList={KEY_ID , FIELD_NAME,FIELD_EMAIL,FIELD_PHONE,FIELD_AGE,FIELD_ADDRESS,
				FIELD_GENDER,FIELD_CITY};
		
		Cursor cursor=sqLiteDatabase.query(TABLENAME, ColumnsList, 
				null, null, null, null, FIELD_PHONE);
		
		if(cursor.getCount() == 0)
		{
			tList=null;
		}
		else	
		{
			tList = new ArrayList<TourBook>();
			
			int counter=cursor.getCount();
			
			//readl all Index...
			int id_ind,name_ind,email_ind,city_ind,phone_ind,address_ind,age_ind,gender_ind;
			String name,email,phone,city,age,gender,address;
			int id;
			
			id_ind = cursor.getColumnIndex(KEY_ID);
			name_ind = cursor.getColumnIndex(FIELD_NAME);
			city_ind = cursor.getColumnIndex(FIELD_CITY);
			phone_ind = cursor.getColumnIndex(FIELD_PHONE);
			address_ind = cursor.getColumnIndex(FIELD_ADDRESS);
			email_ind = cursor.getColumnIndex(FIELD_EMAIL);
			gender_ind = cursor.getColumnIndex(FIELD_GENDER);
			age_ind = cursor.getColumnIndex(FIELD_AGE);
			
			cursor.moveToFirst();	
			do
			{
				//to read all Column...
				//to read CurrentROW...
				id=cursor.getInt(id_ind);
				name=cursor.getString(name_ind);
				email= cursor.getString(email_ind);
				phone = cursor.getString(phone_ind);
				address=cursor.getString(address_ind);
				age= cursor.getString(age_ind);
				city= cursor.getString(city_ind);
				gender= cursor.getString(gender_ind);
				
			
				tbook=new TourBook();
				tbook.setID(id);
				tbook.setName(name);
				tbook.setPhone(phone);
				tbook.setEmail(email);
				tbook.setCity(city);
				tbook.setAddress(address);
				tbook.setAge(age);
				tbook.setGender(gender);
				
				tList.add(tbook);
				
				cursor.moveToNext();
				counter--;
			}while(counter>0);
		}
		return tList;
	}
	
	public TourBook newTourRecord(int id)
	{
	
		TourBook tbook;
		
		String[] ColumnsList={KEY_ID , FIELD_NAME,FIELD_EMAIL,FIELD_AGE,FIELD_ADDRESS,FIELD_GENDER,FIELD_CITY,FIELD_PHONE};
		
		
		String whereCond = KEY_ID + "= ?";
		
		String idvalue = String.valueOf(id); //
		
		String[] CondiValues = {idvalue};
		
		Cursor cursor=sqLiteDatabase.query(TABLENAME, ColumnsList, whereCond,
				CondiValues, null, null, null);
		
		if(cursor.getCount() == 0)
		{
			return null;
		}
		else	
		{
			
			int id_ind,name_ind,email_ind,gender_ind,age_ind,address_ind,city_ind,phone_ind;
			String name,email,phone,city,address,age,gender;
		
			id_ind = cursor.getColumnIndex(KEY_ID);
			name_ind = cursor.getColumnIndex(FIELD_NAME);
			phone_ind = cursor.getColumnIndex(FIELD_PHONE);
			city_ind = cursor.getColumnIndex(FIELD_CITY);
			address_ind = cursor.getColumnIndex(FIELD_ADDRESS);
			gender_ind = cursor.getColumnIndex(FIELD_GENDER);
			age_ind = cursor.getColumnIndex(FIELD_AGE);
			email_ind = cursor.getColumnIndex(FIELD_EMAIL);
			
			cursor.moveToFirst();	

			id=cursor.getInt(id_ind);
			name=cursor.getString(name_ind);
			email= cursor.getString(email_ind);
			phone = cursor.getString(phone_ind);
			city=cursor.getString(city_ind);
			address= cursor.getString(address_ind);
			age=cursor.getString(age_ind);
			gender= cursor.getString(gender_ind);
			
			
			tbook=new TourBook();
			
			tbook.setID(id);
			tbook.setName(name);
			tbook.setPhone(phone);
			tbook.setEmail(email);
			tbook.setAddress(address);
			tbook.setAge(age);
			tbook.setGender(gender);
			tbook.setCity(city);
			
			return tbook;
		}
		
	}	
	
	
	


}// outer class


		


