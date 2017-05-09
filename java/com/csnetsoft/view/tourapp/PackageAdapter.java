package com.csnetsoft.view.tourapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class PackageAdapter extends BaseAdapter {

	ArrayList<PackageMaster> MainList;
	Context mContext;
	SharedPreferences mpref;
	
	public PackageAdapter(ArrayList<PackageMaster> iList, Context mContext, SharedPreferences sp) {
		// TODO Auto-generated constructor stub
		this.MainList=iList;
		this.mContext=mContext;
		mpref=sp;
		
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return MainList.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return MainList.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		
		View mView = convertView;
		
		if(mView == null)
		{
			LayoutInflater inflater=(LayoutInflater)mContext.getSystemService(mContext.LAYOUT_INFLATER_SERVICE);
			mView = inflater.inflate(R.layout.package_layout_item_view, parent,false);
		}
		
		TextView tv_name=(TextView)mView.findViewById(R.id.tv_name);
		TextView tv_id=(TextView)mView.findViewById(R.id.tv_id);
		TextView tv_source=(TextView)mView.findViewById(R.id.tv_source);
		TextView tv_dest=(TextView)mView.findViewById(R.id.tv_dest);
		TextView tv_days=(TextView)mView.findViewById(R.id.tv_days);
		TextView tv_nights=(TextView)mView.findViewById(R.id.tv_nights);
		TextView tv_date=(TextView)mView.findViewById(R.id.tv_date);
		TextView tv_mode=(TextView)mView.findViewById(R.id.tv_mode);
		TextView tv_amount=(TextView)mView.findViewById(R.id.tv_amount);
			
		
		
		
		PackageMaster iMaster=(PackageMaster)getItem(position);
		
		// Filling...
		
		tv_name.setText(   iMaster.name);
		tv_id.setText(   iMaster.id);
		tv_source.setText("Source : " +   iMaster.source);
		tv_dest.setText("Destination : " +    iMaster.dest);
		tv_date.setText("Tour Date : " +    iMaster.date);
		tv_days.setText("DAYS : " +  iMaster.day);
		tv_nights.setText("NIGHT : " + iMaster.night);
		tv_mode.setText("Travel Mode : " + iMaster.mode);
		tv_amount.setText("Tour Amount : " + iMaster.amount + "(Per Head )");
		
		
		
		//READ Image FROM URL
		/*String imageurl = iMaster.getURL();
		try
		{
		StrictMode.enableDefaults();
		URL url = new URL(imageurl);
		Bitmap bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
		iv_image.setImageBitmap(bmp);
		}
		catch(Exception ex)
		{
			Toast.makeText(mContext, imageurl, 1).show();
			//Log.e("Image Error", ex.getMessage());
		}*/		
		
		
		mView.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				TextView tv_id=(TextView)v.findViewById(R.id.tv_id);
				String id = tv_id.getText().toString();
				
		    SharedPreferences.Editor edit=mpref.edit();
				
		    TextView tv_name=(TextView)v.findViewById(R.id.tv_name);
			TextView tv_source=(TextView)v.findViewById(R.id.tv_source);
			TextView tv_dest=(TextView)v.findViewById(R.id.tv_dest);
				
		    
		    
			String ptitle,src,destination;
			ptitle=tv_name.getText().toString();
			src=tv_source.getText().toString();
			destination=tv_dest.getText().toString();
				
				
			edit.putString("PackageTitle", ptitle);
			edit.putString("Source",src );
			edit.putString("destination", destination);
				
				
			edit.commit(); 
				
				
			
			Intent mIntent=new Intent(mContext , PackageTourHighlightActivity.class);
			mIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			mIntent.putExtra("id", id);
				
				mContext.startActivity(mIntent);
			}
		});
		
		return mView;
	}

}
