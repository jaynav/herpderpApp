package com.example.sample;


import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Context;
import android.content.Intent;//retarded name

public class MainActivity extends Activity {
 private SeekBar derSeekBar;
 private EditText derText;
 private int iCount =0;
    @Override
   
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        /////////////////////// creating listener for seekbar
        derSeekBar = (SeekBar)findViewById(R.id.seekBar1);
        derText = (EditText)findViewById(R.id.seeksBarText);
        final TextView helper1 = (TextView) findViewById(R.id.helpText);
        derSeekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
        	//requires all three
        	public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
        		{
        			//retard code does not take a int and automatically convert it to a string or have a progress.toString() method.
        			//note to self this is not C# or jvm. its dalvik java
                     helper1.setText(Integer.toString(progress));
        			//helper1.setText(String.valueOf(progress));
                    
        		}

			@Override
			public void onStartTrackingTouch(SeekBar arg0)
				{
					// TODO Auto-generated method stub
					
				}

			@Override
			public void onStopTrackingTouch(SeekBar arg0)
				{
					// TODO Auto-generated method stub
					
				}

});
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    @Override
    public void onResume()
    	{
    		Log.v("its in mainActivity","onResume");
    		super.onResume();
    	}
    @Override
    public void onPause()
    	{
    		Log.v("its in mainActivity","onPause");
    		super.onPause();
    	}
    @Override
    public void onSaveInstanceState(Bundle outState)
    	{
    		Log.v("its in mainActivity","onSaveInstance");	
    		super.onSaveInstanceState(outState);
    		
    	
    	}
    @Override
    public void onDestroy()
    	{
    		Log.v("its in mainActivity","onDestroy"); 
    		super.onDestroy();
    	}
    
    
    
    
    ////////////////////////////////////////////////end of android states///////////////////////////////////////////////////
    public void openURL(View der)
    {
    	EditText derurl = (EditText) findViewById(R.id.derText);
    	String url = derurl.getText().toString();
    	if(!url.startsWith("http://")&& !url.startsWith("https://"))
    	{
    		url= "http://"+url;
    	}
    Intent phonesIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
    startActivity(phonesIntent);
    }
    
    public void complain(View der)
    {
    	final TextView helper = (TextView) findViewById(R.id.helpText);
    	Animation animate = AnimationUtils.loadAnimation(this, R.anim.swirl);
       animate.setAnimationListener(
    		   new AnimationListener(){
    			   public void onAnimationStart(Animation anim)
    			   {
    				   
    			   }

    			   @Override
    			   public void onAnimationEnd(Animation arg0) {
					
    				   helper.setText("");
    				   Context cont = getApplicationContext();
    				   CharSequence daText = "herp Derp";
    				   int time = Toast.LENGTH_SHORT;
    				   Toast quickmessagebox = Toast.makeText(cont, daText, time);
    				   quickmessagebox.show();
    			   		}

    			   @Override
    			   public void onAnimationRepeat(Animation animation) {
					
    			   }
    		   });
       		helper.startAnimation(animate);
    }
    public void openList(View der)
    	{
    		Intent startI = new Intent(this,MyListActivity.class);
    		startActivity(startI);
    	}
    public void openPref(View der)
    	{
    		Intent startI = new Intent(this, MyPreActivity.class);
    		startActivity(startI);
    	}
}
