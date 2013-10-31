package ch.webkch.mytresor;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class MyDataBaseHandler {
	
	/*
    **********************************************
    *** VAR
    **********************************************
    */
	
	// DB -->
	private MyDatabaseHelper dbHelper;
	public static SQLiteDatabase database;
		// Table-->
		public final static String EMP_ID = "_id";
		// Table System-->
		public final static String EMP_S_TABLE = "System";
		public final static String EMP_S_GESTARTET = "gestartet";
		public final static String EMP_S_UID = "uid";
		public final static String EMP_S_UID_C = "uid_c";
		// Table Einstellungen-->
		public final static String EMP_E_TABLE = "Einstellungen";
		public final static String EMP_E_MPTYP = "mp_typ";
		// <-- Table
	// <-- DB
		
	/*
    **********************************************
    *** DEFAULT METHODE
    **********************************************
    */
		
	public MyDataBaseHandler(Context context)
	{
		dbHelper = new MyDatabaseHelper(context);  
        database = dbHelper.getWritableDatabase();  
	}
		
	/*
    **********************************************
    *** DB
    **********************************************
    */
    
    public long insertRecordSystem(boolean gestartet, String uid)
    {  
	   ContentValues values = new ContentValues();
	   values.put(EMP_S_GESTARTET, gestartet);
	   values.put(EMP_S_UID, uid);
	   return database.insert(EMP_S_TABLE, null, values);
	}
    
    public Cursor selectRecordSystem()
	{
		String[] cols = new String[] {EMP_ID, EMP_S_GESTARTET, EMP_S_UID, EMP_S_UID_C};  
		Cursor cursor = database.query(true, EMP_S_TABLE, cols, null, null, null, null, null, null);  
		if (cursor != null) {  
			cursor.moveToFirst();  
		}  
		return cursor;
	}
    
    public long updateRecordSystem(int id, String uid_c)
    {  
    	String where = "_id=" + id;
    	ContentValues values = new ContentValues();
 	   	values.put(EMP_S_UID_C, uid_c);
 	    return database.update(EMP_S_TABLE, values, where, null);
 	}
    
    
    
    public long insertRecordEinstellungen(int mp_typ)
    {  
 	   ContentValues values = new ContentValues();
 	   values.put(EMP_E_MPTYP, 0);
 	   return database.insert(EMP_E_TABLE, null, values);
 	}
    
    public Cursor selectRecordEinstellungen()
	{
		String[] cols = new String[] {EMP_ID, EMP_E_MPTYP};  
		Cursor cursor = database.query(true, EMP_E_TABLE, cols, null, null, null, null, null, null);  
		if (cursor != null) {  
			cursor.moveToFirst();  
		}  
		return cursor;
	}
    
    public long updateRecordEinstellungen(int id, int mp_typ)
    {  
    	String where = "_id=" + id;
    	ContentValues values = new ContentValues();
 	   	values.put(EMP_E_MPTYP, mp_typ);
 	    return database.update(EMP_E_TABLE, values, where, null);
 	}

	
}
