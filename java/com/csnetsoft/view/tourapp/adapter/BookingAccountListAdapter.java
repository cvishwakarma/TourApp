package com.csnetsoft.view.tourapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class BookingAccountListAdapter extends BaseAdapter{
	
	Context activityContext;
	ArrayList<TourBook> tbList;
	
	public BookingAccountListAdapter(Context context , ArrayList<TourBook> list)
	{
		this.activityContext=context;
		this.tbList = list;
		
	}

	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return this.tbList.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return this.tbList.get(arg0);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		
		
		
      View myview=convertView;
		
		//step 1 : Layout
		if( myview == null)
		{
			//first record...
			
			LayoutInflater inflater=(LayoutInflater)activityContext.getSystemService
					(activityContext.LAYOUT_INFLATER_SERVICE);
			myview = inflater.inflate(R.layout.book_account_view, parent, false);
			
		}
	
		
		// Step 2 Inner View & Init..
		TextView tv_id , tv_name,tv_email , tv_address , tv_age , tv_city,tv_gender,tv_phone;
		
		
		tv_id=(TextView)myview.findViewById(R.id.ba_lv_item_id);
		tv_name = (TextView)myview.findViewById(R.id.ba_lv_tv_name);
		tv_email = (TextView)myview.findViewById(R.id.ba_lv_tv_email);
		tv_gender = (TextView)myview.findViewById(R.id.ba_lv_tv_gender);
		tv_phone = (TextView)myview.findViewById(R.id.ba_lv_tv_phone);
		tv_city = (TextView)myview.findViewById(R.id.ba_lv_tv_city);
		tv_address = (TextView)myview.findViewById(R.id.ba_lv_tv_address);
		tv_age = (TextView)myview.findViewById(R.id.ba_lv_tv_age);
		
		
		//Step 3 RECORD READING....
		TourBook tBook=(TourBook) this.getItem(position);
		
		String name,email,age ,phone,address,gender,city;
		
		int id = tBook.getID();
		name = tBook.getName();
		email = tBook.getEmail();
		city = tBook.getCity();
		phone = tBook.getPhone();
		age = tBook.getAge();
		address = tBook.getAddress();
		gender = tBook.getGender();
		
		
		//STEP 4 : filling
		
		tv_id.setText( String.valueOf(id)  );
		tv_name.setText(name);
		tv_email.setText(email);
		tv_city.setText(city);
		tv_phone.setText(phone);
		tv_address.setText(address);
		tv_age.setText(age);
		tv_gender.setText(gender);
		
	
	return myview;
	
	}
	
			


}
