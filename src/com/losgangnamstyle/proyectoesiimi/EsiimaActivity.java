package com.losgangnamstyle.proyectoesiimi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;

public class EsiimaActivity extends SherlockFragmentActivity {
	
	private static String TAG = "EsiimaActivity";
	private SherePreferenceData datos;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		startActivity(new Intent(this,SplashScreen.class));
        setContentView(R.layout.main);
        
        ActionBar bar= getSupportActionBar();
        bar.setCustomView(R.layout.image_logo);
        bar.setDisplayShowCustomEnabled(true);
        bar.setDisplayShowTitleEnabled(false);
        
        datos=new SherePreferenceData(this);
        datos.iniShared();
		if(!datos.isUserInit(0)){
			replaceFragment(new StartFragment());
		}else{
			replaceFragment(new HomeFragment());
		}
	}

    public void replaceFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.layout_fragment, fragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
    }

}
