package pro.shef;


import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class welcome_sql extends Activity{
	public class Wel implements OnClickListener {

		
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent i6=new Intent(welcome_sql.this,f1.class);
			startActivity(i6);

		}

	}

	TextView twel,tdet1;
	


	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.welcome_sql);
		Button bsign=(Button)findViewById(R.id.btsign);
		bsign.setOnClickListener(new Wel());
		twel=(TextView)findViewById(R.id.txtwel);
		tdet1=(TextView)findViewById(R.id.txtdet1);
		//li=(ListView)findViewById(R.id.lstuser);
		Intent i7=getIntent();
		String su=i7.getStringExtra("msg");
		twel.append("Hi " + su );
		//adapter= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
		//setListAdapter(adapter);    
		
		
		f3 sdb=new f3(getApplicationContext(), "Mobile.db", null, 1);
		SQLiteDatabase db= sdb.getReadableDatabase();
		
		String ss1[]={i7.getStringExtra("msg")};
		Cursor c=db.rawQuery("select * from user where u_name=?", ss1);
		
		while (c.moveToNext()) {
			tdet1.setText("");
			tdet1.append(c.getString(0)+"\n"+ c.getString(1)+"\n"+ c.getString(2)+"\n"+ c.getString(3)+"\n"+ c.getString(4)+"\n"+c.getString(5)+"\n"+ c.getString(6)+"\n");
	
			//list.add(c.getString(0));
						
			//adapter.notifyDataSetChanged();
	
			}		
		
	}

	
}
