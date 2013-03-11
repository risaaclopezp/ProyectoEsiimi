package sample.actionscontentview.fragment;

import com.losgangnamstyle.proyectoesiimi.R;
import sample.actionscontentview.ExamplesActivity;
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
import android.widget.TextView;

public class AboutFragment extends Fragment {
  public static final String TAG = AboutFragment.class.getSimpleName();

  private static final String ABOUT_SCHEME = "settings";
  private static final String ABOUT_AUTHORITY = "about";
  public static final Uri ABOUT_URI = new Uri.Builder()
  .scheme(ABOUT_SCHEME)
  .authority(ABOUT_AUTHORITY)
  .build();

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {

    final View v = inflater.inflate(R.layout.about, container, false);
    final TextView id = (TextView) v.findViewById(R.id.textViewIDC);
    final TextView nombre = (TextView) v.findViewById(R.id.textViewNombreC);
    final TextView situacion = (TextView) v.findViewById(R.id.textViewSitAcC);
    final TextView promedio = (TextView) v.findViewById(R.id.textViewPAC);
    final TextView adeudo = (TextView) v.findViewById(R.id.textViewAMC);
    final TextView grupo = (TextView) v.findViewById(R.id.textViewGrC);
    final TextView generacion = (TextView) v.findViewById(R.id.textViewGeC);
    if(0==0){
    		id.setTextColor(Color.RED);
	  		id.setText("12345");
	  		nombre.setTextColor(Color.RED);
	  		nombre.setText("Oropeza Omar");
	  		situacion.setTextColor(Color.RED);
	  		situacion.setText("Irregular");
	  		promedio.setTextColor(Color.RED);
	  		promedio.setText("");
	  		adeudo.setTextColor(Color.RED);
	  		adeudo.setText("1");
	  		grupo.setTextColor(Color.RED);
	  		grupo.setText("8-C");
	  		generacion.setTextColor(Color.RED);
	  		generacion.setText("AGO-2008 - DIC-2012");
	  	}else if(0==1){
	  		id.setTextColor(Color.BLACK);
	  		id.setText("54321");
	  		nombre.setTextColor(Color.BLACK);
	  		nombre.setText("López Rubén");
	  		situacion.setTextColor(Color.BLACK);
	  		situacion.setText("Regular");
	  		promedio.setTextColor(Color.BLACK);
	  		promedio.setText("7.99");
	  		adeudo.setTextColor(Color.BLACK);
	  		adeudo.setText("0");
	  		grupo.setTextColor(Color.BLACK);
	  		grupo.setText("9-B");
	  		generacion.setTextColor(Color.BLACK);
	  		generacion.setText("AGO-2009 - DIC-2013");
	  	}

    /*v.findViewById(R.id.btn_lunes).setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        final Activity a = getActivity();
        if (a instanceof ExamplesActivity) {
          final ExamplesActivity examplesActivity = (ExamplesActivity) a;
          examplesActivity.updateContent(SandboxFragment.SETTINGS_URI);
        }
      }
    });*/

    return v;
  }
}
