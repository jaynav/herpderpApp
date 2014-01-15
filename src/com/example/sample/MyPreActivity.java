package com.example.sample;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;

public class MyPreActivity extends PreferenceActivity
	{

		@Override
		public void onCreate(Bundle savedInstanceState)
			{
			 super.onCreate(savedInstanceState);	
			 //must initiate a fragment.....retarded google same code as old but in fragment to add support of headers
			 getFragmentManager().beginTransaction().replace(android.R.id.content, new MyPreferenceFragment());
			}
		
		public void onPause()
			{
				super.onPause();
				
				SharedPreferences prefy = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
				boolean crsh = prefy.getBoolean("crash", true);
				String runny = prefy.getString("runpref","");
				
				System.err.println("der frist" + crsh);
				System.err.println("runny der" + runny);
			}
	}
