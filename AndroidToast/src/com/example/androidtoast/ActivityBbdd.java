/**
 * 
 */
package com.example.androidtoast;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * @author Alberto Vivas
 *
 * 
 */
public class ActivityBbdd extends Activity{
	
/* (non-Javadoc)
 * @see android.app.Activity#onCreate(android.os.Bundle)
 */
@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_main2);
	Bbdd bbdd = new Bbdd(this, "bbdd_android", null, 1);
	
	SQLiteDatabase sqld =bbdd.getWritableDatabase(); //debemos comprobar que sea !null 
	String nombre = "user_";
	if (null != sqld){
		for (int i = 1; i < 3; i++) {
			String set_nombre = nombre+i;
			
			sqld.execSQL("INSERT INTO Usuarios (codigo,nombre) VALUES"+"("+i+",'"+set_nombre+"');");
		}
		sqld.close();
	}
	/*
	TextView txtcontactos = (TextView) findViewById(R.id.textView2);
	Bbdd usdbh = new Bbdd(this, "bbdd_android", null, 1);
 
    SQLiteDatabase db = usdbh.getWritableDatabase();
	
	Cursor c = db.rawQuery(" SELECT * FROM Usuarios ", null);
	
	Log.d("Ndatos", c.getCount()+"");
	StringBuffer datos = new StringBuffer();
	
	if (c.moveToFirst()) {
	     //Recorremos el cursor hasta que no haya más registros
	     do {
	          String codigo= c.getString(0);
	          String nombre = c.getString(1);
	          datos.append("codigo y nombre ");
				datos.append(codigo + " " + nombre);
				datos.append("\n");
	     } while(c.moveToNext());
	}
	
	c.close();
	txtcontactos.setText(datos);
	*/
	
}

public void setBbdd(View v){
	
	EditText et_codigo = (EditText) findViewById(R.id.editTextCodigo);
	EditText et_nombre = (EditText) findViewById(R.id.editTextNombre);
	
	String codigo = et_codigo.getText().toString();
	String nombre = et_nombre.getText().toString();
	
	Bbdd bbdd = new Bbdd(this, "bbdd_android", null, 1);
	
	SQLiteDatabase sqld =bbdd.getWritableDatabase();
	
		if (nombre != "" && codigo != "") {

			if (null != sqld) {

				sqld.execSQL("INSERT INTO Usuarios (codigo,nombre) VALUES" + "(" + codigo + ",'" + nombre + "');");
				sqld.close();
			}
		}else{
			Toast nota = Toast.makeText(getApplicationContext(), "Introduce un nombre y codigo correctos", Toast.LENGTH_SHORT); //al heredar de Activity puedo obtener el contexto.
			nota.show();
		}
}
}
