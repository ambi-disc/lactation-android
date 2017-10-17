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
    private EditText mFirstNameEditText;
    private EditText mLastNameEditText;
    private EditText mPasswordEditText;
    private EditText mOrganizationEditText;
    private EditText mEmailEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_creation);
        findViewById(R.id.button_submit).setOnClickListener(this);

        firstname = (EditText) findViewById(R.id.mFirstNameEditText);
        lastname = (EditText) findViewById(R.id.mLastNameEditText);
        password = (EditText) findViewById(R.id.mPasswordEditText);
        organization = (EditText) findViewById(R.id.mOrganizationEditText);
        email = (EditText) findViewById(R.id.email);

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.login_button:
                LactorAPIHelper.getInstance().createAccount(
                        new AccountRequest(
                                mFirstNameEditTExt.getText().toString(),
                            mLastNameEditText.getText().toString(),
                            mOrganizationEditText.getText().toString(),
                            mPasswordEditText.getText().toString()
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
