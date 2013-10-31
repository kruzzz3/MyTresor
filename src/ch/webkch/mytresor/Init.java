package ch.webkch.mytresor;

import android.os.Bundle;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.telephony.TelephonyManager;
import android.text.Html;
import android.view.Menu;
import android.widget.TextView;

public class Init extends Activity {
	
	/*
    **********************************************
    *** VAR
    **********************************************
    */
	
	public static MyDataBaseHandler db;
	
	/*
    **********************************************
    *** DEFAULT METHODE
    **********************************************
    */
		
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db = new MyDataBaseHandler(this);
        way();
    }
    
    /*
	**********************************************
	*** Erster oder Weiterer Start
	**********************************************
	*/
    
    private void way()
    {
    	Cursor cursor = db.selectRecordSystem();
    	if (db.selectRecordSystem().getCount() < 1)
    	{
    		way1();
    	}
    	else if (cursor.getBlob(cursor.getColumnIndex(MyDataBaseHandler.EMP_S_UID_C)) == null)
        {
    		way1();
        }
        else
        {
        	Intent intent = new Intent(Init.this, Masterpasswort.class);
        	intent.putExtra("view", 1);
            startActivity(intent);
        }
    	cursor.close();
    }
    
    private void way1()
    {
    	if (db.selectRecordSystem().getCount() < 1)
        {
        	TelephonyManager tManager = (TelephonyManager) this.getSystemService(Context.TELEPHONY_SERVICE);
        	db.insertRecordSystem(true, tManager.getDeviceId());
        }
        if (db.selectRecordEinstellungen().getCount() < 1)
        {
        	db.insertRecordEinstellungen(0);
        }
        Intent intent = new Intent(Init.this, Start.class);
        intent.putExtra("view", 1);
        startActivity(intent);
    }
    
}
