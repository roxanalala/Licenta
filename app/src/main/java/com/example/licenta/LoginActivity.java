package com.example.licenta;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {
    private EditText userEditText,passwordEditText;
    private Button loginButton;
    private DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        // initializing all our variables.
        userEditText = findViewById(R.id.idUserNameText);
        passwordEditText = findViewById(R.id.idPasswordText);
        loginButton = findViewById(R.id.idLoginButton);

        // creating a new dbhandler class
        // and passing our context to it.
        dbHandler = new DBHandler(LoginActivity.this);

        // below line is to add on click listener for our add course button.
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // below line is to get data from all edit text fields.
                String userText = userEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                ArrayList<Users> usersArrayList= dbHandler.readUsers();

                for(Users us : usersArrayList) {
                    if (us.getUsername().equals(userText) && us.getPassword().equals(password)) {

                    }
                }
                // validating if the text fields are empty or not.

            }
        });
    }
}
