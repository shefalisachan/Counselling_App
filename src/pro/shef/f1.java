package pro.shef;



import android.app.Activity;
    import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
    import android.os.Bundle;
    import android.view.View;
    import android.view.View.OnClickListener;
    import android.widget.Button;
    import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

    public class f1 extends Activity {


    	    /** Called when the activity is first created. */
    	    EditText etUsername;
    	    EditText etPassword;
    	    Button btnLogin;
    	    Button btnSignup;
    	    Button btnCancle;
    	    TextView lblResult;
    	      
    	    public void onCreate(Bundle savedInstanceState) {
    	        super.onCreate(savedInstanceState);
    	        setContentView(R.layout.main);
    	        etUsername=(EditText)findViewById(R.id.username);
    	        etPassword=(EditText)findViewById(R.id.password);
    	        btnLogin=(Button)findViewById(R.id.loginbutton);
    	        btnSignup=(Button)findViewById(R.id.signupbutton);
    	        btnCancle=(Button)findViewById(R.id.canclebutton);
    	        lblResult=(TextView)findViewById(R.id.result);
    	        
    	        btnCancle.setOnClickListener(new OnClickListener() {
    	        	@Override
    	        	public void onClick(View v)
    	        	{
    	        		finish();
    	        	}
    	        });
    	    
    	        btnLogin.setOnClickListener(new OnClickListener() {
    	        	@Override
    	        	public void onClick(View v)
    	        	{
    	        		f3 sdb=new f3(getApplicationContext(), "Mobile.db", null, 1);
    					SQLiteDatabase db= sdb.getReadableDatabase();
    					Cursor c1=db.rawQuery("select u_name,pwd from user where u_name='"+etUsername.getText().toString()+"' and pwd='"+etPassword.getText().toString()+"'", null);
    					if(etUsername.getText().toString().equals("")||etPassword.getText().toString().equals(""))
    		            {
    		                    Toast.makeText(getApplicationContext(), "Please enter Name Password both", Toast.LENGTH_LONG).show();
    		                    return;
    		            }
    					else if(c1.moveToFirst())
    					{
    						    Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_SHORT).show();
    				                Intent i5=new Intent(f1.this,f2.class);
    								//i5.putExtra("msg1", eu.getText().toString());
    								startActivity(i5);   
    					}
    					else {
    				                Toast.makeText(getApplicationContext(), "Invalid Login details", Toast.LENGTH_SHORT).show();
    				            	etUsername.setText("");
    									etPassword.setText("");
    				            }	
    								
    						    
    						}
    	        });
    	        
    	        btnSignup.setOnClickListener(new OnClickListener() {
    	        	@Override
    	        	public void onClick(View v)
    	        	{
    	        		Intent Open= new Intent(f1.this, regstr_sql.class);
    	        		startActivity(Open);
    	        	}
    	        });
    			
    	    }
    	
}


