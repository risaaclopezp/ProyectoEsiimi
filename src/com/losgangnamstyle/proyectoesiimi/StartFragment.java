package com.losgangnamstyle.proyectoesiimi;

import com.losgangnamstyle.proyectoesiimi.extra.cAsyncTask;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class StartFragment extends EsiimaBaseFragment implements OnClickListener{
	
	private static final String TAG="StartFragment";
	
	private static final String SERVICE_URL = "http://192.168.1.72:8080/WSEsiima/webresources/verificar";
	
	private SherePreferenceData data;
	
	private String texID="",texPas="";
	
	@Override
	public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState){
		View view=inflater.inflate(R.layout.fragment_start, container,false);
		
		data=new SherePreferenceData(view.getContext());
		data.iniShared();
		
		Button login = (Button)view.findViewById(R.id.button1);
		
		login.setOnClickListener(this);
		
		return view;
	}
	
	@Override
	public void onClick(View v){
		switch(v.getId()){
		case R.id.button1:
			texID=(String)((EditText)getView().findViewById(R.id.editText2)).getText().toString();
			texPas=(String)((EditText)getView().findViewById(R.id.editText1)).getText().toString();
			if(texID.equals("")||texPas.equals("")){
				mensageError2();
				return;
			}
			String sampleURL = SERVICE_URL + "/getAcces?id="+texID+"&pass="+texPas;
			ConexionWS wst = new ConexionWS(ConexionWS.GET_TASK, getView().getContext(), "Comprobando usuario...");
	        
	        wst.execute(new String[] { sampleURL });
		}
	}
	
	public void entrar(){
		replaceFragment(new HomeFragment());
	}
	
	public void mensageError(){
		String t="Usuario ó Contraseña son incorrectos";
		Toast.makeText(getView().getContext(), t, Toast.LENGTH_SHORT).show();
	}
	
	public void mensageError2(){
		String t="Introdusca usuario o contraseña";
		Toast.makeText(getView().getContext(), t, Toast.LENGTH_SHORT).show();
	}
	
	public void guardarCuenta(String val){
		data.savedUser(val);
	}
	
	public void clearData(){
		((EditText)getView().findViewById(R.id.editText1)).setText("");
		((EditText)getView().findViewById(R.id.editText2)).setText("");
	}
	
	private class ConexionWS extends cAsyncTask{

		public ConexionWS(int taskType, Context mContext, String processMessage) {
			super(taskType, mContext, processMessage);
		}

		@Override
		protected void onPostExecute(String response) {
			pDlg.dismiss();
			Log.i("mioooo----", response);
			if(response.equals("true")){
					guardarCuenta(texID);
					clearData();
					entrar();
			}else{
					mensageError();
			}
		}
		
	}

}
