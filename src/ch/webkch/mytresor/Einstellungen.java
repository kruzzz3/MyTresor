package ch.webkch.mytresor;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Toast;

public class Einstellungen extends Activity {

	/*
    **********************************************
    *** VAR
    **********************************************
    */
	
	private int view;
	
	
	
	private Spinner spinnerMP;
	private Button einstellungen_speichern;
	private int mp_typ = 0;
	
	/*
    **********************************************
    *** DEFAULT METHODE
    **********************************************
    */
	
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        manageBundle(savedInstanceState);
        if (view == 1)
        {
        	setContentView(R.layout.activity_einstellungen1);
        }
        if (view == 2)
        {
        	setContentView(R.layout.activity_einstellungen2);
        }
        initSpinner();
        loadEinstellungen();
        setEinstellungen();
        einstellungen_speichern = (Button) findViewById(R.id.einstellungen_speichern);
    }

    @Override
	protected void onDestroy() {
		super.onDestroy();
	}
    
    private void activityFinish()
	{
		this.finish();
	}

    /*
	**********************************************
	*** Bundle
	**********************************************
	*/
	
	private void manageBundle(Bundle bundle)
	{
		bundle = getIntent().getExtras();
		view = bundle.getInt("view");
	}
	
	/*
    **********************************************
    *** INIT METHODE
    **********************************************
    */
	
	private void initSpinner()
	{
		spinnerMP = (Spinner) findViewById(R.id.mp_spinner);
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.mp_array, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinnerMP.setAdapter(adapter);
		spinnerMP.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int selected, long arg3) {
				if (selected == 0)
				{
					mp_typ = 0;
				}
				if (selected == 1)
				{
					mp_typ = 1;
				}
				if (selected == 2)
				{
					mp_typ = 2;
				}
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {}
		});
	}
	
	private void loadEinstellungen()
	{
		Cursor cursor = Init.db.selectRecordEinstellungen();
		mp_typ = cursor.getInt(cursor.getColumnIndex(MyDataBaseHandler.EMP_E_MPTYP));
		cursor.close();
	}
	
	private void setEinstellungen()
	{
		spinnerMP.setSelection(mp_typ);
	}
	
	/*
	**********************************************
	*** Buttons
	**********************************************
	*/

	public void einstellungen_weiter1(View v) { // View1
		Init.db.updateRecordEinstellungen(1, mp_typ);
    	Toast toast = ToastFactory.getToast(this, "Gespeichert!");
    	toast.show();
    	activityFinish();
    }
	
	public void einstellungen_weiter2(View v) { // View2
    	Init.db.updateRecordEinstellungen(1, mp_typ);
    	Toast toast = ToastFactory.getToast(this, "Gespeichert!");
    	toast.show();
    	
		Intent intent = new Intent(Einstellungen.this, Masterpasswort.class);
    	intent.putExtra("view", 2);
        startActivity(intent);
        
        activityFinish();
    }
    
}
