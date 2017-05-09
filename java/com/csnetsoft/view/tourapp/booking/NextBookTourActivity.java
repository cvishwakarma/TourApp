package com.csnetsoft.view.tourapp.booking;


import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.csnetsoft.view.tourapp.R;
import com.csnetsoft.view.tourapp.database.TourBook;
import com.csnetsoft.view.tourapp.database.databaselibrary;

public class NextBookTourActivity extends Activity{
	
	EditText et_name, et_phone,et_email,et_address,et_age,et_city;
	Spinner spin_gender;

	
	Button btn_confirm;
		
	SharedPreferences mPref;  
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	
	setContentView(R.layout.next_book_tour_view);
	mPref=(SharedPreferences)
			PreferenceManager.getDefaultSharedPreferences(NextBookTourActivity.this);
	
	InitAllViews();
	setEventListener();

	}

	
	private void setEventListener() {
		// TODO Auto-generated method stub
		
		
		btn_confirm.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			
				SharedPreferences.Editor edit=mPref.edit();
				String name,email,phone,address,city,gender,age;
				
				name=et_name.getText().toString();
				phone=et_phone.getText().toString();
				email=et_email.getText().toString();
				address=et_address.getText().toString();
				age=et_age.getText().toString();
				city=et_city.getText().toString();
				gender=spin_gender.getSelectedItem().toString();
			
				
				TourBook tBook=new TourBook();
				tBook.setName(et_name.getText().toString());
				tBook.setEmail(et_email.getText().toString());
				tBook.setPhone(et_phone.getText().toString());
				tBook.setAddress(et_address.getText().toString());
				tBook.setGender(spin_gender.getSelectedItem().toString());
				tBook.setAge(et_age.getText().toString());
				tBook.setCity(et_city.getText().toString());
				
				
boolean flag=true;
				
				if(et_name.getText().toString().length() == 0)
				{
					et_name.setError("please Fill This Field..!!!");
					flag=false;
				}
					
				if(et_phone.getText().toString().length() == 0)
				{
					et_phone.setError("please Fill This Field..!!!");
					flag=false;
				}
				if(et_email.getText().toString().length() == 0)
				{
					et_email.setError("please Fill This Field..!!!");
					flag=false;
				}
			
				if(et_address.getText().toString().length() == 0)
				{
					et_address.setError("please Fill This Field..!!!");
					flag=false;
				}
			
				if(et_city.getText().toString().length() == 0)
				{
					et_city.setError("please Fill This Field..!!!");
					flag=false;
				}
				
				if(et_age.getText().toString().length() == 0)
				{
					et_age.setError("please Fill This Field..!!!");
					flag=false;
				}
		
				if(flag==true){
			databaselibrary dbl=new databaselibrary(getBaseContext());
			dbl.Open();
			dbl.newTourRecord(tBook);
			dbl.Close();
				
				Intent mIntent=new Intent(NextBookTourActivity.this,ViewTourBookActivity.class);
				startActivity(mIntent);
			    NextBookTourActivity.this.finish();
		
				}
			}
		});
		
		
		}

	
	private void InitAllViews() {
		// TODO Auto-generated method stub

		et_name=(EditText)findViewById(R.id.ntb_et_name);
		et_email=(EditText)findViewById(R.id.ntb_et_email);
		et_phone=(EditText)findViewById(R.id.ntb_et_phone);
		et_city=(EditText)findViewById(R.id.ntb_et_city);
		spin_gender=(Spinner)findViewById(R.id.ntb_spin_gender);
		et_address=(EditText)findViewById(R.id.ntb_et_address);
		et_age=(EditText)findViewById(R.id.ntb_et_age);
		
		btn_confirm=(Button)findViewById(R.id.ntb_btn_confirm);
	

	}

	

}
