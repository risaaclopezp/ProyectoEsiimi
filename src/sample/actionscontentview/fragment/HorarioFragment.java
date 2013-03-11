package sample.actionscontentview.fragment;

import com.losgangnamstyle.proyectoesiimi.MainActivity;
import com.losgangnamstyle.proyectoesiimi.Persona;
import com.losgangnamstyle.proyectoesiimi.R;
import sample.actionscontentview.ExamplesActivity;
import sample.actionscontentview.fragment.SandboxFragment.OnSettingsChangedListener;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class HorarioFragment extends Fragment {
	  public static final String TAG = HorarioFragment.class.getSimpleName();

	  private static final String HORARIO_SCHEME = "settings";
	  private static final String HORARIO_AUTHORITY = "horario";
	  public static final Uri HORARIO_URI = new Uri.Builder()
	  .scheme(HORARIO_SCHEME)
	  .authority(HORARIO_AUTHORITY)
	  .build();
	  MainActivity obj = new MainActivity();

	  @Override
	  public View onCreateView(LayoutInflater inflater, ViewGroup container,
	      Bundle savedInstanceState) {

	    final View v = inflater.inflate(R.layout.horario, container, false);
	    final TextView h1 = (TextView) v.findViewById(R.id.textView34C);
	    final TextView txt = (TextView) v.findViewById(R.id.textViewHora);
	    final TextView h2 = (TextView) v.findViewById(R.id.textView45C);
	    final TextView h3 = (TextView) v.findViewById(R.id.textView56C);
	    final TextView h4 = (TextView) v.findViewById(R.id.textView67C);
	    final TextView h5 = (TextView) v.findViewById(R.id.textView78C);
	    final TextView h6 = (TextView) v.findViewById(R.id.textView89C);
	    final Button btnLun = (Button) v.findViewById(R.id.btn_lunes);
	    final Button btnMar = (Button) v.findViewById(R.id.btn_martes);
	    final Button btnMie = (Button) v.findViewById(R.id.btn_miercoles);
	    final Button btnJue = (Button) v.findViewById(R.id.btn_jueves);
	    final Button btnVie = (Button) v.findViewById(R.id.btn_viernes);
	    btnLun.setTextColor(Color.CYAN);
  	  	btnMar.setTextColor(R.color.bottom_bar_text);
  	  	btnMie.setTextColor(R.color.bottom_bar_text);
  	  	btnJue.setTextColor(R.color.bottom_bar_text);
  	  	btnVie.setTextColor(R.color.bottom_bar_text);
  	  	
  	  Context x=this.getActivity().getApplicationContext();
		SharedPreferences login=x.getSharedPreferences("userk",Context.MODE_PRIVATE);
		int idchek=login.getInt("IDU", 0);
		Persona p=new Persona();
		
  	  	if(idchek==p.getId1()){
  	  		h1.setText("Programación de interfaces");
  	  		h2.setText("Inteligencia artificial");
  	  		h3.setText("Finanzas");
  	  		h4.setText("Optativa");
  	  		h5.setText("Base de datos");
  	  		h6.setText("Computo distribuido");
  	  	}else if(idchek==p.getId2()){
  	  		h1.setText("Optativa");
	  		h2.setText("Ingeniería de software");
	  		h3.setText("Sistemas Avanzados");
	  		h4.setText("Legislación en informática");
	  		h5.setText("Seminario de sistemas");
	  		h6.setText("Administración de operaciones");
  	  	}
  	  		    
	    btnLun.setOnClickListener(new View.OnClickListener() {
	      @Override
		public void onClick(View v) {
	    	  btnLun.setTextColor(Color.CYAN);
	    	  btnMar.setTextColor(R.color.bottom_bar_text);
	    	  btnMie.setTextColor(R.color.bottom_bar_text);
	    	  btnJue.setTextColor(R.color.bottom_bar_text);
	    	  btnVie.setTextColor(R.color.bottom_bar_text);
	    	  if(0==0){
	    	  		h1.setText("Programación de interfaces");
	    	  		h2.setText("Inteligencia artificial");
	    	  		h3.setText("Finanzas");
	    	  		h4.setText("Optativa");
	    	  		h5.setText("Base de datos");
	    	  		h6.setText("Computo distribuido");
	    	  	}else if(0==1){
	    	  		h1.setText("Optativa");
	    	  		h2.setText("Ingeniería de software");
	    	  		h3.setText("Sistemas Avanzados");
	    	  		h4.setText("Legislación en informática");
	    	  		h5.setText("Seminario de sistemas");
	    	  		h6.setText("Administración de operaciones");
	    	  	}
	      }
	    });
	    
	    btnMar.setOnClickListener(new View.OnClickListener() {
		      @Override
			public void onClick(View v) {
		    	  btnLun.setTextColor(R.color.bottom_bar_text);
		    	  btnMar.setTextColor(Color.CYAN);
		    	  btnMie.setTextColor(R.color.bottom_bar_text);
		    	  btnJue.setTextColor(R.color.bottom_bar_text);
		    	  btnVie.setTextColor(R.color.bottom_bar_text);
		    	  if(0==0){
		    	  		h1.setText("Programación de interfaces");
		    	  		h2.setText("Inteligencia artificial");
		    	  		h3.setText("Finanzas");
		    	  		h4.setText("Optativa");
		    	  		h5.setText("Base de datos");
		    	  		h6.setText("Computo distribuido");
		    	  	}else if(0==1){
		    	  		h1.setText("Optativa");
		    	  		h2.setText("Ingeniería de software");
		    	  		h3.setText("Sistemas Avanzados");
		    	  		h4.setText("Legislación en informática");
		    	  		h5.setText("Seminario de sistemas");
		    	  		h6.setText("Administración de operaciones");
		    	  	}
		      }
		    });
	    
	    btnMie.setOnClickListener(new View.OnClickListener() {
		      @Override
			public void onClick(View v) {
		    	  btnLun.setTextColor(R.color.bottom_bar_text);
		    	  btnMar.setTextColor(R.color.bottom_bar_text);
		    	  btnMie.setTextColor(Color.CYAN);
		    	  btnJue.setTextColor(R.color.bottom_bar_text);
		    	  btnVie.setTextColor(R.color.bottom_bar_text);
		    	  if(0==0){
		    	  		h1.setText("Programación de interfaces");
		    	  		h2.setText("Inteligencia artificial");
		    	  		h3.setText("Finanzas");
		    	  		h4.setText("Optativa");
		    	  		h5.setText("Base de datos");
		    	  		h6.setText("Computo distribuido");
		    	  	}else if(0==1){
		    	  		h1.setText("Optativa");
		    	  		h2.setText("Ingeniería de software");
		    	  		h3.setText("Sistemas Avanzados");
		    	  		h4.setText("Legislación en informática");
		    	  		h5.setText("Seminario de sistemas");
		    	  		h6.setText("Administración de operaciones");
		    	  	}
		      }
		    });
	    
	    btnJue.setOnClickListener(new View.OnClickListener() {
		      @Override
			public void onClick(View v) {
		    	  btnLun.setTextColor(R.color.bottom_bar_text);
		    	  btnMar.setTextColor(R.color.bottom_bar_text);
		    	  btnMie.setTextColor(R.color.bottom_bar_text);
		    	  btnJue.setTextColor(Color.CYAN);
		    	  btnVie.setTextColor(R.color.bottom_bar_text);
		    	  if(0==0){
		    	  		h1.setText("Programación de interfaces");
		    	  		h2.setText("Inteligencia artificial");
		    	  		h3.setText("Finanzas");
		    	  		h4.setText("Optativa");
		    	  		h5.setText("Base de datos");
		    	  		h6.setText("Computo distribuido");
		    	  	}else if(0==1){
		    	  		h1.setText("Optativa");
		    	  		h2.setText("Ingeniería de software");
		    	  		h3.setText("Sistemas Avanzados");
		    	  		h4.setText("Legislación en informática");
		    	  		h5.setText("Seminario de sistemas");
		    	  		h6.setText("Administración de operaciones");
		    	  	}
		      }
		    });
	    
	    btnVie.setOnClickListener(new View.OnClickListener() {
		      @Override
			public void onClick(View v) {
		    	  btnLun.setTextColor(R.color.bottom_bar_text);
		    	  btnMar.setTextColor(R.color.bottom_bar_text);
		    	  btnMie.setTextColor(R.color.bottom_bar_text);
		    	  btnJue.setTextColor(R.color.bottom_bar_text);
		    	  btnVie.setTextColor(Color.CYAN);
		    	  if(0==0){
		    	  		h1.setText("-");
		    	  		h2.setText("-");
		    	  		h3.setText("Finanzas");
		    	  		h4.setText("-");
		    	  		h5.setText("-");
		    	  		h6.setText("-");
		    	  	}else if(0==1){
		    	  		h1.setText("Optativa");
		    	  		h2.setText("-");
		    	  		h3.setText("Sistemas Avanzados");
		    	  		h4.setText("-");
		    	  		h5.setText("-");
		    	  		h6.setText("Administración de operaciones");
		    	  	}
		      }
		    });

	    return v;
	  }
	
	  
	}


