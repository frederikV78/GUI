package be.ucll.gui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Gebruiker on 16/12/2016.
 */

public class LoginActivity extends AppCompatActivity {

    Button buttonLogin;


    EditText TextUsername;
    EditText TextPassword;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextUsername = (EditText) findViewById(R.id.TextUsername);
        TextPassword = (EditText) findViewById(R.id.TextPassword);
        buttonLogin = (Button) findViewById(R.id.buttonLogin);

        final DatabaseActivity databaseActivity = new DatabaseActivity(this);

        //DatabaseInitialisation databaseInitialisation = new DatabaseInitialisation(databaseActivity);

        buttonLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //
                //String nummer = "abc";
                //Object getUser[] = {nummer, nummer, nummer, nummer};

                String username = TextUsername.getText().toString();

                UserObject getUser = new UserObject();
                getUser = databaseActivity.GetUserFromDb(username);

                //Toast.makeText(getApplicationContext(), "" + getUser, Toast.LENGTH_LONG).show();


                if (TextUsername.getText().toString().isEmpty() && TextPassword.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Geef een gebruikersnaam en wachtwoord in", Toast.LENGTH_LONG).show();
                }
                else if(TextUsername.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(), "Geef een gebruikersnaam in", Toast.LENGTH_LONG).show();
                }
                else if(TextPassword.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Geef een wachtwoord in", Toast.LENGTH_LONG).show();
                }
                else{
                    if (getUser != null) {
                        if (TextUsername.getText().toString().equals(getUser.getrNummer().toString())) {


                            if (TextPassword.getText().toString().equals(getUser.getPasswoord().toString())) {

                                Toast.makeText(getApplicationContext(), "Login succesvol, welkom " + getUser.getNaam().toString() + "!", Toast.LENGTH_LONG).show();


                                startActivity(new Intent(getApplicationContext(), LoggedActivity.class));

                            } else {
                                Toast.makeText(getApplicationContext(), "Gebruikersnaam en/of wachtwoord is foutief", Toast.LENGTH_LONG).show();
                            }


                        }
                    }else{
                        Toast.makeText(getApplicationContext(), "Gebruikersnaam en/of wachtwoord is foutief", Toast.LENGTH_LONG).show();
                    }
                }

            }

        });
    }
}
