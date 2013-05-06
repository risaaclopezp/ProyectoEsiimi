package com.losgangnamstyle.proyectoesiimi;

import android.content.Context;
import android.content.SharedPreferences;

public class SherePreferenceData {
	
	private SharedPreferences login;
	private static String ID_USUARIO="userk";
	private static String IDU="idu";
	private static String SITUACION="situa";
	private static String CALIFICACION="calif";
	private static String FALTAS="faltas";
	
	private static String TAG = "SherePreferenceData";
	
	private Context context;
	
	private SharedPreferences.Editor edi;
	
	public SherePreferenceData(Context context){
		this.context=context;
	}
	
	public void iniShared(){
		login=this.context.getSharedPreferences(ID_USUARIO,Context.MODE_PRIVATE);
	}
	
	public boolean isUserInit(int val){
		int valC=login.getInt(IDU, val);
		if(valC==val){
			return false;
		}else{
			return true;
		}
	}
	
	public void savedUser(String val){
		this.edi=login.edit();
		edi.putInt(IDU, Integer.parseInt(val));
		edi.commit();
	}
	
	public void savedCalf(String val){
		this.edi=login.edit();
		edi.putString(CALIFICACION, val);
		edi.commit();
	}
	
	public void savedFaltas(String val){
		this.edi=login.edit();
		edi.putString(FALTAS, val);
		edi.commit();
	}
	
	public void savedSituacion(String val){
		this.edi=login.edit();
		edi.putString(SITUACION, val);
		edi.commit();
	}
	
	public int getID(int ret){
		int val=login.getInt(IDU, ret);
		return val;
	}
	
	public String getSituacion(String ret){
		String val=login.getString(SITUACION, ret);
		return val;
	}
	
	public String getCalificacion(String ret){
		String val=login.getString(CALIFICACION, ret);
		return val;
	}
	
	public String getFaltas(String ret){
		String val=login.getString(FALTAS, ret);
		return val;
	}
}
