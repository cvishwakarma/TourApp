package com.csnetsoft.view.tourapp;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class ConnectionDetector {

		Context mContext;
		public ConnectionDetector(Context context)
		{
			this.mContext= context;
		}

		
//ConnectivityManager
//	NetworkInfo[]

		public Boolean isConnected()
		{
			ConnectivityManager manager=(ConnectivityManager)
					mContext.getSystemService(mContext.CONNECTIVITY_SERVICE);
			
			NetworkInfo[] infos = manager.getAllNetworkInfo();
			NetworkInfo node;
			
			for(int index=0; index < infos.length ; index++)
			{
			node = infos[index];
			//if( node.getTypeName() == "WIFI")
				//{
				if( node.isConnected() == true )
					{
					return true;
					}
			//	}
			}
			return false;
		}
}
