package com.csnetsoft.view.tourapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class NewBookingFloor extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.booking_view);
	}
	
	public void pageaction(View v)
	{
		if(v.getId() == R.id.btn_basement)
		{
			Intent mIntent=new Intent(getBaseContext() , FloorLayoutActivity.class);
			mIntent.putExtra("floor","Basement");
			startActivity(mIntent);
		}
		else if(v.getId() == R.id.btn_floor1)
		{
			Intent mIntent=new Intent(getBaseContext() , FloorLayoutActivity.class);
			mIntent.putExtra("floor","First Floor");
			startActivity(mIntent);
		}
		else if(v.getId() == R.id.btn_floor2)
		{
			Intent mIntent=new Intent(getBaseContext() , FloorLayoutActivity.class);
			mIntent.putExtra("floor","Second floor");
			startActivity(mIntent);
		}
		
		NewBookingFloor.this.finish();
		
	}
}
