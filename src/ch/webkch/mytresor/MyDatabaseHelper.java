package ch.webkch.mytresor;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "mytresor";

    private static final int DATABASE_VERSION = 2;

    private static final String TABLE_SYSTEM = "System (_id INTEGER PRIMARY KEY, gestartet BOOLEAN DEFAULT false, uid TEXT, uid_c TEXT DEFAULT null);";
    private static final String TABLE_EINSTELLUNGEN = "Einstellungen (_id INTEGER PRIMARY KEY, mp_typ INTEGER DEFAULT 0);";

    public MyDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

	@Override
	public void onCreate(SQLiteDatabase database)
	{
		database.execSQL("PRAGMA encoding = \"UTF-8\"");
		database.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_SYSTEM);
		database.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_EINSTELLUNGEN);
	}

	@Override
	public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion)
	{
        database.execSQL("DROP TABLE IF EXISTS System");
        database.execSQL("DROP TABLE IF EXISTS Einstellungen");
        onCreate(database);
	}
}
