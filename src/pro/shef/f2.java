package pro.shef;



import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class f2 extends Activity{
	
	 Button btnServices;
	    Button btnAppoint;
	    Button btnWorried;
	    @Override
	    public void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.f3);
			btnServices=(Button)findViewById(R.id.button1);
			btnAppoint=(Button)findViewById(R.id.button2);
			btnWorried=(Button)findViewById(R.id.button3);
			btnServices.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					
					 btnServices.setOnClickListener(new OnClickListener() {
						
						@Override
						 public void onClick(View v) {
							// TODO Auto-generated method stub
							Intent i2=new Intent(f2.this,f4.class);
							startActivity(i2);
						}
					});
					
					
					 btnAppoint.setOnClickListener(new OnClickListener() {
							
							@Override
							 public void onClick(View v) {
							// TODO Auto-generated method stub
							Intent i2=new Intent(f2.this,f10.class);
							startActivity(i2);
						}
					});
                   
					
     btnWorried.setOnClickListener(new OnClickListener() {
						
						@Override
						 public void onClick(View v) {
							// TODO Auto-generated method stub
							Intent i2=new Intent(f2.this,f11.class);
							startActivity(i2);
						}
					});

				}
			});
			
}
}