package com.csnetsoft.view.tourapp.booking;


import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.csnetsoft.view.tourapp.R;

import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;

public class EnquiryActivity extends Activity {

	String URL="http://www.ishanviinfosoft.in/demo/tourapp/newenquiry.php";
	
	EditText et_name,et_phone,et_email,et_city,et_about;
	String name,email,phone,city,about;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.enquiry_view);
		initallViews();
	}
	
	private void initallViews() {
		// TODO Auto-generated method stub
		et_name = (EditText)findViewById(R.id.et_f2);
		et_email = (EditText)findViewById(R.id.et_f3);
		et_phone = (EditText)findViewById(R.id.et_f4);
		et_city = (EditText)findViewById(R.id.et_f5);
		et_about = (EditText)findViewById(R.id.et_f6);
		
		
	}

	public void Send(View v)
	{
		Boolean flag=true;
		if(et_name.getText().length()==0)
		{
			et_name.setError("Please Fill This Field..!!!");
			flag=false;	
		}
		
		if(et_email.getText().length()==0)
		{
			et_email.setError("Please Fill This Field..!!!");
			flag=false;	
		}
		
		if(et_phone.getText().length()==0)
		{
			et_phone.setError("Please Fill This Field..!!!");
			flag=false;	
		}
		
		if(et_city.getText().length()==0)
		{
			et_city.setError("Please Fill This Field..!!!");
			flag=false;	
		}
		
		if(et_about.getText().length()==0)
		{
			et_about.setError("Please Fill This Field..!!!");
			flag=false;	
		}
		
		if(flag==true)
		{
			name=et_name.getText().toString();
			email=et_email.getText().toString();
			phone=et_phone.getText().toString();
			about=et_about.getText().toString();
			city=et_city.getText().toString();
			
			new uploadToServer().execute();
			
		}
		
		
		return;
	}
	
	public void Reset(View v)
	{
		et_about.setText("");
		et_email.setText("");
		et_phone.setText("");
		et_name.setText("");
		et_city.setText("");
		et_name.requestFocus();

		return;
	}
	
	
	 public class uploadToServer extends AsyncTask<Void, Void, String> {
		 String error="no error";
	     private ProgressDialog pd = new ProgressDialog(EnquiryActivity.this);
	     protected void onPreExecute() {
	         super.onPreExecute();
	         pd.setMessage("Please Wait...!!");
	         pd.show();
	     }

	     @Override
	     protected String doInBackground(Void... params) {

	         ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
	         nameValuePairs.add(new BasicNameValuePair("name",name));
	         nameValuePairs.add(new BasicNameValuePair("email",email));
	         nameValuePairs.add(new BasicNameValuePair("phone",phone));
	         nameValuePairs.add(new BasicNameValuePair("city",city));
	         nameValuePairs.add(new BasicNameValuePair("about",about));
	         
	       
	         try {
	        	 StrictMode.enableDefaults();
	             HttpClient httpclient = new DefaultHttpClient();
	             HttpPost httppost = new HttpPost(URL);
	             httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
	             
	             httpclient.execute(httppost);

	         } catch (Exception e) {
	        	
	             Log.v("log_tag", "Error in http connection " + e.toString());
	         }
	         return "Success";

	     }

	     protected void onPostExecute(String result) {
	         super.onPostExecute(result);
	         pd.hide();
	         pd.dismiss();

	        et_about.setText("");
	 		et_email.setText("");
	 		et_phone.setText("");
	 		et_name.setText("");
	 		et_city.setText("");
	 		et_name.requestFocus();

	     }
	 }
	
	
}
