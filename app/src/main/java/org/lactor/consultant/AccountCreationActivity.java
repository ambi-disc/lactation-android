package org.lactor.consultant;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import org.lactor.consultant.api.AccountRequest;
import org.lactor.consultant.api.LactorAPIHelper;
import org.lactor.consultant.api.LoginReturn;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

<<<<<<< HEAD
public class AccountCreationActivity extends AppCompatActivity implements View.OnClickListener,AdapterView.OnItemSelectedListener {
    private EditText firstname;
    private EditText lastname;
    private EditText username;
    private EditText password;
    private Spinner organization;
    private EditText email;
    private String organizationvalue;

=======
public class AccountCreationActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText mFirstNameEditText;
    private EditText mLastNameEditText;
    private EditText mPasswordEditText;
    private EditText mOrganizationEditText;
    private EditText mEmailEditText;
>>>>>>> 3f855208fd6eb4205bb98e225dd5d9aeefa0bd60


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_creation);
        findViewById(R.id.button_submit).setOnClickListener(this);

<<<<<<< HEAD
        firstname = (EditText) findViewById(R.id.firstname);
        lastname = (EditText) findViewById(R.id.lastname);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        organization = (Spinner) findViewById(R.id.organization);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.organization, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        organization.setAdapter(adapter);
        organization.setOnItemSelectedListener(this);
        organization.setPrompt("Organization");
=======
        firstname = (EditText) findViewById(R.id.mFirstNameEditText);
        lastname = (EditText) findViewById(R.id.mLastNameEditText);
        password = (EditText) findViewById(R.id.mPasswordEditText);
        organization = (EditText) findViewById(R.id.mOrganizationEditText);
>>>>>>> 3f855208fd6eb4205bb98e225dd5d9aeefa0bd60
        email = (EditText) findViewById(R.id.email);

        organizationvalue= null;
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.login_button:
                LactorAPIHelper.getInstance().createAccount(
                        new AccountRequest(
<<<<<<< HEAD
                                firstname.getText().toString(),
                            lastname.getText().toString(),
                            username.getText().toString(),
                            organizationvalue,
                            password.getText().toString()
=======
                                mFirstNameEditTExt.getText().toString(),
                            mLastNameEditText.getText().toString(),
                            mOrganizationEditText.getText().toString(),
                            mPasswordEditText.getText().toString()
>>>>>>> 3f855208fd6eb4205bb98e225dd5d9aeefa0bd60
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



    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        organizationvalue= getResources().getStringArray(R.array.organization)[i];
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        organizationvalue = null;

    }
}
