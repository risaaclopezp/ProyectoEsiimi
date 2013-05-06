package com.losgangnamstyle.proyectoesiimi;

import com.losgangnamstyle.proyectoesiimi.extra.cAsyncTask;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;


public class HomeFragment extends EsiimaBaseNavigationFragment {
	
	private static final String TAG="HomeFragment";
	
	private static final String SERVICE_URL = "http://192.168.1.72:8080/WSEsiima/webresources/verificar";
	
	private SherePreferenceData data;
	
	@Override
	public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState){
		View view=inflater.inflate(R.layout.about, container, false);
		data=new SherePreferenceData(view.getContext());
		data.iniShared();
		return view;
	}
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		String sampleURL = SERVICE_URL + "/getData?id="+data.getID(0);
		ConexionWS wst = new ConexionWS(ConexionWS.GET_TASK, getView().getContext(), "Obteniendo datos...");
        
        wst.execute(new String[] { sampleURL });
	}
	@Override
	protected int getCurrentNavigationItem() {
		return NAV_HOME;
	}
	
	private class ConexionWS extends cAsyncTask{

		public ConexionWS(int taskType, Context mContext, String processMessage) {
			super(taskType, mContext, processMessage);
		}

		@Override
		protected void onPostExecute(String response) {
			pDlg.dismiss();
			try {
				JSONObject datos;
				if(!response.equals("")){
					datos=new JSONObject(response);
					data.savedSituacion(response);
				}else{
					datos=new JSONObject(data.getSituacion(""));
				}
				
				
			    final TextView id = (TextView) getView().findViewById(R.id.textViewIDC);
			    final TextView nombre = (TextView) getView().findViewById(R.id.textViewNombreC);
			    final TextView situacion = (TextView) getView().findViewById(R.id.textViewSitAcC);
			    final TextView promedio = (TextView) getView().findViewById(R.id.textViewPAC);
			    final TextView adeudo = (TextView) getView().findViewById(R.id.textViewAMC);
			    final TextView grupo = (TextView) getView().findViewById(R.id.textViewGrC);
			    final TextView generacion = (TextView) getView().findViewById(R.id.textViewGeC);
			    Log.i("hola-------", datos.getInt("id")+datos.getString("nombre")+datos.getString("generacion")+datos.getString("situacion"));
			    id.setTextColor(Color.BLACK);
			    		id.setText(String.valueOf(datos.getInt("id")));
				  		nombre.setText(datos.getString("nombre"));
				  		situacion.setText(datos.getString("situacion"));
				  		generacion.setText(datos.getString("generacion"));
				
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		
	}

}
