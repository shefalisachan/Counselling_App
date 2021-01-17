package pro.shef;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;

public class Splash extends Activity {
	private boolean b;
	private static  final int SPLASH_DURATION=3000;
	private Handler myhandler; 

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		getWindow().requestFeature(Window.FEATURE_NO_TITLE);
		
		setContentView(R.layout.splash);
	myhandler=new Handler();
	myhandler.postDelayed(new Runnable() {
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			finish();
			if(!b)
			{
				Intent intent=new Intent(Splash.this,f1.class);
				Splash.this.startActivity(intent);
			}
		}
	}, SPLASH_DURATION);
	
	}
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		b=true;
		super.onBackPressed();
	}

	}


