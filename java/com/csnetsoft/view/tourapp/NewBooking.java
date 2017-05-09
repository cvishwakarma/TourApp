package com.csnetsoft.view.tourapp;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;

public class NewBooking extends Activity {
	
	Button btn_date,btn_time,btn_send;
	TextView tv_time,tv_date;
	EditText et_regno;
	Spinner duration;
	final int REQUESTCODE1=101;
	final int REQUESTCODE2=201;
	
	final String URL = "http://www.ishanviinfosoft.in/demo/parkingsystem/booking.php";

	
	String floor,park;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.new_booking_view);
		
		Bundle data=getIntent().getExtras();
		floor=data.getString("floor").toString();
		park=data.getString("park").toString();
		InitAllViews();
		SetEventListener();
	}
	
	
	private void InitAllViews()
	{
		btn_date=(Button)findViewById(R.id.btn_date);
		btn_time=(Button)findViewById(R.id.btn_time);
		btn_send=(Button)findViewById(R.id.btn_book);

		tv_date=(TextView)findViewById(R.id.tv_date);
		tv_time=(TextView)findViewById(R.id.tv_time);
		
		
		et_regno=(EditText)findViewById(R.id.et_regno);
		duration=(Spinner)findViewById(R.id.spinner_duration);
		
	}
	
	private void SetEventListener()
	{
		btn_date.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			
				Intent mIntent=new Intent(NewBooking.this,DatePickerChildActivity.class);
				startActivityForResult(mIntent, REQUESTCODE1);
			}
		});
		
		
		btn_time.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			
				Intent mIntent=new Intent(NewBooking.this,TimePickerChildActivity.class);
				startActivityForResult(mIntent, REQUESTCODE2);
			}
		});
		
		btn_send.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			
				BasicNameValuePair field1 = new BasicNameValuePair("f1", tv_date.getText().toString());
				BasicNameValuePair field2 = new BasicNameValuePair("f2", tv_time.getText().toString());
				BasicNameValuePair field3 = new BasicNameValuePair("f3", duration.getSelectedItem().toString());
				BasicNameValuePair field4 = new BasicNameValuePair("f4", et_regno.getText().toString());
				BasicNameValuePair field5 = new BasicNameValuePair("f5", floor);
				BasicNameValuePair field6 = new BasicNameValuePair("f6", park);
				
				ArrayList<NameValuePair> dataPack=new ArrayList<NameValuePair>();
				
				dataPack.add(field1);
				dataPack.add(field2);
				dataPack.add(field3);
				dataPack.add(field4);
				dataPack.add(field5);
				dataPack.add(field6);
				
				
				try
				{
					StrictMode.enableDefaults();
					HttpClient  client = new DefaultHttpClient();
					HttpPost httpPost = new HttpPost(URL);
					
					httpPost.setEntity(new UrlEncodedFormEntity(dataPack));
					client.execute(httpPost);
					Toast.makeText(getBaseContext(), "Booking Done", 1).show();
					
					
					NewBooking.this.finish();
				}
				catch(Exception ex)
					{
						// 
					}
				
				
				
				
			}
		});
		
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		
		if(requestCode == REQUESTCODE1   && resultCode == RESULT_OK)
		{
			Bundle datapack= data.getExtras();
			String selectdate = datapack.getString("result");
			tv_date.setText(selectdate);
		}
		else if(requestCode == REQUESTCODE2   && resultCode == RESULT_OK)
		{
			Bundle datapack= data.getExtras();
			String selectdate = datapack.getString("result");
			tv_time.setText(selectdate);
		}

	}
	
	
}
