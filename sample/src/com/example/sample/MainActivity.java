package com.example.sample;


import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;//retarded name for message box
import android.content.Context;
import android.content.Intent;//retarded name

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    
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
    
}
