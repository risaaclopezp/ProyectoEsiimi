package com.losgangnamstyle.proyectoesiimi;

import android.os.Bundle;
import android.app.Activity;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	
	/*
	 * Variables para actividad
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	
	SharedPreferences login;
	Persona persona;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		persona=new Persona();
		/*
		 * Evento del boton
		 * 
		 */
		findViewById(R.id.button1).setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v){
				
			}
		});
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
