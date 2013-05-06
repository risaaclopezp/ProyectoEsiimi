package com.losgangnamstyle.proyectoesiimi;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragment;
import com.actionbarsherlock.view.MenuItem;

public class EsiimaBaseFragment extends SherlockFragment {

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }
    
    @Override
    public void onResume() {
        super.onResume();
        ActionBar bar= getSherlockActivity().getSupportActionBar();
        bar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        bar.setIcon(R.drawable.ic_launcher);
        bar.setCustomView(R.layout.image_logo);
        bar.setDisplayShowTitleEnabled(false);
        bar.setDisplayShowCustomEnabled(true);
        bar.setDisplayHomeAsUpEnabled(false);
        bar.setHomeButtonEnabled(false);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        case android.R.id.home:
            getActivity().onBackPressed();
            return true;
        default:
            return super.onOptionsItemSelected(item);
        }
    }

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

    protected boolean onBackPressed() {
        return false;
    }
}
