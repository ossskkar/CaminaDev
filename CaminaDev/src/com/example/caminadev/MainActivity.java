package com.example.caminadev;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	Button start_button;
	Button sync_button;
	Button readings_button;
	
	EditText subject_editText;
	EditText device_editText;
	EditText description_editText;
	EditText date_editText;

	Path_h_dataSource dataSource_h;
	Path_d_dataSource dataSource_d;
	static List<Path_h> paths_h;
	static List<Path_d> paths_d;
	static long lPath_h;
	static String currentFileName="current_file";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		subject_editText     = (EditText)findViewById(R.id.subject);
		device_editText      = (EditText)findViewById(R.id.device);
		description_editText = (EditText)findViewById(R.id.description);
		date_editText        = (EditText)findViewById(R.id.date);
		
		start_button     = (Button)findViewById(R.id.start_button);
		sync_button      = (Button)findViewById(R.id.sync_button);
		readings_button  = (Button)findViewById(R.id.readings_button);
		
		Date dCurrentTime = new Date();
		CharSequence sCurrentTime = DateFormat.format("yyyy-MM-dd hh:mm:ss", dCurrentTime.getTime());
		date_editText.setText(sCurrentTime);

		/* Database objects */
		dataSource_h=new Path_h_dataSource(this);
		dataSource_h.open();
		
		dataSource_d=new Path_d_dataSource(this);
		dataSource_d.open();
		
		paths_d=null;
		paths_d=new ArrayList<Path_d>();
		
		start_button.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {

				if (start_button.getText().equals("Start")) {
					start_button.setText("Stop");
				
					/* insert path_h to database */
					Path_h path_h=null;
					path_h=dataSource_h.createPath_h(subject_editText.getText().toString(), device_editText.getText().toString(), 
							description_editText.getText().toString(), date_editText.getText().toString(), currentFileName);
					dataSource_h.close();
				}
				else 
					start_button.setText("Start");
				
				
				
				/* Start activity */
				//startActivity(new Intent(getApplicationContext(), activity_main.class));
				
			}
		});
	}
}
