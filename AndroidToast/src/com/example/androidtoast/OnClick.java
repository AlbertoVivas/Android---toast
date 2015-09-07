/**
 * 
 */
package com.example.androidtoast;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.widget.Toast;

/**
 * @author Alberto Vivas
 *
 * 
 */
public class OnClick extends Activity implements android.view.View.OnClickListener{

	/* (non-Javadoc)
	 * @see android.view.View.OnClickListener#onClick(android.view.View)
	 */
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		//v.getId()
		
		
		//R.id.toastnorm
		
		int key = v.getId();
		
		switch (key) {
		case R.id.toastnorm:
			Toast nota = Toast.makeText(getApplicationContext(), "Toast Normal", Toast.LENGTH_SHORT); //al heredar de Activity puedo obtener el contexto.
			nota.show();
			break;
		case R.id.toastgra:
			break;
		case R.id.toastper:
			break;
		}
	}

	
	

}
