package ch.webkch.mytresor;

import android.app.Activity;
import android.content.Intent;
import android.opengl.Visibility;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

public class NeuerEintrag extends Activity implements OnItemSelectedListener {

	private LinearLayout ll_bp;
	private LinearLayout ll_p;
	private LinearLayout ll_f;

	private Spinner spinner;

	private EditText neuereintrag_bp_bezeichnung;
	private EditText neuereintrag_bp_benutzername;
	private EditText neuereintrag_bp_passwort;
	
	private EditText neuereintrag_p_bezeichnung;
	private EditText neuereintrag_p_passwort;
	
	private EditText neuereintrag_f_bezeichnung;
	private EditText neuereintrag_f_passwort;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_neuereintrag);
        initSpinner();
        ll_bp = (LinearLayout) findViewById(R.id.ll_bp);
        ll_p = (LinearLayout) findViewById(R.id.ll_p);
        ll_f = (LinearLayout) findViewById(R.id.ll_f);
        spinner = (Spinner) findViewById(R.id.typ_spinner);
        spinner.setOnItemSelectedListener(this);
    }
    
    private void initSpinner()
    {
    	Spinner spinner = (Spinner) findViewById(R.id.typ_spinner);
    	ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.typ_array, android.R.layout.simple_spinner_item);
    	adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    	spinner.setAdapter(adapter);
    }

    @Override
	protected void onDestroy() {
		super.onDestroy();
	}

    
    
    
	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int selected, long arg3) {
		if (selected == 0)
		{
			ll_p.setVisibility(View.INVISIBLE);
	        ll_f.setVisibility(View.INVISIBLE);
			ll_bp.setVisibility(View.VISIBLE);
		}
		if (selected == 1)
		{
	        ll_f.setVisibility(View.INVISIBLE);
			ll_bp.setVisibility(View.INVISIBLE);
			ll_p.setVisibility(View.VISIBLE);
		}
		if (selected == 2)
		{
			ll_p.setVisibility(View.INVISIBLE);
			ll_bp.setVisibility(View.INVISIBLE);
			ll_f.setVisibility(View.VISIBLE);
		}
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}
    
    

    
}