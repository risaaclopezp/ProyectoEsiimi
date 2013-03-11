package com.losgangnamstyle.proyectoesiimi;

import sample.actionscontentview.ExamplesActivity;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	/*
	 * Variables para actividad
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	
	public SharedPreferences login;
	public Persona persona;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		persona=new Persona();
		checarUsuario();
		setContentView(R.layout.activity_main);
		/*
		 * Evento del boton
		 * 
		 */
		findViewById(R.id.button1).setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v){
				String texID=(String)((EditText)findViewById(R.id.editText2)).getText().toString();
				String texPas=(String)((EditText)findViewById(R.id.editText1)).getText().toString();
				if(texID.equals("")){
					mensageError2();
					return;
				}
				if(texPas.equals("")){
					mensageError3();
					return;
				}
				if(texID.equals(String.valueOf(persona.getId1()))){
					if(texPas.equals(String.valueOf(persona.getPasw1()))){
						guardarCuenta(persona.getId1());
						entrar();
					}else{
						mensageError();
					}
				}else if(texID.equals(String.valueOf(persona.getId2()))){
					if(texPas.equals(String.valueOf(persona.getPasw2()))){
						guardarCuenta(persona.getId2());
						entrar();
					}else{
						mensageError();
					}
				}
			}
		});
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    switch (item.getItemId()) {
	        case R.id.exitS:
	            // app icon in action bar clicked; go home
	        	super.finish();
	            return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}
	
	public void entrar(){
		((EditText)findViewById(R.id.editText1)).setText("");
		((EditText)findViewById(R.id.editText2)).setText("");
		Intent en=new Intent(this,ExamplesActivity.class);
		startActivity(en);
	}
	
	public void mensageError(){
		String t="Usuario ó Contraseña son incorrectos";
		Toast.makeText(getApplicationContext(), t, Toast.LENGTH_SHORT).show();
	}
	
	public void mensageError2(){
		String t="Falta ID";
		Toast.makeText(getApplicationContext(), t, Toast.LENGTH_SHORT).show();
	}
	
	public void mensageError3(){
		String t="Falta contraseña";
		Toast.makeText(getApplicationContext(), t, Toast.LENGTH_SHORT).show();
	}
	
	public void checarUsuario(){
		Context x=this;
		login=x.getSharedPreferences("userk",Context.MODE_PRIVATE);
		if(login.getInt("IDU", 0)!=0){
			entrar();
		}
	}
	
	public void guardarCuenta(int val){
		Context x=this;
		login=x.getSharedPreferences("userk",Context.MODE_PRIVATE);
		SharedPreferences.Editor edi=login.edit();
		edi.putInt("IDU", val);
		edi.commit();
	}

}
