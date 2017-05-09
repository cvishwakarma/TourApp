package com.csnetsoft.view.tourapp.booking;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.csnetsoft.view.tourapp.R;

public class BookingActivity extends Activity{

	Button btn_action1,btn_action2;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	setContentView(R.layout.booking_tour_view);
	InitAllViews();
	SetEventListeners();
	
	}

	private void SetEventListeners() {
		// TODO Auto-generated method stub
		
		btn_action1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Intent mIntent =new Intent(BookingActivity.this,NextBookTourActivity.class);
				startActivity(mIntent);
			}
		});
		
		btn_action2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent mIntent=new Intent(BookingActivity.this,BookTourActivity.class);
				startActivity(mIntent);
			}
		});
	}

	private void InitAllViews() {
		// TODO Auto-generated method stub
		
		btn_action1=(Button)findViewById(R.id.bk_btn_single);
		btn_action2=(Button)findViewById(R.id.bk_btn_multi);
		
	}
}
