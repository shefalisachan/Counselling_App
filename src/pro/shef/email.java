package pro.shef;





import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;



import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;

import android.content.Intent;

import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class email extends Activity {


		private EditText emailTo;
		private EditText emailSubject;
		private EditText emailBody;
		private TextView invitation;
		private Button btnSend;
		String url;
		 static int count;
		 static int id=1;
		  String Resume_Url,mail;
		static  String FileName;
		 public static final int DIALOG_DOWNLOAD_PROGRESS = 0;
		 private ProgressDialog mProgressDialog;

		/** Called when the activity is first created. */
		@Override
		public void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			 Intent myIntent = getIntent();
		        url=myIntent.getStringExtra("url");
		        mail=myIntent.getStringExtra("mail");
				
	       		id = myIntent.getIntExtra("id", -1);
	       		Resume_Url = myIntent.getStringExtra("Resume_URL");
			setContentView(R.layout.email);
			if(id==0){
			startDownload();
			}

			// Get handle to the text edit and button widgets
			emailTo = (EditText) findViewById(R.id.editTxtTo);
			emailSubject = (EditText) findViewById(R.id.editTxtSubject);
			emailSubject.setText("Need counseling for someone");
			
			emailBody = (EditText) findViewById(R.id.editTxtBody);
			btnSend = (Button) findViewById(R.id.btnEmailSend);
			emailBody.setText("Details needed\n\n" +"Name of the person you are concerned about\n Email ID of the person you are concerned about (if known)\n Roll Number of the above person (if known)\nPhone Number (if known)\n Address of the above person (if known)\nA short description of the reason of concern and nature of problem\n\n"+"Thank You\nYour Name\n Your roll no.");
			emailTo.setText("shefalisachan6@gmail.com");
			
			// Attach a click listener to detect button click
			btnSend.setOnClickListener(new OnClickListener() {
				
				public void onClick(View v) {
					if (v.getId() == R.id.btnEmailSend) {
						sendEmail();
						setResult(RESULT_OK);
						finish();
					}
					
				}
			});
	
	
		}

		/**
		 * Method to send email
		 */
		protected void sendEmail() {
			// Setup the recipient in a String array
			String[] mailto = { "shefalisachan6@gmail.com" };
			//String[] ccto = { emailTo.getText().toString() };
			// Create a new Intent to send messages
			Intent sendIntent = new Intent(Intent.ACTION_SEND);
			// Add attributes to the intent
			sendIntent.putExtra(Intent.EXTRA_EMAIL, mailto);
			//sendIntent.putExtra(Intent.EXTRA_CC, ccto);
			sendIntent.putExtra(Intent.EXTRA_SUBJECT, emailSubject.getText()
					.toString());
			sendIntent.putExtra(Intent.EXTRA_TEXT, emailBody.getText().toString());
			// sendIntent.setType("message/rfc822");
			//sendIntent.putExtra(Intent.EXTRA_STREAM, Uri.parse("/sdcard/ab.pdf"));
			if(id==0)
			sendIntent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(new File("/sdcard/"+FileName))); 
			//sendIntent.setType("vnd.android.cursor.dir/email"); 
			sendIntent.setType("text/plain");
			startActivity(Intent.createChooser(sendIntent, "MySendMail"));
		}
		
		
		
		 private void startDownload() {
		        String url = Resume_Url;
		        new DownloadFileAsync().execute(url);
		    }
		    @Override
		    protected Dialog onCreateDialog(int id) {
		        switch (id) {
		            case DIALOG_DOWNLOAD_PROGRESS:
		                mProgressDialog = new ProgressDialog(this);
		                mProgressDialog.setMessage("Downloading Resume...");
		                mProgressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
		                mProgressDialog.setCancelable(false);
		                mProgressDialog.show();
		                return mProgressDialog;
		            default:
		                return null;
		        }
		    }
		    class DownloadFileAsync extends AsyncTask<String, String, String> {
		        
		        @Override
		        protected void onPreExecute() {
		            super.onPreExecute();
		            showDialog(DIALOG_DOWNLOAD_PROGRESS);
		        }

		        @Override
		        protected String doInBackground(String... aurl) {
		           

		            try {
		                URL url = new URL(aurl[0]);
		                URLConnection conexion = url.openConnection();
		                conexion.connect();

		                int lenghtOfFile = conexion.getContentLength();
		                Log.d("ANDRO_ASYNC", "Lenght of file: " + lenghtOfFile);

		                InputStream input = new BufferedInputStream(url.openStream());
		                int index=Resume_Url.lastIndexOf('/');
		                 FileName=Resume_Url.substring(index);
		                OutputStream output = new FileOutputStream("/sdcard/"+FileName);

		                byte data[] = new byte[1024];

		                long total = 0;

		                while ((count = input.read(data)) != -1) {
		                    total += count;
		                    publishProgress(""+(int)((total*100)/lenghtOfFile));
		                    output.write(data, 0, count);
		                }

		                output.flush();
		                output.close();
		                input.close();
		                
		            
		                
		            } catch (Exception e) {
		            	Log.e("BACKGROUND_PROC******", e.getMessage());
		            	
		            	e.printStackTrace();
		            }
		            return null;

		        }
		        protected void onProgressUpdate(String... progress) {
		             Log.d("ANDRO_ASYNC",progress[0]);
		             mProgressDialog.setProgress(Integer.parseInt(progress[0]));
		        }

		        @Override
		        protected void onPostExecute(String unused) {
		            dismissDialog(DIALOG_DOWNLOAD_PROGRESS);
		        }
		        
		    }
}