package com.csnetsoft.view.tourapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FloorLayoutActivity extends Activity {

	
	String floor;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.floor_layout_view);
		
		Bundle data=getIntent().getExtras();
		floor=data.getString("floor").toString();
		
	}
	
	public void Booking(View v)
	{
		Intent mIntent=new Intent(getBaseContext() , NewBooking.class);
		mIntent.putExtra("floor", floor);
		if(v.getId() == R.id.button1)
		{
			mIntent.putExtra("park","1");
		}
		else if(v.getId() == R.id.button2)
		{
			mIntent.putExtra("park","2");
		}
		else if(v.getId() == R.id.button3)
		{
			mIntent.putExtra("park","3");
		}
		
		else if(v.getId() == R.id.button4)
		{
			mIntent.putExtra("park","4");
		}
		else if(v.getId() == R.id.button5)
		{
			mIntent.putExtra("park","5");
		}
		
		startActivity(mIntent);
		
		FloorLayoutActivity.this.finish();
		
		
	}
}
