package com.csnetsoft.view.tourapp.booking;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.csnetsoft.view.tourapp.R;
import com.csnetsoft.view.tourapp.adapter.BookingAccountListAdapter;
import com.csnetsoft.view.tourapp.database.TourBook;
import com.csnetsoft.view.tourapp.database.databaselibrary;

import java.util.ArrayList;

public class BookAccountActivity extends Activity{
	
final String URL="http://www.ishanviinfosoft.in/demo/tourapp/confirmbooking.php";
	
	ListView lv_tList;
	Context activityContext;
	ArrayList<TourBook> tbList;
	
	//String Tourid;
	
	
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.book_account_list);
		
		
		//Tourid = getIntent().getExtras().getString("id").toString();
		
		InitAllViews();
		
	}
	
	
	
	private void InitAllViews()
	{
		lv_tList=(ListView)findViewById(R.id.balv_fullList);
		
		activityContext= BookAccountActivity.this;
		
		databaselibrary dbl=new databaselibrary(activityContext);
		dbl.Open();
		tbList = dbl.TourList();
		dbl.Close();
		
		if( tbList == null)
		{
			Toast.makeText(getBaseContext(), "No Booking Avail..!!!", Toast.LENGTH_SHORT).show();
			return;
		}
		BookingAccountListAdapter adapter = new BookingAccountListAdapter(activityContext, tbList);
		lv_tList.setAdapter(adapter);
		
				
	}
		

}
