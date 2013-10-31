package ch.webkch.mytresor;

import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnHoverListener;
import android.view.View.OnTouchListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

public class Masterpasswort extends Activity implements OnClickListener {
	
	/*
    **********************************************
    *** VAR
    **********************************************
    */
	
	private int view;
	
	private ArrayList<ImageView> mp_Buttons;
	private ArrayList<String> mp_ButtonsTags;
	private ArrayList<Integer> mp_ButtonsStyleNumber;
	
	private TextView mp_preview;
	
	public static CryptFactory cf;
	
	/*
    **********************************************
    *** DEFAULT METHODE
    **********************************************
    */
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		System.out.println("1");
		manageBundle(savedInstanceState);
		System.out.println("2");
        if (view == 1)
        {
        	setContentView(R.layout.activity_masterpasswort1);
        }
        if (view == 2)
        {
        	setContentView(R.layout.activity_masterpasswort2);
        }
        System.out.println("3");

		mp_preview = (TextView) findViewById(R.id.mp_preview);
		
		initMPButton();
		initTagList();
		manageMPButtonSize();
		manageMPButtonTagAndListener();
		
		mp_ButtonsStyleNumber();
		manageMPButtonStyle(0);
		
		
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		resetText();
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
	        builder.setMessage(R.string.mp_dialog)
               .setPositiveButton(R.string.mp_dialog_true, new DialogInterface.OnClickListener() {
                   public void onClick(DialogInterface dialog, int id) {
                	   activityFinish();
                	   System.exit(0);
                   }
               })
               .setNegativeButton(R.string.mp_dialog_false, new DialogInterface.OnClickListener() {
                   public void onClick(DialogInterface dialog, int id) {
                   }
               });
	        // Create the AlertDialog object and return it
	        builder.create();
	        builder.show();
	        return false;
	    }
	    return super.onKeyDown(keycode, event);
	}
	
	/*
    **********************************************
    *** INIT METHODE
    **********************************************
    */
	
	private void initMPButton()
	{
		mp_Buttons = new ArrayList<ImageView>();
		
		mp_Buttons.add((ImageView) findViewById(R.id.mp_button01));
		mp_Buttons.add((ImageView) findViewById(R.id.mp_button02));
		mp_Buttons.add((ImageView) findViewById(R.id.mp_button03));
		mp_Buttons.add((ImageView) findViewById(R.id.mp_button04));
		mp_Buttons.add((ImageView) findViewById(R.id.mp_button05));
		mp_Buttons.add((ImageView) findViewById(R.id.mp_button06));
		mp_Buttons.add((ImageView) findViewById(R.id.mp_button07));
		mp_Buttons.add((ImageView) findViewById(R.id.mp_button08));
		mp_Buttons.add((ImageView) findViewById(R.id.mp_button09));
		mp_Buttons.add((ImageView) findViewById(R.id.mp_button10));
		mp_Buttons.add((ImageView) findViewById(R.id.mp_button11));
		mp_Buttons.add((ImageView) findViewById(R.id.mp_button12));
		mp_Buttons.add((ImageView) findViewById(R.id.mp_button13));
		mp_Buttons.add((ImageView) findViewById(R.id.mp_button14));
		mp_Buttons.add((ImageView) findViewById(R.id.mp_button15));
		mp_Buttons.add((ImageView) findViewById(R.id.mp_button16));
	}
	
	private void initTagList()
	{
		mp_ButtonsTags = new ArrayList<String>();
		mp_ButtonsTags.add("a");
		mp_ButtonsTags.add("b");
		mp_ButtonsTags.add("c");
		mp_ButtonsTags.add("d");
		mp_ButtonsTags.add("e");
		mp_ButtonsTags.add("f");
		mp_ButtonsTags.add("g");
		mp_ButtonsTags.add("h");
		mp_ButtonsTags.add("i");
		mp_ButtonsTags.add("j");
		mp_ButtonsTags.add("k");
		mp_ButtonsTags.add("l");
		mp_ButtonsTags.add("m");
		mp_ButtonsTags.add("n");
		mp_ButtonsTags.add("o");
		mp_ButtonsTags.add("p");
	}
	
	private void manageMPButtonSize()
	{
		DisplayMetrics metrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(metrics);

		int s = metrics.widthPixels / 4;
		int padding = s/30;
		for(int i = 0; i < mp_Buttons.size(); i++)
		{
			mp_Buttons.get(i).setLayoutParams(new LinearLayout.LayoutParams(s, s));
			mp_Buttons.get(i).setOnClickListener(this);
			mp_Buttons.get(i).setOnTouchListener(new OnTouchListener() {
				
				public boolean onTouch(View v, MotionEvent event) {
					ImageView imageView = (ImageView) v;
					if (event.getAction() == 0)
					{
						imageView.setBackgroundColor(getResources().getColor(R.color.c_ScreenBackgroundDark));
					}
					if (event.getAction() == 1)
					{
						imageView.setBackgroundColor(getResources().getColor(R.color.c_ScreenBackgroundLight));
					}
					return false;
				}
			});
			mp_Buttons.get(i).setPadding(padding, 0, padding, 0);
			//mp_Buttons.get(i).setBackgroundColor(mp_ButtonsColor.get(i));
		}
	}
	
	private void manageMPButtonTagAndListener()
	{
		for(int i = 0; i < mp_Buttons.size(); i++)
		{
			mp_Buttons.get(i).setOnClickListener(this);
			mp_Buttons.get(i).setTag(mp_ButtonsTags.get(i));
		}
	}
	
	/*
    **********************************************
    *** STYLE METHODE
    **********************************************
    */
	
	private void manageMPButtonStyle(int style)
	{
		ArrayList<Integer> currentStyle = mp_ButtonsStyleNumber;
		
		for(int i = 0; i < mp_Buttons.size(); i++)
		{
			mp_Buttons.get(i).setImageResource(currentStyle.get(i));
		}
	}
	
	private void mp_ButtonsStyleNumber()
	{
		mp_ButtonsStyleNumber = new ArrayList<Integer>();
		mp_ButtonsStyleNumber.add(R.drawable.btn_number_01);
		mp_ButtonsStyleNumber.add(R.drawable.btn_number_02);
		mp_ButtonsStyleNumber.add(R.drawable.btn_number_03);
		mp_ButtonsStyleNumber.add(R.drawable.btn_number_04);
		mp_ButtonsStyleNumber.add(R.drawable.btn_number_05);
		mp_ButtonsStyleNumber.add(R.drawable.btn_number_06);
		mp_ButtonsStyleNumber.add(R.drawable.btn_number_07);
		mp_ButtonsStyleNumber.add(R.drawable.btn_number_08);
		mp_ButtonsStyleNumber.add(R.drawable.btn_number_09);
		mp_ButtonsStyleNumber.add(R.drawable.btn_number_10);
		mp_ButtonsStyleNumber.add(R.drawable.btn_number_11);
		mp_ButtonsStyleNumber.add(R.drawable.btn_number_12);
		mp_ButtonsStyleNumber.add(R.drawable.btn_number_13);
		mp_ButtonsStyleNumber.add(R.drawable.btn_number_14);
		mp_ButtonsStyleNumber.add(R.drawable.btn_number_15);
		mp_ButtonsStyleNumber.add(R.drawable.btn_number_16);
	}
	
	/*
    **********************************************
    *** ELSE METHODE
    **********************************************
    */
	
	private void setText(String nr)
	{
		mp_preview.setText(mp_preview.getText() + nr);
	}
	
	private void resetText()
	{
		mp_preview.setText("");
	}
	
	private String getKey()
	{
		return mp_preview.getText().toString();
	}

	@Override
	public void onClick(View v)
	{
		setText(v.getTag().toString());
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
    *** Buttons
    **********************************************
    */
    
	public void mp_weiter1(View v) {
		System.out.println("mp_weiter1");
		cf = new CryptFactory(getKey());
		Cursor cursor = Init.db.selectRecordSystem();
		String uid1 = cursor.getString(cursor.getColumnIndex(MyDataBaseHandler.EMP_S_UID));
		String uid_temp = cursor.getString(cursor.getColumnIndex(MyDataBaseHandler.EMP_S_UID_C));
		String uid2 = cf.decrypt(uid_temp);
		if (uid1.equals(uid2))
		{
			Intent intent = new Intent(Masterpasswort.this, Verwaltung.class);
			startActivity(intent);
		}
		else
		{
			resetText();
			Toast toast = ToastFactory.getToast(this, "Falsches Passwort!");
			toast.show();
		}
		cursor.close();
    }
	
	public void mp_weiter2(View v) {
		System.out.println("mp_weiter2");
		cf = new CryptFactory(getKey());
		
		Cursor cursor = Init.db.selectRecordSystem();
		String uid = cursor.getString(cursor.getColumnIndex(MyDataBaseHandler.EMP_S_UID));
		
		System.out.println("uid="+uid);
		String e = cf.encrypt(uid);
		System.out.println("uid_c="+e);
		
		Init.db.updateRecordSystem(1, e);
    	ToastFactory.getToast(this, "Gespeichert!");
    	
    	cursor.close();
    	
    	Intent intent = new Intent(Masterpasswort.this, Init.class);
        startActivity(intent);
        activityFinish();
    }
	
	public void mp_info(View v) {
    	Intent intent = new Intent(Masterpasswort.this, Start.class);
    	intent.putExtra("view", 2);
        startActivity(intent);
    }

}
