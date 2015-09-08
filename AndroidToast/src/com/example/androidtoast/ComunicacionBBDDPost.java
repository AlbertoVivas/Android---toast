/**
 * 
 */
package com.example.androidtoast;

import android.os.AsyncTask;

/**
 * @author Alberto Vivas
 *
 * 
 */
public class ComunicacionBBDDPost extends AsyncTask<Void, Void, String>{
	private final String URL = "http://172.16.1.57:8090/ServletAndroid/";
	/* (non-Javadoc)
	 * @see android.os.AsyncTask#doInBackground(java.lang.Object[])
	 */
	@Override
	protected String doInBackground(Void... params) {//la tarea que se llevara a cabo cuando se ejecute
		// TODO Auto-generated method stub
		return null;
	}
	
	/* (non-Javadoc)
	 * @see android.os.AsyncTask#onPostExecute(java.lang.Object)
	 */
	@Override
	protected void onPostExecute(String result) {//la tarea que hara cuando termine
		// TODO Auto-generated method stub
		super.onPostExecute(result);
	}

}
