package com.losgangnamstyle.proyectoesiimi;

import android.os.Bundle;

import com.actionbarsherlock.app.SherlockActivity;
 
public class SplashScreen extends SherlockActivity {
	 
	 /** Se le llama cuando la actividad es creada por primera vez*/
	    @Override
	    public void onCreate(Bundle savedInstanceState) {
	 
	        super.onCreate(savedInstanceState);
	         
	        setContentView(R.layout.splash_activity);
	        new Espera();
	    }     
	    
	    class Espera implements Runnable {
	    	public Espera() {
	    		Thread pantalla = new Thread( this, "Esiima" );
	    	    pantalla.start();
	    	}
	    	
	    	public void run() {
	    		try {
	    			Thread.sleep(3000);
	    	    } catch( InterruptedException e ) { 
	    	    	
	    	    }finally{
	    	    	finish();
	    	    }
	    	}
	    }    	
	}
