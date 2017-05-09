package com.csnetsoft.view.tourapp.booking;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import com.csnetsoft.view.tourapp.R;

import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;


public class CustomizedBookActivity extends Activity{
	
	final String URL = "http://www.ishanviinfosoft.in/demo/tourapp/customizedbooking.php";
	
	EditText et_cname,et_ctname,et_date;
	Spinner spin_days,spin_mode,spin_hotel,spin_vmode;
	CheckBox cb_ptaxi;
	Button btn_date,btn_action;
	final int REQUESTCODE = 101;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.customized_book_view);
		InitAllViews();
		setEventListener();
	}

	private void setEventListener() {
		// TODO Auto-generated method stub
		
		btn_action.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				ArrayList<NameValuePair> dataPack=new ArrayList<NameValuePair>();

				boolean flag=true;
				
				if(et_cname.getText().toString().length() == 0)
				{
					et_cname.setError("please Fill This Field..!!!");
					flag=false;
				}
					
				if(et_ctname.getText().toString().length() == 0)
				{
					et_ctname.setError("please Fill This Field..!!!");
					flag=false;
				}
				if(et_date.getText().toString().length() == 0)
				{
					et_date.setError("please Fill This Field..!!!");
					flag=false;
				}
			
				if(flag==true){
				BasicNameValuePair field1 = new BasicNameValuePair("cityfrom", et_cname.getText().toString());
				BasicNameValuePair field2 = new BasicNameValuePair("cityto", et_ctname.getText().toString());
				BasicNameValuePair field3 = new BasicNameValuePair("date", et_date.getText().toString());
				BasicNameValuePair field4 = new BasicNameValuePair("days", spin_days.getSelectedItem().toString());
				BasicNameValuePair field5 = new BasicNameValuePair("mode", spin_mode.getSelectedItem().toString());
				BasicNameValuePair field6 = new BasicNameValuePair("hotel", spin_hotel.getSelectedItem().toString());
				BasicNameValuePair field7 = new BasicNameValuePair("ptaxi", "no");
				BasicNameValuePair field8 = new BasicNameValuePair("vmode", spin_vmode.getSelectedItem().toString());
				
				dataPack.add(field1);
				dataPack.add(field2);
				dataPack.add(field3);
				dataPack.add(field4);
				dataPack.add(field5);
				dataPack.add(field6);
				dataPack.add(field7);
				dataPack.add(field8);
				
				try
				{
					
					StrictMode.enableDefaults();
					HttpClient  client = new DefaultHttpClient();
					HttpPost httpPost = new HttpPost(URL);
					
					httpPost.setEntity(new UrlEncodedFormEntity(dataPack));
					client.execute(httpPost);
				}
				catch(Exception ex)
					{
					
					  Log.v("log_tag", "Error in http connection " + ex.toString());
					}
				//Toast.makeText(getBaseContext(), "Url Error", 1).show();
			}
				}
		});
		
		btn_date.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent mIntent = new Intent(CustomizedBookActivity.this, DateActivity.class);
				startActivityForResult(mIntent, REQUESTCODE);
			}
		});
	}

	

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if(requestCode == REQUESTCODE && resultCode == RESULT_OK)
		{
			Bundle datapack = data.getExtras();
			String output = datapack.getString("date");
			
			et_date.setText(output);
		}
		
	}
	private void InitAllViews() {
		// TODO Auto-generated method stub
		
		et_cname=(EditText)findViewById(R.id.csb_et_cname);
		et_ctname=(EditText)findViewById(R.id.csb_et_ctname);
		et_date=(EditText)findViewById(R.id.csb_et_date);
		spin_vmode=(Spinner)findViewById(R.id.csb_spin_vmode);
		spin_days=(Spinner)findViewById(R.id.csb_spin_days);
		spin_mode=(Spinner)findViewById(R.id.csb_spin_mode);
		spin_hotel=(Spinner)findViewById(R.id.csb_spin_hotel);
		cb_ptaxi=(CheckBox)findViewById(R.id.csb_cb_ptaxi);
		btn_date=(Button)findViewById(R.id.csb_btn_date);
		btn_action=(Button)findViewById(R.id.csb_btn_action);
	}

}
