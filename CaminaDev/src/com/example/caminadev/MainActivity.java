package com.example.caminadev;

import java.util.Date;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements SensorEventListener{

	/* Sensor Variables*/
	SensorManager sensorManager;
	Sensor sensorAccelerometer;
	Sensor sensorOrientation;
	
	/* Buttons */
	Button start_button;
	Button sync_button;
	Button readings_button;
	
	/* EditText's */
	EditText subject_editText;
	EditText device_editText;
	EditText description_editText;
	EditText date_editText;

	/* Database handlers */
	Path_h_dataSource dataSource_h;
	Path_d_dataSource dataSource_d;
	static Path_h path_h;
	static Path_d path_d;
	static long lPath_h;
	static String currentFileName="current_file";

	/* Arrays to collect sensor data */
	float[] acceleration;
	float[] direction;
	float[] gyro;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		/* Find id */
		subject_editText     = (EditText)findViewById(R.id.subject);
		device_editText      = (EditText)findViewById(R.id.device);
		description_editText = (EditText)findViewById(R.id.description);
		date_editText        = (EditText)findViewById(R.id.date);
		
		start_button     = (Button)findViewById(R.id.start_button);
		sync_button      = (Button)findViewById(R.id.sync_button);
		readings_button  = (Button)findViewById(R.id.readings_button);
		
		subject_editText.setText("Oscar");
		device_editText.setText("SamsungS3Mini");
		
		/* Get system date */
		Date dCurrentTime = new Date();
		CharSequence sCurrentTime = DateFormat.format("yyyy-MM-dd%20hh:mm:ss", dCurrentTime.getTime());
		date_editText.setText(sCurrentTime);

		/* Initialize arrays */
		acceleration = new float[3];
		direction    = new float[3];
		gyro         = new float[3];
		
		/* Sensor Manager */
		sensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
	    sensorAccelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION);
	    sensorOrientation   = sensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION);
		
		start_button.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {

				/* Execute only on "Start" */
				if (start_button.getText().equals("Start")) {
					start_button.setText("Stop");
				
					/* Get system date */
					Date dCurrentTime = new Date();
					CharSequence sCurrentTime = DateFormat.format("yyyy-MM-dd%20hh:mm:ss", dCurrentTime.getTime());
					date_editText.setText(sCurrentTime);
					
					/* Insert data to local database */
					/*
					dataSource_h=new Path_h_dataSource(getApplicationContext());
					dataSource_h.open();
					path_h=null;
					path_h=dataSource_h.createPath_h(subject_editText.getText().toString(), device_editText.getText().toString(), 
							description_editText.getText().toString(), date_editText.getText().toString(), currentFileName);
					dataSource_h.close();
					*/
					
					/* Send data to external server */
					String url = "http://caminamaps.com/caminadev/insert_path_h.php?"
							+"subject="+subject_editText.getText().toString()
							+"&device="+device_editText.getText().toString()
							+"&description="+description_editText.getText().toString()
							+"&date="+date_editText.getText().toString();
					
					HttpConnection con = new HttpConnection(url);
						(new Thread(con)).start();
				}
				else 
					start_button.setText("Start");
			}
		});
	}

	@Override
	public void onResume() {

		sensorManager.registerListener(this, sensorAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
	    sensorManager.registerListener(this, sensorOrientation, SensorManager.SENSOR_DELAY_NORMAL);
	    
	    super.onResume();
	}

	@Override
	 protected void onPause() {
		
		sensorManager.unregisterListener(this, sensorAccelerometer);
	    sensorManager.unregisterListener(this, sensorOrientation);
   
	    super.onPause();
	 }
	
	@Override
	public void onAccuracyChanged(Sensor arg0, int arg1) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onSensorChanged(SensorEvent event) {

		/* read data only when the button start has been pressed */
		if (start_button.getText().equals("Stop")) {

			switch(event.sensor.getType()){

				/* Accelerometer Sensor */
				case Sensor.TYPE_LINEAR_ACCELERATION:
				{
					/* Read data from sensor */
					for(int i =0; i < 3; i++){
						acceleration[i] = event.values[i];
					}
					
					/* Insert data to local database */
					/*
					dataSource_d=new Path_d_dataSource(this);
					dataSource_d.open();
					path_d=null;
					path_d=dataSource_d.createPath_d(path_h.getId(), direction[0], direction[1], direction[2],
							acceleration[0], acceleration[1], acceleration[2], gyro[0], gyro[1], gyro[2]);
					dataSource_d.close();
					*/
					
					/* Get system date */
					Date dCurrentTime = new Date();
					CharSequence sCurrentTime = DateFormat.format("hh:mm:ss", dCurrentTime.getTime());
					
					/* Send data to external server */
					String url = "http://caminamaps.com/caminadev/insert_path_d.php?"
							+"date="+sCurrentTime
							+"&directionX="+direction[0]
							+"&directionY="+direction[1]
							+"&directionZ="+direction[2]
							+"&accelerationX="+acceleration[0]
							+"&accelerationY="+acceleration[1]
							+"&accelerationZ="+acceleration[2]
							+"&gyroX="+gyro[0]
							+"&gyroY="+gyro[1]
							+"&gyroZ="+gyro[2]
							+"&steps=0";
					
					HttpConnection con = new HttpConnection(url);
						(new Thread(con)).start();
					
				}
				/* Orientation Sensor */
				case Sensor.TYPE_ORIENTATION:
				{	
					/* Read data from sensor */
					for(int i =0; i < 3; i++){
						direction[i] = event.values[i];
					}
				}	
				/* Gyro Sensor */
				case Sensor.TYPE_GYROSCOPE:
				{	
					/* Read data from sensor */
					for(int i =0; i < 3; i++){
						gyro[i] = event.values[i];
					}
				}
			}
		}
	}
}
