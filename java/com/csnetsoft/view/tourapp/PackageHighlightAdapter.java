package com.csnetsoft.view.tourapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class PackageHighlightAdapter extends BaseAdapter {

	ArrayList<PackageHighlightMaster> MainList;
	Context mContext;
	
	
	public PackageHighlightAdapter(ArrayList<PackageHighlightMaster> iList, Context mContext) {
		// TODO Auto-generated constructor stub
		this.MainList=iList;
		this.mContext=mContext;
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
			mView = inflater.inflate(R.layout.package_highlight_item_view, parent,false);
		}
		
		TextView tv_name=(TextView)mView.findViewById(R.id.tv_pname);
		TextView tv_city=(TextView)mView.findViewById(R.id.tv_city);
		TextView tv_about=(TextView)mView.findViewById(R.id.tv_about);
		
		
		
		
		PackageHighlightMaster iMaster=(PackageHighlightMaster)getItem(position);
		
		// Filling...
		
		tv_name.setText( "PLACE NAME : " +   iMaster.pname);
		tv_city.setText("CITY NAME : " +    iMaster.city);
		tv_about.setText("About PLACE : " + iMaster.about);
		
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
		return mView;
	}

}
