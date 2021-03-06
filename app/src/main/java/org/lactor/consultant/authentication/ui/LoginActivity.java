package org.lactor.consultant.authentication.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import org.lactor.consultant.R;
import org.lactor.consultant.authentication.webrequests.LoginResult;
import org.lactor.consultant.core.webrequests.LactorApiHelper;
import org.lactor.consultant.authentication.webrequests.LoginRequest;
import org.lactor.consultant.homepage.ui.MainActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText mEmailEditText;
    private EditText mPasswordEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        findViewById(R.id.register_button).setOnClickListener(this);
        findViewById(R.id.login_button).setOnClickListener(this);

        mEmailEditText = (EditText) findViewById(R.id.email_edittext);
        mPasswordEditText = (EditText) findViewById(R.id.password);

//        System.out.println("*************************************************");
//        System.out.println("************ ON_CREATE ************");
//        System.out.println("*************************************************");
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
                LactorApiHelper.getInstance().login(
                        new LoginRequest(
                                mEmailEditText.getText().toString(),
                                mPasswordEditText.getText().toString()
                        )
                ).enqueue(new Callback<LoginResult>() {
                    @Override
                    public void onResponse(Call<LoginResult> call, Response<LoginResult> response) {
                        if (!response.isSuccessful() || response.body().isSuccess()) {
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

                        } else {
                            System.out.println("You are logged in");

                            SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("com.lactor.android", 0);
                            sharedPreferences.edit().putString("authToken", response.body().authToken).apply();

                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            intent.putExtra(
                                    MainActivity.EXTRA_LOGIN_TOKEN,
                                    response.body().getAuthToken()
                            );
                            startActivity(intent);
                        }
                    }

                    @Override
                    public void onFailure(Call<LoginResult> call, Throwable t) {

                    }
                });
        }
    }
}
