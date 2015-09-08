package com.example.androidtoast;



import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

@SuppressLint("RtlHardcoded")
public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
//		Button boton_toast_normal = (Button) findViewById(R.id.toastnorm);
//		Button boton_toast_gravity = (Button) findViewById(R.id.toastgra); 
//		Button boton_toast_personalizado = (Button) findViewById(R.id.toastper);
//		boton_toast_gravity.setOnClickListener(new OnClick());
//		boton_toast_normal.setOnClickListener(new OnClick());
//		boton_toast_personalizado.setOnClickListener(new OnClick());
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
		}
		
		
		
		return super.onOptionsItemSelected(item);
	}
	public void Toast(View v){
		
		int key = v.getId();
		Toast nota =null;
		switch (key) {
		case R.id.toastnorm:
			nota = Toast.makeText(getApplicationContext(), "Toast Normal", Toast.LENGTH_SHORT); //al heredar de Activity puedo obtener el contexto.
			nota.show();
			break;
		case R.id.toastgra:
			nota = Toast.makeText(getApplicationContext(), "Toast gravity", Toast.LENGTH_SHORT);
			nota.setGravity(Gravity.CENTER_HORIZONTAL|Gravity.END, 0, 0);
			nota.show();
			break;
		case R.id.toastper:
			nota = new Toast(getApplicationContext());
			LayoutInflater inf = getLayoutInflater();
			View lv = inf.inflate(R.layout.milayout, (ViewGroup) findViewById(R.id.lytLayout));
			TextView tv = (TextView) lv.findViewById(R.id.txtMensaje);
			tv.setText("Toast Personalizado");
			nota.setDuration(Toast.LENGTH_SHORT);
			nota.setView(lv);
			nota.show();
			break;
		}
		
		
	}
}
