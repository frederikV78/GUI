package be.ucll.gui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Gebruiker on 16/12/2016.
 */

public class LoggedActivity extends AppCompatActivity {

    Button buttonLogOut;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged);

        buttonLogOut = (Button) findViewById(R.id.buttonLogOut);

        buttonLogOut.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "U bent uitgelogd", Toast.LENGTH_LONG).show();


                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
            }
        });
    }
}
