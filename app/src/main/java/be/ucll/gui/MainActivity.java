package be.ucll.gui;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    DatabaseActivity dbo;  //comment :p
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("temp log", "*** START SHOWING TESTING DATA ***");

        dbo = new DatabaseActivity(this);
        DatabaseInitialisation dbi = new DatabaseInitialisation(dbo);


        int usersCount = dbo.getUsersCount();
        Log.d("temp log", "There are " + usersCount + " users in the gebruikers TABLE!");

        UserObject user = dbo.GetUserFromDb("r0488080");
        Log.d("test user", user.getNaam());
        Log.d("test user", user.getFunctie());
        Log.d("test user", user.getDepartement());
        Log.d("test user", user.getPasswoord());
        Log.d("test user", String.valueOf(user.get_id()));

        int locationsCount = dbo.getLocationsCount();
        Log.d("temp log", "There are " + locationsCount + " locations in the locaties TABLE!");

        LocationObject location = dbo.GetLocationFromDb(7);
        Log.d("test location", location.getNaam());
        Log.d("test location", location.getInfo());
        Log.d("test location", String.valueOf(location.getLatitude()));
        Log.d("test location", String.valueOf(location.getLongitude()));
        Log.d("test location", String.valueOf(location.getRadius()));
        Log.d("test location", String.valueOf(location.getCampus()));

        UserObject user2 = dbo.GetUserFromDb("r0488080");
    if (user instanceof UserObject) {
        Log.d("test x user:   ", user.getNaam());
    }else {
        Log.d("test x user", "failed to get user".concat(user.toString()) );
    }
        Log.d("temp log", "*** END SHOWING TESTING DATA ***");

    } //END OnCreate()





}
