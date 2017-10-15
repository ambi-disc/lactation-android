package org.lactor.consultant;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import org.lactor.consultant.api.AccountRequest;
import org.lactor.consultant.api.LactorAPIHelper;
import org.lactor.consultant.api.LoginReturn;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AccountCreationActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText firstname;
    private EditText lastname;
    private EditText password;
    private EditText organization;
    private EditText email;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_creation);
        findViewById(R.id.button_submit).setOnClickListener(this);

        firstname = (EditText) findViewById(R.id.firstname);
        lastname = (EditText) findViewById(R.id.lastname);
        password = (EditText) findViewById(R.id.password);
        organization = (EditText) findViewById(R.id.organization);
        email = (EditText) findViewById(R.id.email);

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.login_button:
                LactorAPIHelper.getInstance().createAccount(
                        new AccountRequest(
                                firstname.getText().toString(),
                            lastname.getText().toString(),
                            organization.getText().toString(),
                            password.getText().toString()
                        )
                ).enqueue(new Callback<LoginReturn>() {
                    @Override
                    public void onResponse(Call<LoginReturn> call, Response<LoginReturn> response) {
                        System.out.println("Account Created!");

                        //TODO
                    }

                    @Override
                    public void onFailure(Call<LoginReturn> call, Throwable t) {

                    }
                });


        }

    }
}
