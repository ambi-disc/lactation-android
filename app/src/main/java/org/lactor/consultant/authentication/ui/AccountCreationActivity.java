package org.lactor.consultant.authentication.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import org.lactor.consultant.R;
import org.lactor.consultant.authentication.webrequests.AccountCreationRequest;
import org.lactor.consultant.authentication.webrequests.LoginResult;
import org.lactor.consultant.core.webrequests.LactorApiHelper;
import org.lactor.consultant.homepage.ui.Inbox;
import org.lactor.consultant.homepage.ui.MainActivity;
import org.lactor.consultant.homepage.ui.MotherInfo;
import org.lactor.consultant.homepage.ui.SettingsPage;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AccountCreationActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {
    private EditText mFirstNameEditText;
    private EditText mLastNameEditText;
    private EditText mPasswordEditText;
    private EditText mEmailEditText;

    private Spinner mOrganizationSpinner;
    private String mOrganizationSpinnerValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_creation);
        findViewById(R.id.button_submit).setOnClickListener(this);

        mFirstNameEditText = (EditText) findViewById(R.id.firstname);
        mLastNameEditText = (EditText) findViewById(R.id.lastname);
        mEmailEditText = (EditText) findViewById(R.id.email);
        mPasswordEditText = (EditText) findViewById(R.id.password);

        setupOrganizationSpinner();
    }

    private void setupOrganizationSpinner() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.organization, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        mOrganizationSpinner = (Spinner) findViewById(R.id.organization);
        mOrganizationSpinner.setAdapter(adapter);
        mOrganizationSpinner.setOnItemSelectedListener(this);
        mOrganizationSpinner.setPrompt("Organization");

        mOrganizationSpinnerValue= null;
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.login_button:
                LactorApiHelper.getInstance().createAccount(
                        new AccountCreationRequest(
                                mFirstNameEditText.getText().toString(),
                                mLastNameEditText.getText().toString(),
                                mEmailEditText.getText().toString(),
                                mOrganizationSpinnerValue,
                                mPasswordEditText.getText().toString()
                        )
                ).enqueue(new Callback<LoginResult>() {
                    @Override
                    public void onResponse(Call<LoginResult> call, Response<LoginResult> response) {
                        System.out.println("Account Created!");

                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        intent.putExtra(
                                MainActivity.EXTRA_LOGIN_TOKEN,
                                response.body().getAuthToken()
                        );
                        startActivity(intent);

                        startActivity(intent);

                        Intent intent2 = new Intent(getApplicationContext(), MotherInfo.class);
                        intent2.putExtra(
                                MotherInfo.EXTRA_LOGIN_TOKEN,
                                response.body().getAuthToken()


                        );
                        startActivity(intent2);

                        Intent intent3 = new Intent(getApplicationContext(), SettingsPage.class);
                        intent3.putExtra(
                                SettingsPage.EXTRA_LOGIN_TOKEN,
                                response.body().getAuthToken()
                        );
                        startActivity(intent3);

                        Intent intent4 = new Intent(getApplicationContext(), Inbox.class);
                        intent4.putExtra(
                                Inbox.EXTRA_LOGIN_TOKEN,
                                response.body().getAuthToken()

                        );
                        startActivity(intent4);

                        // TODO Share preferences, authToken
                    }

                    @Override
                    public void onFailure(Call<LoginResult> call, Throwable t) {

                    }
                });


        }

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        mOrganizationSpinnerValue = getResources().getStringArray(R.array.organization)[i];
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        mOrganizationSpinnerValue = null;

    }
}
