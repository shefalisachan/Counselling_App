package pro.shef;

import android.app.Activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;


import android.widget.ImageButton;


public class f10 extends Activity{
	ImageButton i;

	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.f10);
	    
	     
	        i=(ImageButton)findViewById(R.id.imageButton1);
	        i.setOnClickListener(new View.OnClickListener() {
				
			
	        	@Override
	        	public void onClick(View v)
	        	{
	        		
	        		String Mobile_Number="8755088426";
	        		
	        	    Intent myIntent =new Intent(Intent.ACTION_CALL,Uri.parse("tel:'"+Mobile_Number+"'"));
	        	    startActivity(myIntent);
	        		
	        	}
	        });
}
}
