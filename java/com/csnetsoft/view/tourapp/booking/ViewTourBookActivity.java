package com.csnetsoft.view.tourapp.booking;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.csnetsoft.view.tourapp.R;
import com.csnetsoft.view.tourapp.database.databaselibrary;

public class ViewTourBookActivity extends Activity{
	
	Button btn_pay;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tourbook_view);
		InitAllViews();
		SetEventListeners();
		
		
		databaselibrary dblobj=new databaselibrary(ViewTourBookActivity.this);
		dblobj.Open();
		String output = dblobj.ReadAllDetails();
		dblobj.Close();

		TextView tv_output=(TextView)findViewById(R.id.tb_tv_output);
		tv_output.setText(output);
		
		
		
	}

	private void SetEventListeners() {
		// TODO Auto-generated method stub
		
		btn_pay.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			
				Intent mIntent=new Intent(ViewTourBookActivity.this,TourBookListActivity.class);
				startActivity(mIntent);
				
			}
		});
		
	}

	private void InitAllViews() {
		// TODO Auto-generated method stub
		btn_pay=(Button)findViewById(R.id.tb_btn_pay);
	}

}
