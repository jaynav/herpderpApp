package com.example.sample;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.ListActivity;

import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

//demos simple list view from array list... the array adapter interfaces between list view and the array list of data
//the adapter is an instance  vari in the acti
public class MyListActivity extends ListActivity
	{

		private ArrayAdapter<String>madapt;
		@Override
		protected void onCreate(Bundle savedInstanceState)
			{
				super.onCreate(savedInstanceState);
				setContentView(R.layout.activity_list);
				
				List<String> data = new ArrayList<String>();
				data.add("abc");
				data.add("def");
				data.add("ghi");
				data.add("jkl");
				data.add("mno");
				
				madapt = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, data);
				
				setListAdapter(madapt);
				
				Button btn1 = (Button) findViewById(R.id.button1);
				btn1.setOnClickListener(new OnClickListener(){
					public void onClick(View Der)
						{
						addRow();	
						}
				});
			}
		
		//notification of click on a list item
		
		protected void onListItemClick(ListView lv, View derView,int post, long id)
			{
				super.onListItemClick(lv, derView, post, id);
				String str= (String) getListAdapter().getItem(post);
				Toast.makeText(this, "oh look "+str, Toast.LENGTH_SHORT).show();
			}

		@Override
		public boolean onCreateOptionsMenu(Menu menu)
			{
				// Inflate the menu; this adds items to the action bar if it is
				// present.
				getMenuInflater().inflate(R.menu.list, menu);
				return true;
			}
		
		//add data to list, via adapter/ show in ui
		
		public void addRow()
			{
				String no = String.valueOf(System.currentTimeMillis());
				madapt.add(no);
			}

	}
