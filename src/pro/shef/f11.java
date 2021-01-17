package pro.shef;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class f11 extends Activity {
	ImageButton i1;
	ImageButton i2;

	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.f11);
	        i1=(ImageButton)findViewById(R.id.imageButton1);
	        i2=(ImageButton)findViewById(R.id.imageButton2);
	        i1.setOnClickListener(new View.OnClickListener() {
				
			
	        	@Override
	        	public void onClick(View v)
	        	{
	        		Intent i2=new Intent(f11.this,email.class);
					startActivity(i2);
	
	
}
	        });
	        
	        i2.setOnClickListener(new View.OnClickListener() {
				
				
	        	@Override
	        	public void onClick(View v)
	        	{
	        		
	        		Intent i2=new Intent(f11.this,sms.class);
					startActivity(i2);
	
}
	        });
	 }
	 }
