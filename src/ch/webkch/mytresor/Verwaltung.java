package ch.webkch.mytresor;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

public class Verwaltung extends Activity {
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verwaltung);
       
    }
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
	}
	
	private void activityFinish()
	{
		this.finish();
	}
	
	public boolean onKeyDown(int keycode, KeyEvent event) {
	    if (keycode == KeyEvent.KEYCODE_BACK) {
	    	AlertDialog.Builder builder = new AlertDialog.Builder(this);
	        builder.setMessage(R.string.verwaltung_dialog)
               .setPositiveButton(R.string.verwaltung_dialog_true, new DialogInterface.OnClickListener() {
                   public void onClick(DialogInterface dialog, int id) {
                	   activityFinish();
                   }
               })
               .setNegativeButton(R.string.verwaltung_dialog_false, new DialogInterface.OnClickListener() {
                   public void onClick(DialogInterface dialog, int id) {
                   }
               });
	        builder.create();
	        builder.show();
	        return false;
	    }
	    return super.onKeyDown(keycode, event);
	}
	
	
	public void verwaltung_einstellungen(View v) {
    	Intent intent = new Intent(Verwaltung.this, Einstellungen.class);
    	intent.putExtra("view", 1);
        startActivity(intent);
    }
	
	public void verwaltung_neuereintrag(View v) {
    	Intent intent = new Intent(Verwaltung.this, NeuerEintrag.class);
        startActivity(intent);
    }
	
}
