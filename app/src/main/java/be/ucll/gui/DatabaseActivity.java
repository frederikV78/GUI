package be.ucll.gui;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.IntegerRes;
import android.util.Log;

import java.util.ArrayList;

import static android.database.sqlite.SQLiteDatabase.*;

/**
 * Created by mrx on 11/25/2016.
 */

public class DatabaseActivity {

    //CONSTRUCTOR for main class
    public DatabaseActivity(Context context){
        dbHelper = new DBHelper(context, DB_NAME, null, DB_VERSION);
        DatabaseInitialisation di = new DatabaseInitialisation(context);
        
    }

    //DATABASE constants
    public static final String DB_NAME = "guidb.db";
    public static final int DB_VERSION = 1;

    //TABLE constants:
        //TABLE=gebruikers
    public static final String USER_TABLE = "gebruikers";

    public static final String USER_ID = "_id";
    public static final int USER_ID_COL = 0;

    public static final String USER_RNUMMER = "rNummer";
    public static final int USER_RNUMMER_COL = 1;

    public static final String USER_NAME = "naam";
    public static final int USER_NAME_COL = 2;

    public static final String USER_PASSWORD = "passwoord";
    public static final int USER_PASSWORD_COL = 3;

    public static final String USER_DESCRIPTION = "functie";
    public static final int USER_DESCRIPTION_COL = 4;

    public static final String USER_DEPARTMENT = "departement";
    public static final int USER_DEPARTMENT_COL = 5;


        //TABLE=locaties
    public static final String LOCATION_TABLE = "locaties";

    public static final String LOCATION_ID = "_id";
    public static final int LOCATION_ID_COL = 0;

    public static final String LOCATION_NAME = "naam";
    public static final int LOCATION_NAME_COL = 1;

    public static final String LOCATION_INFO = "info";
    public static final int LOCATION_INFO_COL = 2;

    public static final String LOCATION_LATITUDE = "latitude";
    public static final int LOCATION_LATITUDE_COL = 3;

    public static final String LOCATION_LONGITUDE = "longitude";
    public static final int LOCATION_LONGITUDE_COL = 4;

    public static final String LOCATION_RADIUS = "longitude";
    public static final int LOCATION_RADIUS_COL = 4;

    public static final String LOCATION_CAMPUS = "campus";
    public static final int LOCATION_CAMPUS_COL = 5;

    //CREATE statements
    public static final String CREATE_USER_TABLE =
            "CREATE TABLE " + USER_TABLE + " (" +
                    USER_ID + " INTEGER PRIMARY KEY AUTO_INCREMENT, " +
                    USER_RNUMMER + " TEXT NOT NULL UNIQUE, " +
                    USER_NAME + " TEXT, " +
                    USER_PASSWORD + " TEXT, " +
                    USER_DESCRIPTION + " TEXT, " +
                    USER_DEPARTMENT + " TEXT);";

    public static final String CREATE_LOCATION_TABLE =
            "CREATE TABLE " + LOCATION_TABLE + " (" +
                    LOCATION_ID + " INTEGER PRIMARY KEY AUTO_INCREMENT, " +
                    LOCATION_NAME + " TEXT NOT NULL UNIQUE, " +
                    LOCATION_INFO + " TEXT, " +
                    LOCATION_LATITUDE + " REAL, " +
                    LOCATION_LONGITUDE + " REAL, " +
                    LOCATION_RADIUS + " INTEGER" +
                    LOCATION_CAMPUS + " INTEGER);";

    //DROP TABLE statements
    public static final String DROP_USER_TABLE = "DROP TABLE IF EXISTS " + USER_TABLE;
    public static final String DROP_LOCATION_TABLE = "DROP TABLE IF EXISTS " + LOCATION_TABLE;



    //PUBLIC FUNCTIONS
    private UserObject user;
    private LocationObject location;
    private SQLiteDatabase db;
    private DBHelper dbHelper;

//DBHelper CLASS
    private static class DBHelper extends SQLiteOpenHelper{

        public DBHelper(Context context, String name, CursorFactory factory, int version){
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(CREATE_USER_TABLE);
            db.execSQL(CREATE_LOCATION_TABLE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.d("GUIdb","Upgrading db from version " + oldVersion + "to " + newVersion);
            db.execSQL(DatabaseActivity.DROP_USER_TABLE);
            db.execSQL(DatabaseActivity.DROP_LOCATION_TABLE);
            onCreate(db);
        }
    }
//END DBHelper CLASS

    //private methods
    private void openReadableDB(){
        db = dbHelper.getReadableDatabase();
    }
    private void openWriteableDB(){
        db = dbHelper.getWritableDatabase();
    }
    private void closeDB(){
        if (db != null){
            db.close();
        }
    }

    // public methods
    public boolean AddUserToDb(UserObject user){
        boolean succes = false;

        ContentValues cv = new ContentValues();
        cv.put(USER_ID, user.get_id());
        cv.put(USER_RNUMMER, user.getrNummer());
        cv.put(USER_NAME, user.getNaam());
        cv.put(USER_PASSWORD, user.getPasswoord());
        cv.put(USER_DESCRIPTION, user.getFunctie());
        cv.put(USER_DEPARTMENT, user.getDepartement());

        this.openWriteableDB();
        long rowID = db.insert(USER_TABLE, null, cv);
        this.closeDB();

        if (rowID >= 0){
            succes = true;
        }
        return succes;
    }
    public boolean DeleteUserFromDb(UserObject user){
        boolean succes = false;

        String where = USER_NAME + "= ?";
        String[] whereArgs = {user.getNaam()};

        this.openWriteableDB();
        int rowCount = db.delete(USER_TABLE, where, whereArgs);
        this.closeDB();

        if (rowCount >= 0){
            succes = true;
        }
        return succes;
    }

    public boolean AddLocationToDb(LocationObject location){
        boolean succes = false;

        ContentValues cv = new ContentValues();
        cv.put(LOCATION_ID, location.get_id());
        cv.put(LOCATION_NAME, location.getNaam());
        cv.put(LOCATION_INFO, location.getInfo());
        cv.put(LOCATION_LATITUDE, location.getLatitude());
        cv.put(LOCATION_LONGITUDE, location.getLongitude());
        cv.put(LOCATION_RADIUS, location.getRadius());
        cv.put(LOCATION_CAMPUS, location.getCampus());

        this.openWriteableDB();
        long rowID = db.insert(LOCATION_TABLE, null, cv);
        this.closeDB();

        if (rowID >= 0){
            succes = true;
        }
        return succes;
    }
    public boolean DeleteLocationFromDb(LocationObject location){
        boolean succes = false;

        String where = LOCATION_NAME + "= ?";
        String[] whereArgs = {location.getNaam()};

        this.openWriteableDB();
        int rowCount = db.delete(LOCATION_TABLE, where, whereArgs);
        this.closeDB();

        if (rowCount >= 0){
            succes = true;
        }
        return succes;
    }

    public UserObject GetUserFromDb(String userRNummer){
        user = new UserObject();

        String where = USER_RNUMMER + "= ?";
        String[] whereArgs = {String.valueOf(userRNummer)};
        String[] columns = {String.valueOf(USER_NAME_COL),String.valueOf(USER_PASSWORD_COL),
                String.valueOf(USER_DESCRIPTION_COL),String.valueOf(USER_DEPARTMENT_COL)};

        this.openReadableDB();
        Cursor cursor = db.query(USER_TABLE,columns,where,whereArgs,null,null,null);
        cursor.moveToFirst();
        user = getUserFromCursor(cursor);
        if (cursor != null)cursor.close();
        this.closeDB();
        return user;
    }
    private static UserObject getUserFromCursor(Cursor cursor){
        if (cursor == null || cursor.getCount() == 0){
            return null;
        }
        else{
            try{
                UserObject user = new UserObject(
                        cursor.getInt(USER_ID_COL),
                        cursor.getString(USER_RNUMMER_COL),
                        cursor.getString(USER_NAME_COL),
                        cursor.getString(USER_PASSWORD_COL),
                        cursor.getString(USER_DESCRIPTION_COL),
                        cursor.getString(USER_DEPARTMENT_COL)
                );
                return user;
            }
            catch(Exception e){
                return null;
            }
        }
    }

    public ArrayList<LocationObject> GetLocationsFromDb(){
        location = new LocationObject();

        String where = LOCATION_ID + ">= ?";
        String[] whereArgs = {"0"};

        this.openReadableDB();
        Cursor cursor = db.query(LOCATION_TABLE,null,where,whereArgs,null,null,null);
        ArrayList<LocationObject> locations = new ArrayList<LocationObject>();
        while(cursor.moveToNext()){
            locations.add(getLocationFromCursor(cursor));
        }
        if (cursor != null)cursor.close();
        this.closeDB();
        return locations;
    }
    private static LocationObject getLocationFromCursor(Cursor cursor){ //TODO
        if (cursor == null || cursor.getCount() == 0){
            return null;
        }
        else{
            try{
                LocationObject location = new LocationObject(
                        cursor.getInt(LOCATION_ID_COL),
                        cursor.getString(LOCATION_NAME_COL),
                        cursor.getString(LOCATION_INFO_COL),
                        cursor.getDouble(LOCATION_LATITUDE_COL),
                        cursor.getDouble(LOCATION_LONGITUDE_COL),
                        cursor.getInt(LOCATION_RADIUS_COL),
                        cursor.getInt(LOCATION_CAMPUS_COL)
                );
                return location;
            }
            catch(Exception e){
                return null;
            }
        }
    }







}
