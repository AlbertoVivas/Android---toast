/**
 * 
 */
package com.example.androidtoast;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

/**
 * @author Alberto Vivas
 *
 * 
 */
public class ActivityReadBbdd extends Activity {
	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main3);
		
		TextView txtcontactos = (TextView) findViewById(R.id.textView2);
		Bbdd usdbh = new Bbdd(this, "bbdd_android", null, 1);
	 
	    SQLiteDatabase db = usdbh.getReadableDatabase();
		
		Cursor c = db.rawQuery(" SELECT * FROM Usuarios ", null);
		
		Log.d("Ndatos", c.getCount()+"");
		StringBuffer datos = new StringBuffer();
		
		if (c.moveToFirst()) {
		     //Recorremos el cursor hasta que no haya más registros
			datos.append("codigo y nombre \n");
		     do {
		          String codigo= c.getString(0);
		          String nombre = c.getString(1);
		          //datos.append("codigo y nombre ");
					datos.append(codigo + "         " + nombre);
					datos.append("\n");
		     } while(c.moveToNext());
		}
		
		c.close();
		txtcontactos.setText(datos);
		
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		
		
		switch (id) {
		case R.id.action_getBbdd:
			Intent i1 = new Intent(this,ActivityReadBbdd.class);
			startActivity(i1);
			break;
		case R.id.action_setBbdd:
			Intent i2 = new Intent(this,ActivityBbdd.class);
			startActivity(i2);
			break;
		case R.id.action_home:
			Intent i3 = new Intent(this,MainActivity.class);
			startActivity(i3);
			break;	
		}
		
		
		
		return super.onOptionsItemSelected(item);
	}
}
