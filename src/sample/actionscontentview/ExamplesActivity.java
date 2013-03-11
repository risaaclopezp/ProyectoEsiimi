package sample.actionscontentview;

import com.losgangnamstyle.proyectoesiimi.R;
import sample.actionscontentview.adapter.ActionsAdapter;
import sample.actionscontentview.fragment.AboutFragment;
import sample.actionscontentview.fragment.CalificacionesFragment;
import sample.actionscontentview.fragment.HorarioFragment;
import sample.actionscontentview.fragment.ListaFragment;
import sample.actionscontentview.fragment.SandboxFragment;
import sample.actionscontentview.fragment.WebViewFragment;
import shared.ui.actionscontentview.ActionsContentView;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class ExamplesActivity extends FragmentActivity {

  private static final String STATE_URI = "state:uri";
  private static final String STATE_FRAGMENT_TAG = "state:fragment_tag";

  private SettingsChangedListener mSettingsChangedListener;

  private ActionsContentView viewActionsContentView;

  private Uri currentUri = AboutFragment.ABOUT_URI;
  private String currentContentFragmentTag = null;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    mSettingsChangedListener = new SettingsChangedListener();

    setContentView(R.layout.example);

    viewActionsContentView = (ActionsContentView) findViewById(R.id.actionsContentView);

    final ListView viewActionsList = (ListView) findViewById(R.id.actions);
    final ActionsAdapter actionsAdapter = new ActionsAdapter(this);
    viewActionsList.setAdapter(actionsAdapter);
    viewActionsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> adapter, View v, int position,
          long flags) {
        final Uri uri = actionsAdapter.getItem(position);
        updateContent(uri);
        viewActionsContentView.showContent();
      }
    });

    if (savedInstanceState != null) {
      currentUri = Uri.parse(savedInstanceState.getString(STATE_URI));
      currentContentFragmentTag = savedInstanceState.getString(STATE_FRAGMENT_TAG);
    }

    updateContent(currentUri);
  }

  public void onActionsButtonClick(View view) {
    if (viewActionsContentView.isActionsShown())
      viewActionsContentView.showContent();
    else
      viewActionsContentView.showActions();
  }

  @Override
  protected void onSaveInstanceState(Bundle outState) {
    outState.putString(STATE_URI, currentUri.toString());
    outState.putString(STATE_FRAGMENT_TAG, currentContentFragmentTag);

    super.onSaveInstanceState(outState);
  }

  public void onSourceCodeClick(View view) {
    final Intent i = new Intent(Intent.ACTION_VIEW);
    i.setData(Uri.parse(getString(R.string.sources_link)));
    startActivity(i);
  }

  public void updateContent(Uri uri) {
    final Fragment fragment;
    final String tag;

    final FragmentManager fm = getSupportFragmentManager();
    final FragmentTransaction tr = fm.beginTransaction();

    if (currentContentFragmentTag != null) {
      final Fragment currentFragment = fm.findFragmentByTag(currentContentFragmentTag);
      if (currentFragment != null)
        tr.hide(currentFragment);
    }

    if (AboutFragment.ABOUT_URI.equals(uri)) {
      tag = AboutFragment.TAG;
      final Fragment foundFragment = fm.findFragmentByTag(tag);
      if (foundFragment != null) {
        fragment = foundFragment;
      } else {
        fragment = new AboutFragment();
      }
    } else if (HorarioFragment.HORARIO_URI.equals(uri)) {
        tag = HorarioFragment.TAG;
        final Fragment foundFragment = fm.findFragmentByTag(tag);
        if (foundFragment != null) {
          fragment = foundFragment;
        } else {
          fragment = new HorarioFragment();
        }
      }	else if (CalificacionesFragment.CALIFICACION_URI.equals(uri)) {
          tag = CalificacionesFragment.TAG;
          final Fragment foundFragment = fm.findFragmentByTag(tag);
          if (foundFragment != null) {
            fragment = foundFragment;
          } else {
            fragment = new CalificacionesFragment();
          }
        } else if (ListaFragment.LISTA_URI.equals(uri)) {
        	tag = ListaFragment.TAG;
        	final Fragment foundFragment = fm.findFragmentByTag(tag);
        	if (foundFragment != null) {
        		fragment = foundFragment;
        	} else {
        		fragment = new ListaFragment();
        	}
        }
    
    	/*else if (uri != null) {
      tag = WebViewFragment.TAG;
      final WebViewFragment webViewFragment;
      final Fragment foundFragment = fm.findFragmentByTag(tag);
      if (foundFragment != null) {
        fragment = foundFragment;
        webViewFragment = (WebViewFragment) fragment;
      } else {
        webViewFragment = new WebViewFragment();
        fragment = webViewFragment;
      }
      webViewFragment.setUrl(uri.toString());
    }*/ else {
      return;
    }

    if (fragment.isAdded()) {
      tr.show(fragment);
    } else {
      tr.add(R.id.content, fragment, tag);
    }
    tr.commit();

    currentUri = uri;
    currentContentFragmentTag = tag;
  }

  private class SettingsChangedListener implements SandboxFragment.OnSettingsChangedListener {
    private final float mDensity = getResources().getDisplayMetrics().density;
    private final int mAdditionaSpacingWidth = (int) (100 * mDensity);

    @Override
    public void onSettingChanged(int prefId, int value) {
      /*switch (prefId) {
      case SandboxFragment.PREF_SPACING_TYPE:
        final int currentType = viewActionsContentView.getSpacingType();
        if (currentType == value)
          return;

        final int spacingWidth = viewActionsContentView.getSpacingWidth();
        if (value == ActionsContentView.SPACING_ACTIONS_WIDTH) {
          viewActionsContentView.setSpacingWidth(spacingWidth + mAdditionaSpacingWidth);
        } else if (value == ActionsContentView.SPACING_RIGHT_OFFSET) {
          viewActionsContentView.setSpacingWidth(spacingWidth - mAdditionaSpacingWidth);
        }
        viewActionsContentView.setSpacingType(value);
        return;
      case SandboxFragment.PREF_SPACING_WIDTH:
        final int width;
        if (viewActionsContentView.getSpacingType() == ActionsContentView.SPACING_ACTIONS_WIDTH)
          width = (int) (value * mDensity) + mAdditionaSpacingWidth;
        else
          width = (int) (value * mDensity);
        viewActionsContentView.setSpacingWidth(width);
        return;
      case SandboxFragment.PREF_SPACING_ACTIONS_WIDTH:
        viewActionsContentView.setActionsSpacingWidth((int) (value * mDensity));
        return;
      case SandboxFragment.PREF_SHOW_SHADOW:
        viewActionsContentView.setShadowVisible(value == 1);
        return;
      case SandboxFragment.PREF_FADE_TYPE:
        viewActionsContentView.setFadeType(value);
        return;
      case SandboxFragment.PREF_FADE_MAX_VALUE:
        viewActionsContentView.setFadeValue(value);
        return;
      case SandboxFragment.PREF_SWIPING_TYPE:
        viewActionsContentView.setSwipingType(value);
        return;
      case SandboxFragment.PREF_SWIPING_EDGE_WIDTH:
        viewActionsContentView.setSwipingEdgeWidth(value);
        return;
      case SandboxFragment.PREF_FLING_DURATION:
        viewActionsContentView.setFlingDuration(value);
        return;
      default:
        return;
      }*/
    }
  };
}
