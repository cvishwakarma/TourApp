package com.csnetsoft.view.tourapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;

public class DatePickerChildActivity extends Activity {

	DatePicker dp_picker;
	Button btn_action;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.date_picker_child_view);
		
		InitallViews();
		setActionEvent();
		
	}

	private void setActionEvent() {
		// TODO Auto-generated method stub
		
		btn_action.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				
				int day = dp_picker.getDayOfMonth();
				int month = dp_picker.getMonth();
				int year = dp_picker.getYear();
				
				String[] MonthList={"Jan","Feb","March","April",
						"May","June","July","Aug",
						"Sep","Oct","Nov","Dec"};
				
				String selectdate = day + "/" +  MonthList[month].toString()   + "/" + year;
				
				Intent data=new Intent();
				data.putExtra("result", selectdate);
				
				setResult(RESULT_OK, data);
				
					
				DatePickerChildActivity.this.finish();
				
			}
		});
	}

	private void InitallViews() {
		// TODO Auto-generated method stub
		
		btn_action=(Button)findViewById(R.id.dpca_btn_action);
		dp_picker=(DatePicker)findViewById(R.id.dpca_dp_date);
	}
	
}
