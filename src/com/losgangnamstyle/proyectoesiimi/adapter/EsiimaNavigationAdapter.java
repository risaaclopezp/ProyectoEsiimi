package com.losgangnamstyle.proyectoesiimi.adapter;

import android.content.Context;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.losgangnamstyle.proyectoesiimi.R;

public class EsiimaNavigationAdapter extends ArrayAdapter<Pair<String, Integer>>{
	
	private LayoutInflater mInflater;
	
	public EsiimaNavigationAdapter(Context context, Pair<String, Integer>... objects){
		super(context, R.layout.spiner_navigation_main,objects);
		mInflater=(LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}
	
	@Override
	public View getView(int position,View convertView,ViewGroup parent){
		View view=convertView;
		if(view==null){
			view=mInflater.inflate(R.layout.spiner_navigation_main, parent, false);
		}
		
		Pair<String, Integer> item=getItem(position);
		
		TextView text=(TextView)view.findViewById(R.id.text);
		text.setTag(item.first);
		
		return view;
	}

	@Override
	public View getDropDownView(int position, View convertView, ViewGroup parent){
		View view=convertView;
		if(view==null){
			LayoutInflater inflater=(LayoutInflater)getContext().getSystemService(
					Context.LAYOUT_INFLATER_SERVICE);
			view=inflater.inflate(R.layout.spinner_navigation_dropdown, parent, false);
		}
		
		Pair<String, Integer> item=getItem(position);
		
		TextView text=(TextView)view.findViewById(R.id.text);
		text.setText(item.first);
		text.setCompoundDrawablesWithIntrinsicBounds(item.second, 0, 0, 0);
		
		return view;
	}
}
