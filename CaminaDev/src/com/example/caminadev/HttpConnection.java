package com.example.caminadev;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.util.Log;

class HttpConnection implements Runnable
{
	private String url;
	public HttpConnection(String url) {
		this.url = url;
	}
	public void run() {
		HttpGet httpRequest = new HttpGet(url);
		try {
			HttpResponse httpResponse = new DefaultHttpClient().execute(httpRequest);
			
			if (httpResponse.getStatusLine().getStatusCode() == 200) { /* 200 ok */
				// return EntityUtils.toString(httpResponse.getEntity());
			}http://caminamaps.com/caminadev/insert_path_d.php?date=02:07:05&directionX=245.74579&directionY=0.26139066&directionZ=-3.063672&accelerationX=-0.5481188&accelerationY=0.26869074&accelerationZ=-0.3587904&gyroX=245.74579&gyroY=0.26139066&gyroZ=-3.063672&steps=0http://caminamaps.com/caminadev/insert_path_d.php?date=02:07:05&directionX=245.74579&directionY=0.26139066&directionZ=-3.063672&accelerationX=-0.5481188&accelerationY=0.26869074&accelerationZ=-0.3587904&gyroX=245.74579&gyroY=0.26139066&gyroZ=-3.063672&steps=0http://caminamaps.com/caminadev/insert_path_d.php?date=02:07:05&directionX=245.74579&directionY=0.26139066&directionZ=-3.063672&accelerationX=-0.5481188&accelerationY=0.26869074&accelerationZ=-0.3587904&gyroX=245.74579&gyroY=0.26139066&gyroZ=-3.063672&steps=0subject_editText.setText("Oscar");subject_editText.setText("Oscar");	} catch (ClientProtocolException e)	{	
			Log.d("b", "client exception.");
		} catch (IOException e) {				
			Log.d("b", "IO exception.");
		}
		return;
	}
}
