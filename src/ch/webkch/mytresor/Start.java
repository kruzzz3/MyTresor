package ch.webkch.mytresor;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.text.Html;
import android.view.KeyEvent;
import android.view.Menu;
import android.widget.TextView;
import android.view.*;

public class Start extends Activity {

	/*
    **********************************************
    *** VAR
    **********************************************
    */
	
	private int view;
	
	// #13B6EA
	private String wasisteinsicherespasswort = "<p><b>Was ist ein sicheres Passwort?</b></p><p>Passwörter sind oft der einzige Schutzmechanismus für Ihre privaten Daten. Die einfachste und gängigste Methode Ihr Passwort herauszufinden, ist zu raten. Deshalb sollten Sie niemals ein real existierendes Wort als Passwort verwenden. Auch Namen der Liebsten, der Familie oder der Haustiere sollten niemals verwendet werden. Hier können Sie sich das Passwort gleich sparen, denn ausreichende Sicherheit für Ihre Daten vor Hackerangriffen bieten diese Passwörter leider nicht, da ein Computer tausende von Passwörter in sekundenschnelle ausprobieren kann und Ihres somit schnell herausfindet.</p><p>Lautet ein aktuelles Passwort von Ihnen &quot;123456&quot;, &quot;Passwort&quot; oder &quot;abc123&quot;? Dann gehören Sie zur grossen Masse an Personen, welche MyTresor unbedingt verwenden sollten.</p><p>Die meist verwendeten Passwörter:<br>- 123456<br>- passwort<br>- abc123<br>- qwertz<br>- &quot;Vorname&quot;<br></p><p>Was ist ein sicheres Passwort?<br>Etwas sicherer als reine Buchstabenpasswörter sind zwar Passwörter kombiniert aus Buchstaben und Zahlen, aber auch diese Kombinationen sind immer noch sehr leicht zu knacken! Seien Sie kreativ bei der Wahl Ihrer Passwörter und umgehen Sie so das Risiko eines Datenverlustes!Das sicherste Passwort ist eine rein zufällige Aneinanderreihung von Zeichen, bestehend aus allen Zeichen und Sonderzeichen, die Ihre Tastatur hergibt. Zudem sollte das Passwort mindestes aus acht Zeichen bestehen.</p><p>Ein sicheres Passwort wäre zum Beispiel &quot;c:y?Mi7)9&quot;.</p><p>Mit MyTresor können Sie endlich komplexe Passwörter verwenden ohne sich eines zu merken und den Hackern den Kampf ansagen.</p>";
	
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
        	setContentView(R.layout.activity_start1);
        }
        if (view == 2)
        {
        	setContentView(R.layout.activity_start2);
        }
        TextView start_wasisteinsicherespasswort = (TextView)findViewById(R.id.start_wasisteinsicherespasswort);
        start_wasisteinsicherespasswort.setText(Html.fromHtml(wasisteinsicherespasswort));
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
    *** Buttons
    **********************************************
    */
    
    public void start_weiter(View v) { // View1
    	Intent intent = new Intent(Start.this, Einstellungen.class);
    	intent.putExtra("view", 2);
        startActivity(intent);
        activityFinish();
    }

    public void start_zuruck(View v) { // View2
    	activityFinish();
    }
}
