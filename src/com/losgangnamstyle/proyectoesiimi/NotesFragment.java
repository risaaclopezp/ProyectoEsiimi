package com.losgangnamstyle.proyectoesiimi;

import org.json.JSONException;
import org.json.JSONArray;
import org.json.JSONObject;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.losgangnamstyle.proyectoesiimi.extra.cAsyncTask;

public class NotesFragment extends EsiimaBaseNavigationFragment {

	private static final String TAG="NotesFragment";
	
	private static final String SERVICE_URL = "http://192.168.1.72:8080/WSEsiima/webresources/verificar";
	
	private SherePreferenceData data;
	
	@Override
	public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState){
		View view=inflater.inflate(R.layout.calificacion, container, false);
		data=new SherePreferenceData(view.getContext());
		data.iniShared();
		return view;
	}
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		String sampleURL = SERVICE_URL + "/getCalificaciones?id="+data.getID(0);
		ConexionWS wst = new ConexionWS(ConexionWS.GET_TASK, getView().getContext(), "Obteniendo datos...");
        
        wst.execute(new String[] { sampleURL });
	}
	@Override
	protected int getCurrentNavigationItem() {
		return NAV_CALIFICACIONES;
	}
	
	private class ConexionWS extends cAsyncTask{

		public ConexionWS(int taskType, Context mContext, String processMessage) {
			super(taskType, mContext, processMessage);
		}

		@Override
		protected void onPostExecute(String response) {
			pDlg.dismiss();
			try {
				JSONArray datos;
				if(!response.equals("")){
					datos=new JSONArray(response);
					data.savedCalf(response);
				}else{
					datos=new JSONArray(data.getCalificacion(""));
				}
				
				final TextView m1 = (TextView) getView().findViewById(R.id.textViewMat1);
			    final TextView m2 = (TextView) getView().findViewById(R.id.textViewMat2);
			    final TextView m3 = (TextView) getView().findViewById(R.id.textViewMat3);
			    final TextView m4 = (TextView) getView().findViewById(R.id.textViewMat4);
			    final TextView m5 = (TextView) getView().findViewById(R.id.textViewMat5);
			    final TextView m6 = (TextView) getView().findViewById(R.id.textViewMat6);
			    final TextView c11 = (TextView) getView().findViewById(R.id.textViewMat11C);
			    final TextView c21 = (TextView) getView().findViewById(R.id.textViewMat21C);
			    final TextView c31 = (TextView) getView().findViewById(R.id.textViewMat31C);
			    final TextView c41 = (TextView) getView().findViewById(R.id.textViewMat41C);
			    final TextView c51 = (TextView) getView().findViewById(R.id.textViewMat51C);
			    final TextView c61 = (TextView) getView().findViewById(R.id.textViewMat61C);
			    final TextView c12 = (TextView) getView().findViewById(R.id.textViewMat12C);
			    final TextView c22 = (TextView) getView().findViewById(R.id.textViewMat22C);
			    final TextView c32 = (TextView) getView().findViewById(R.id.textViewMat32C);
			    final TextView c42 = (TextView) getView().findViewById(R.id.textViewMat42C);
			    final TextView c52 = (TextView) getView().findViewById(R.id.textViewMat52C);
			    final TextView c62 = (TextView) getView().findViewById(R.id.textViewMat62C);
			    final TextView c13 = (TextView) getView().findViewById(R.id.textViewMat13C);
			    final TextView c23 = (TextView) getView().findViewById(R.id.textViewMat23C);
			    final TextView c33 = (TextView) getView().findViewById(R.id.textViewMat33C);
			    final TextView c43 = (TextView) getView().findViewById(R.id.textViewMat43C);
			    final TextView c53 = (TextView) getView().findViewById(R.id.textViewMat53C);
			    final TextView c63 = (TextView) getView().findViewById(R.id.textViewMat63C);
			    JSONObject d=datos.getJSONObject(datos.length()-1);
			    int parciales=d.getInt("id_parcial"),x=0;
			    if(parciales>=1)
			    for(int i=0;i<datos.length();i=i+parciales){
			    	d=datos.getJSONObject(i);
			    	if(x==0)m1.setText(d.getString("nombre"));
			    	if(x==1)m2.setText(d.getString("nombre"));
		  	  		if(x==2)m3.setText(d.getString("nombre"));
		  	  		if(x==3)m4.setText(d.getString("nombre"));
		  	  		if(x==4)m5.setText(d.getString("nombre"));
		  	  		if(x==5)m6.setText(d.getString("nombre"));
		  	  		if(x==0)c11.setText(String.valueOf(d.getInt("calificacion")));
		  	  		if(x==1)c21.setText(String.valueOf(d.getInt("calificacion")));
		  	  		if(x==2)c31.setText(String.valueOf(d.getInt("calificacion")));
		  	  		if(x==3)c41.setText(String.valueOf(d.getInt("calificacion")));
		  	  		if(x==4)c51.setText(String.valueOf(d.getInt("calificacion")));
		  	  		if(x==5)c61.setText(String.valueOf(d.getInt("calificacion")));
		  	  		x++;
			    }
			    x=0;
			    if(parciales>=2)
			    for(int i=1;i<datos.length();i=i+parciales){
			    	d=datos.getJSONObject(i);
		  	  		if(x==0)c12.setText(String.valueOf(d.getInt("calificacion")));
		  	  		if(x==1)c22.setText(String.valueOf(d.getInt("calificacion")));
		  	  		if(x==2)c32.setText(String.valueOf(d.getInt("calificacion")));
		  	  		if(x==3)c42.setText(String.valueOf(d.getInt("calificacion")));
		  	  		if(x==4)c52.setText(String.valueOf(d.getInt("calificacion")));
		  	  		if(x==5)c62.setText(String.valueOf(d.getInt("calificacion")));
		  	  		x++;
			    }
			    x=0;
			    if(parciales>=3)
			    for(int i=2;i<datos.length();i=i+parciales){
			    	d=datos.getJSONObject(i);
			    	if(x==0)c13.setText(String.valueOf(d.getInt("calificacion")));
		  	  		if(x==1)c23.setText(String.valueOf(d.getInt("calificacion")));
		  	  		if(x==2)c33.setText(String.valueOf(d.getInt("calificacion")));
		  	  		if(x==3)c43.setText(String.valueOf(d.getInt("calificacion")));
		  	  		if(x==4)c53.setText(String.valueOf(d.getInt("calificacion")));
		  	  		if(x==5)c63.setText(String.valueOf(d.getInt("calificacion")));
		  	  		x++;
			    }
				
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
