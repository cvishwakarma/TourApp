package com.csnetsoft.view.tourapp.booking;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.csnetsoft.view.tourapp.R;
import com.csnetsoft.view.tourapp.RegisterActivity;

public class SplashActivity extends Activity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash_view);
	
		
		Thread cThread=new Thread(new MySplashThread());
		cThread.start(); // to execute run function....
		
	}
	
	
	// Nested CLASS...
	class MySplashThread implements Runnable
	{
		@Override
		public void run() {
			// TODO Auto-generated method stub
			
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			Intent mIntent=new Intent(SplashActivity.this ,RegisterActivity.class);
			startActivity(mIntent);
			SplashActivity.this.finish();
			
		}
	}

}
