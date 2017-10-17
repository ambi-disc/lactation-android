package org.lactor.consultant.modules.authorization.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import org.lactor.consultant.R;
import org.lactor.consultant.modules.authorization.webrequests.AccountCreationRequest;
import org.lactor.consultant.api.LactorAPIHelper;
import org.lactor.consultant.modules.authorization.webrequests.LoginResult;

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

        mFirstNameEditText = (EditText) findViewById(R.id.firstname);
        mLastNameEditText = (EditText) findViewById(R.id.lastname);
        mPasswordEditText = (EditText) findViewById(R.id.password);
        mOrganizationEditText = (EditText) findViewById(R.id.organization);
        mEmailEditText = (EditText) findViewById(R.id.email);

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.login_button:
                LactorAPIHelper.getInstance().createAccount(
                        new AccountCreationRequest(
                                mFirstNameEditText.getText().toString(),
                                mLastNameEditText.getText().toString(),
                                mOrganizationEditText.getText().toString(),
                                mOrganizationEditText.getText().toString(),
                                mPasswordEditText.getText().toString()
                        )
                ).enqueue(new Callback<LoginResult>() {
                    @Override
                    public void onResponse(Call<LoginResult> call, Response<LoginResult> response) {
                        System.out.println("Account Created!");

                        //TODO
                    }

                    @Override
                    public void onFailure(Call<LoginResult> call, Throwable t) {

                    }
                });


        }

    }
}
