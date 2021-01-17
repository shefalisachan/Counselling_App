package pro.shef;


import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class regstr_sql extends Activity{
	public class Rd implements OnCheckedChangeListener {

		
		public void onCheckedChanged(RadioGroup arg0, int arg1) {
			// TODO Auto-generated method stub
			rtemp=(RadioButton)findViewById(arg1);
		}

	}
	public class Regis implements OnClickListener {

		public void onClick(View v) {
			// TODO Auto-generated method stub
			f3 sdb=new f3(getApplicationContext(), "Mobile.db", null, 1);
			SQLiteDatabase db= sdb.getWritableDatabase();
			String[] a=new String[7];
			a[0]=e1.getText().toString();
			//a[1]=e2.getText().toString();
			a[1]=e3.getText().toString();
			a[2]=e4.getText().toString();
			a[3]=e5.getText().toString();
			a[4]=e6.getText().toString();
			a[5]=e7.getText().toString();
			a[6]=rtemp.getText().toString();
			//a[8]=s;

			db.execSQL("insert into user values(?,?,?,?,?,?,?)",a);

			Intent i3=new Intent(regstr_sql.this,welcome_sql.class);
			i3.putExtra("msg", e4.getText().toString());
			startActivity(i3);

		}

	}
	EditText e1,e3,e4,e5,e6,e7;
	RadioGroup rg1;
	
	
	RadioButton rtemp;
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.reges);
		Button b1=(Button)findViewById(R.id.btreg);
		b1.setOnClickListener(new Regis());
		
		e1=(EditText)findViewById(R.id.edname);
		
		e3=(EditText)findViewById(R.id.edemail);
		e4=(EditText)findViewById(R.id.eduser);
		e5=(EditText)findViewById(R.id.edpwd);
		e6=(EditText)findViewById(R.id.edph);
		e7=(EditText)findViewById(R.id.edadd);
		
		rg1=(RadioGroup)findViewById(R.id.rdgen);
		rg1.setOnCheckedChangeListener(new Rd());
		
	}	
		
		
		
}