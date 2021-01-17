package pro.shef;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class f4  extends Activity{
	
	Button addit;
	Button mental;
	Button sessions;
	Button academic;
	Button matter;
	
	
	   @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.f4);
	        addit=(Button)findViewById(R.id.button1);
	        mental=(Button)findViewById(R.id.button2);
	        sessions=(Button)findViewById(R.id.button3);
	        academic=(Button)findViewById(R.id.button4);
	        matter=(Button)findViewById(R.id.button5);
	        addit.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					Intent i2=new Intent(f4.this,f5.class);
					startActivity(i2);
				}
					});
	        mental.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					Intent i2=new Intent(f4.this,f6.class);
					startActivity(i2);
				}
					});
	   
	        sessions.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					Intent i2=new Intent(f4.this,f7.class);
					startActivity(i2);
				}
					});
	        academic.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					Intent i2=new Intent(f4.this,f8.class);
					startActivity(i2);
				}
					});
	        matter.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					Intent i2=new Intent(f4.this,f9.class);
					startActivity(i2);
				}
					});
	   }
}
