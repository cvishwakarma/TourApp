package com.csnetsoft.view.tourapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.csnetsoft.view.tourapp.R;
import com.csnetsoft.view.tourapp.database.TourBook;
import com.csnetsoft.view.tourapp.database.databaselibrary;

import java.util.ArrayList;

public class TourBookListAdapter  extends BaseAdapter{

	Context activityContext;
	ArrayList<TourBook> tbList;
	
	public TourBookListAdapter(Context context , ArrayList<TourBook> list)
	{
		this.activityContext=context;
		this.tbList = list;
		
	}

	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return this.tbList.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return this.tbList.get(arg0);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		
		
		
      View myview=convertView;
		
		//step 1 : Layout
		if( myview == null)
		{
			//first record...
			
			LayoutInflater inflater=(LayoutInflater)activityContext.getSystemService
					(activityContext.LAYOUT_INFLATER_SERVICE);
			myview = inflater.inflate(R.layout.tour_book_item_view, parent, false);
		}
	
		
		// Step 2 Inner View & Init..
		TextView tv_id , tv_name,tv_email , tv_address , tv_age , tv_city,tv_gender,tv_phone;
		Button btn_delete, btn_confirm;
		
		tv_id=(TextView)myview.findViewById(R.id.tb_lv_item_id);
		tv_name = (TextView)myview.findViewById(R.id.tb_lv_tv_name);
		tv_email = (TextView)myview.findViewById(R.id.tb_lv_tv_email);
		tv_gender = (TextView)myview.findViewById(R.id.tb_lv_tv_gender);
		tv_phone = (TextView)myview.findViewById(R.id.tb_lv_tv_phone);
		tv_city = (TextView)myview.findViewById(R.id.tb_lv_tv_city);
		tv_address = (TextView)myview.findViewById(R.id.tb_lv_tv_address);
		tv_age = (TextView)myview.findViewById(R.id.tb_lv_tv_age);
		
		btn_delete=(Button)myview.findViewById(R.id.tb_btn_actiondelete);
		btn_confirm=(Button)myview.findViewById(R.id.tb_btn_confirm);
		
		//Step 3 RECORD READING....
		TourBook tBook=(TourBook) this.getItem(position);
		
		String name,email,age ,phone,address,gender,city;
		
		int id = tBook.getID();
		name = tBook.getName();
		email = tBook.getEmail();
		city = tBook.getCity();
		phone = tBook.getPhone();
		age = tBook.getAge();
		address = tBook.getAddress();
		gender = tBook.getGender();
		
		
		//STEP 4 : filling
		
		tv_id.setText( String.valueOf(id)  );
		tv_name.setText(name);
		tv_email.setText(email);
		tv_city.setText(city);
		tv_phone.setText(phone);
		tv_address.setText(address);
		tv_age.setText(age);
		tv_gender.setText(gender);
		
		
		btn_delete.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				View parentview = (View)((Button)v).getParent(); //  Linear Layout
				parentview = (View)parentview.getParent(); //  relative Layout
				
				TextView tv_item_id = (TextView)parentview.findViewById(R.id.tb_lv_item_id);
				
				String recordid = tv_item_id.getText().toString();
				
				int id=Integer.parseInt(recordid);
				
				databaselibrary dblobj=new databaselibrary(activityContext);
				dblobj.Open();
					dblobj.deleteTourRecord(id);
				dblobj.Close();
				
    	
				/*Intent mIntent=new Intent(activityContext,BookTourActivity.class);
				
				//that code work for refresh activity listview
				
				mIntent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
				mIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				activityContext.startActivity(mIntent);
					
				*/
		
			}
		});
		
	
	
		
	return myview;
	
	}
	
			

	
}
