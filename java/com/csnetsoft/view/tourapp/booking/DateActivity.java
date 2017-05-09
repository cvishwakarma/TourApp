package com.csnetsoft.view.tourapp.booking;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;

import com.csnetsoft.view.tourapp.R;

public class DateActivity extends Activity{
	
	DatePicker date_pick;
	Button btn_date;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.date_view);
		
		date_pick = (DatePicker) findViewById(R.id.dv_datepck);
		btn_date = (Button) findViewById(R.id.dv_btn_date);
		
		btn_date.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				int day = date_pick.getDayOfMonth();
				int month = date_pick.getMonth();
				int year = date_pick.getYear();
				
				String output = day + "/" + month + "/" + year;
				Intent mIntent = new Intent();
				mIntent.putExtra("date", output);
				setResult(RESULT_OK, mIntent);
				DateActivity.this.finish();
				
			}
		});
	}


}
