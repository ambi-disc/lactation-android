package org.lactor.consultant;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import org.lactor.consultant.api.LactorAPIHelper;
import org.lactor.consultant.api.LoginRequest;
import org.lactor.consultant.api.LoginReturn;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText emailEditText;
    private EditText passwordEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        findViewById(R.id.register_button).setOnClickListener(this );
        findViewById(R.id.login_button).setOnClickListener(this );

        emailEditText = (EditText) findViewById(R.id.email_edittext);
        passwordEditText = (EditText) findViewById(R.id.password);
    }

    public void startAccountCreationActivity(){
        Intent startNewActivity = new Intent(this, AccountCreationActivity.class);
        startActivity(startNewActivity);


    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.register_button:
                startAccountCreationActivity();
                break;
            case R.id.login_button:
                LactorAPIHelper.getInstance().login(
                        new LoginRequest(
                                emailEditText.getText().toString(),
                                passwordEditText.getText().toString()
                        )
                ).enqueue(new Callback<LoginReturn>() {
                    @Override
                    public void onResponse(Call<LoginReturn> call, Response<LoginReturn> response) {
                        if (!response.isSuccessful()) {
                            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                                    getApplicationContext());

                            // set title
                            alertDialogBuilder.setTitle("Invalid Login");

                            // set dialog message
                            alertDialogBuilder
                                    .setMessage("Either Email or Password is Invalid!")
                                    .setCancelable(false)
                                    .setPositiveButton("Ok",new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog,int id) {
                                            // if this button is clicked, close
                                            // current activity
                                            dialog.cancel();
                                        }
                                    })
                                    ;

                            // create alert dialog
                            AlertDialog alertDialog = alertDialogBuilder.create();

                            // show it
                            alertDialog.show();

                        }else {
                            System.out.println("You are logged in");

                            //we need to finish this TODO
                        }
                    }

                    @Override
                    public void onFailure(Call<LoginReturn> call, Throwable t) {

                    }
                });




        }
    }
}
