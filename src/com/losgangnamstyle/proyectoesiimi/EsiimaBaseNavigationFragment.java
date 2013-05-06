package com.losgangnamstyle.proyectoesiimi;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.util.Pair;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.ActionBar.OnNavigationListener;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.losgangnamstyle.proyectoesiimi.adapter.EsiimaNavigationAdapter;

public abstract class EsiimaBaseNavigationFragment extends EsiimaBaseFragment implements
		OnNavigationListener {
	
	protected static final int NAV_HOME=0;
	protected static final int NAV_FALTAS=1;
	protected static final int NAV_CALIFICACIONES=2;
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setHasOptionsMenu(true);
	}
	
	@Override
	public void onCreateOptionsMenu(Menu menu,MenuInflater inflater){
		inflater.inflate(R.menu.main, menu);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public void onResume(){
		super.onResume();
		ActionBar bar = getSherlockActivity().getSupportActionBar();
		bar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
		ArrayAdapter<?> adapter=new EsiimaNavigationAdapter(getActivity(),
				new Pair<String, Integer>("Situación Actual",R.drawable.ic_link_skype),
				new Pair<String, Integer>("Faltas",R.drawable.ic_link_facebook),
				new Pair<String, Integer>("Calificaciones",R.drawable.ic_link_google_plus));
		bar.setListNavigationCallbacks(adapter, this);
		bar.setSelectedNavigationItem(getCurrentNavigationItem());
		bar.setDisplayShowCustomEnabled(false);
	}

	@Override
	public boolean onNavigationItemSelected(int itemPosition, long itemId) {
		int current=getCurrentNavigationItem();
		if(itemPosition==current){
			return true;
		}
		
		switch(itemPosition){
			case NAV_HOME:
				replaceFragment(new HomeFragment(),FragmentTransaction.TRANSIT_FRAGMENT_CLOSE);
				return true;
			case NAV_FALTAS:
				replaceFragment(new FaltasFragment());
				return true;
			case NAV_CALIFICACIONES:
				replaceFragment(new NotesFragment());
				return true;
			default:
				return false;	
		}
	}
	
	@Override
	protected boolean onBackPressed(){
		InputMethodManager imm= (InputMethodManager)getActivity().getSystemService(
				Context.INPUT_METHOD_SERVICE);
		if(getCurrentNavigationItem()!=NAV_HOME){
			imm.hideSoftInputFromWindow(getView().getWindowToken(), 0);
			replaceFragment(new HomeFragment(),FragmentTransaction.TRANSIT_FRAGMENT_CLOSE);
			return true;
		}else{
			return super.onBackPressed();
		}
	}
	
	protected abstract int getCurrentNavigationItem();

}
