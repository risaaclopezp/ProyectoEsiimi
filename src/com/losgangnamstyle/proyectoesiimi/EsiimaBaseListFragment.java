package com.losgangnamstyle.proyectoesiimi;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockListFragment;

public abstract class EsiimaBaseListFragment extends SherlockListFragment {
	
	public EsiimaBaseListFragment(){
		super();
	}
	
	@Override
	public void onViewCreated(View view,Bundle savedInstanceState){
		super.onViewCreated(view, savedInstanceState);
		TextView text=(TextView)view.findViewById(android.R.id.empty);
		text.setText(getEmptyText());
	}
	
	public void refresh(){
		getLoaderManager().getLoader(getLoaderId()).forceLoad();
		//getView().findViewById(R.id.Loading).setVisibility(View.VISIBLE);
	}
	
	protected abstract String getEmptyText();

    protected abstract int getLoaderId();
    
    protected void replaceFragment(Fragment fragment) {
        replaceFragment(fragment, FragmentTransaction.TRANSIT_FRAGMENT_OPEN, false);
    }

    protected void replaceFragment(Fragment fragment, boolean addToBackStack) {
        replaceFragment(fragment, FragmentTransaction.TRANSIT_FRAGMENT_OPEN, addToBackStack);
    }

    protected void replaceFragment(Fragment fragment, int transit) {
        replaceFragment(fragment, transit, false);
    }

    protected void replaceFragment(Fragment fragment, int transit, boolean addToBackStack) {
        FragmentTransaction transaction= getFragmentManager().beginTransaction();
        transaction.replace(R.id.layout_fragment, fragment);
        transaction.setTransition(transit);
    
        if (addToBackStack) {
            transaction.addToBackStack(null);
        }
    
        transaction.commit();
    }

}
