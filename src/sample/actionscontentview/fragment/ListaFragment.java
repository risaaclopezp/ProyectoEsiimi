package sample.actionscontentview.fragment;

import com.losgangnamstyle.proyectoesiimi.R;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ListaFragment extends Fragment {
	  public static final String TAG = ListaFragment.class.getSimpleName();

	  private static final String LISTA_SCHEME = "settings";
	  private static final String LISTA_AUTHORITY = "lista";
	  public static final Uri LISTA_URI = new Uri.Builder()
	  .scheme(LISTA_SCHEME)
	  .authority(LISTA_AUTHORITY)
	  .build();

	  @Override
	  public View onCreateView(LayoutInflater inflater, ViewGroup container,
	      Bundle savedInstanceState) {

	    final View v = inflater.inflate(R.layout.lista, container, false);
	    final TextView m1 = (TextView) v.findViewById(R.id.textViewMat1);
	    final TextView m2 = (TextView) v.findViewById(R.id.textViewMat2);
	    final TextView m3 = (TextView) v.findViewById(R.id.textViewMat3);
	    final TextView m4 = (TextView) v.findViewById(R.id.textViewMat4);
	    final TextView m5 = (TextView) v.findViewById(R.id.textViewMat5);
	    final TextView m6 = (TextView) v.findViewById(R.id.textViewMat6);
	    final TextView c11 = (TextView) v.findViewById(R.id.textViewMat11C);
	    final TextView c21 = (TextView) v.findViewById(R.id.textViewMat21C);
	    final TextView c31 = (TextView) v.findViewById(R.id.textViewMat31C);
	    final TextView c41 = (TextView) v.findViewById(R.id.textViewMat41C);
	    final TextView c51 = (TextView) v.findViewById(R.id.textViewMat51C);
	    final TextView c61 = (TextView) v.findViewById(R.id.textViewMat61C);
	    
	    
	    if(0==0){
  	  		m1.setText("Programaci�n de interfaces");
  	  		m2.setText("Inteligencia artificial");
  	  		m3.setText("Finanzas");
  	  		m4.setText("Optativa");
  	  		m5.setText("Base de datos");
  	  		m6.setText("Computo distribuido");
  	  		c11.setText("4");
	  		c21.setText("2");
	  		c31.setText("1");
	  		c41.setText("0");
	  		c51.setText("3");
	  		c61.setText("1");
  	  	}else if(0==1){
  	  		m1.setText("Optativa");
	  		m2.setText("Ingenier�a de software");
	  		m3.setText("Sistemas Avanzados");
	  		m4.setText("Legislaci�n en inform�tica");
	  		m5.setText("Seminario de sistemas");
	  		m6.setText("Administraci�n de operaciones");
	  		c11.setText("1");
  	  		c21.setText("0");
  	  		c31.setText("0");
  	  		c41.setText("0");
  	  		c51.setText("2");
  	  		c61.setText("0");
  	  	}

	    return v;
	  }
	}