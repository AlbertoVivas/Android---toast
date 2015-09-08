/**
 * 
 */
package com.example.androidtoast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;

import android.os.AsyncTask;
import android.util.Log;

/**
 * @author Alberto Vivas
 *
 * 
 */
public class ComunicacionBBDDGet extends AsyncTask<Void, Void, String>{
	private final String URL = "http://172.16.1.57:8090/ServletAndroid/MiServlet";
	
	/* (non-Javadoc)
	 * @see android.os.AsyncTask#doInBackground(java.lang.Object[])
	 */
	@Override
	protected String doInBackground(Void... params) {
		// TODO Auto-generated method stub
		String respuesta ="";
		try {
			java.net.URL url = new java.net.URL(URL);
			HttpURLConnection conexionHttp = (HttpURLConnection) url.openConnection();
			int rc = conexionHttp.getResponseCode();
			String rm = conexionHttp.getResponseMessage();
			
			if(200 == rc){
				
				if("OK"== rm){
					BufferedReader in = new BufferedReader(new InputStreamReader(conexionHttp.getInputStream()));
					respuesta = in.readLine();
					in.close();
					conexionHttp.disconnect();
				}
			}else{
				System.out.println("El response code es: "+rc+" y mi response message: "+rm);
			}
			
			
			
			
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Log.e("Mi clase comunicacion bbdd asynctask", e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Log.e("Mi clase comunicacion bbdd asynctask", e.getMessage());
		}
		
		
		return respuesta;
	}
	
	/* (non-Javadoc)
	 * @see android.os.AsyncTask#onPostExecute(java.lang.Object)
	 */
	@Override
	protected void onPostExecute(String result) {
		// TODO Auto-generated method stub
		// super.onPostExecute(result);
		Log.d("Clase get", result);
	}

}
