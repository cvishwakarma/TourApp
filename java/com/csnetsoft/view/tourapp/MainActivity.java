package com.csnetsoft.view.tourapp;


import android.app.Activity;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

import com.csnetsoft.view.tourapp.booking.BookAccountActivity;
import com.csnetsoft.view.tourapp.booking.CustomizedBookActivity;
import com.csnetsoft.view.tourapp.booking.EnquiryActivity;

import java.io.File;

public class MainActivity extends Activity {

	
	Button btn_booking,btn_view,btn_cancel,btn_enquiry;
	ImageView iv_image;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_view);
		setEventListener();
	}

	

	private void setEventListener() {
		// TODO Auto-generated method stub
		iv_image=(ImageView)findViewById(R.id.imageView2);
		
	iv_image.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
			 try {

				 PackageManager pm = getPackageManager();
				 ApplicationInfo ai = pm.getApplicationInfo(getPackageName(), 0);
				 File srcFile = new File(ai.publicSourceDir);
				 Intent share = new Intent();
				 share.setAction(Intent.ACTION_SEND);
				 share.setType("application/vnd.android.package-archive");
				 share.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(srcFile));
				 startActivity(Intent.createChooser(share, "Please Select Source."));
				 } catch (Exception e) {
				 Log.e("ShareApp", e.getMessage());
				 }

			
			
		}
	});
	}



	public void pageaction(View v)
	{
		if(v.getId() == R.id.btn_book)
		{
			Intent mIntent=new Intent(getBaseContext() ,PackageTourActivity.class);
			startActivity(mIntent);
		}
		else if(v.getId() == R.id.btn_view)
		{
			Intent mIntent=new Intent(getBaseContext() , BookAccountActivity.class);
			startActivity(mIntent);
		}
		else if(v.getId() == R.id.btn_cancel)
		{
			Intent mIntent=new Intent(getBaseContext() , CustomizedBookActivity.class);
			startActivity(mIntent);
		}
		
		else if(v.getId() == R.id.btn_enquiry)
		{
			Intent mIntent=new Intent(getBaseContext() , EnquiryActivity.class);
			startActivity(mIntent);
		}
		
		
	}
}
