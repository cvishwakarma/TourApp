package com.csnetsoft.view.tourapp.booking;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.csnetsoft.view.tourapp.MainActivity;
import com.csnetsoft.view.tourapp.R;
import com.csnetsoft.view.tourapp.adapter.TourBookListAdapter;
import com.csnetsoft.view.tourapp.database.TourBook;
import com.csnetsoft.view.tourapp.database.databaselibrary;

import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.InputStream;
import java.util.ArrayList;

public class TourBookListActivity extends Activity{

	final String URL="http://www.ishanviinfosoft.in/demo/tourapp/confirmbooking.php";
	
	ListView lv_tList;
	Context activityContext;
	ArrayList<TourBook> tbList;
	Button btn_confirm , btn_goback;
	EditText et_name,et_phone,et_email,et_address,et_city,et_age;
	Spinner spin_gender;
	
	String Tourid;
	
	String name,email,address,age,city,gender,phone,tourid;
	
	
	InputStream is=null;
	String FinalOutput=null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tourbook_list);
		
		InitAllViews();
		SetEventListener();
	}
	private void SetEventListener() {
		// TODO Auto-generated method stub
			btn_confirm.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				try
				{
					StrictMode.enableDefaults();
				HttpClient client=new DefaultHttpClient();
				HttpPost httpPost = new HttpPost(URL);
			
				
				databaselibrary dbl=new databaselibrary(TourBookListActivity.this);
				dbl.Open();
				ArrayList<TourBook> tbbook=dbl.TourList();
				dbl.Close();
				Toast.makeText(getApplicationContext(), "db done sent ot site", 1).show();
				for(int i=0;i<tbbook.size();i++)
				{
					TourBook tbook=tbbook.get(i);
				
				
				
				ArrayList<NameValuePair> data=new ArrayList<NameValuePair>();
				BasicNameValuePair field = new BasicNameValuePair("name",tbook.getName().toString());
				BasicNameValuePair field2 = new BasicNameValuePair("eml",tbook.getEmail().toString());
				BasicNameValuePair field3 = new BasicNameValuePair("age",tbook.getAge().toString());
				BasicNameValuePair field4 = new BasicNameValuePair("add",tbook.getAddress().toString());
				BasicNameValuePair field5 = new BasicNameValuePair("gd", tbook.getGender().toString());
				BasicNameValuePair field6 = new BasicNameValuePair("cty",tbook.getCity().toString());
				BasicNameValuePair field7 = new BasicNameValuePair("pn", tbook.getPhone().toString());
				BasicNameValuePair field8 = new BasicNameValuePair("tourid",Tourid);

		
				data.add(field);
				data.add(field2);
				data.add(field3);
				data.add(field4);
				data.add(field5);
				data.add(field6);
				data.add(field7);
				data.add(field8);
				
				
				httpPost.setEntity(new UrlEncodedFormEntity(data));
				
				 client.execute(httpPost); 
				
				}
				//is=response.getEntity().getContent();
				}
				catch(Exception ex)
				{
				Toast.makeText(getApplicationContext(), ex.getMessage(), 1).show();
					Log.e("Error", ex.getMessage());
				}
				
				
				
				
				
			}
		});
		
		
		btn_goback.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				 //TODO Auto-generated method stub
				setContentView(R.layout.tourbook_list);

				Intent mIntent=new Intent(TourBookListActivity.this,MainActivity.class);
				startActivity(mIntent);
			TourBookListActivity.this.finish();
			
			}
		});
	}
	private void InitAllViews()
	{
		lv_tList=(ListView)findViewById(R.id.tblv_fullList);
		
		activityContext= TourBookListActivity.this;
		
		databaselibrary dbl=new databaselibrary(activityContext);
		dbl.Open();
		tbList = dbl.TourList();
		dbl.Close();
		
		TourBookListAdapter adapter = new TourBookListAdapter(activityContext, tbList);
		lv_tList.setAdapter(adapter);
		
		btn_confirm=(Button)findViewById(R.id.tb_btn_confirm);
		btn_goback=(Button)findViewById(R.id.tb_btn_gb);		
	}

}
