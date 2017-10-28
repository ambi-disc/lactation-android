package org.lactor.consultant.homepage.ui;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import org.lactor.consultant.R;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    public static final String EXTRA_LOGIN_TOKEN = "LoginToken";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        System.out.println("*************************************************");
        System.out.println("************ MainActivity.ON_CREATE ************");
        System.out.println("*************************************************");

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);

        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Toast.makeText(this, "onCreate", Toast.LENGTH_LONG).show();
    }


    @Override

    public boolean onOptionsItemSelected(MenuItem item){
        Toast.makeText(getApplicationContext(), "onOptionsItemSelected", Toast.LENGTH_LONG).show();
        if(mToggle.onOptionsItemSelected(item)){
            return true;
        }

        switch(item.getItemId()) {
            case R.id.nav_notifications:
                System.out.println("*************************************************");
                System.out.println("************ NAGIATION_NOTIFICATIONS ************");
                System.out.println("*************************************************");
                // TODO
                return true;
            case R.id.nav_displaydata:
                // TODO
                return true;
            case R.id.nav_inbox:
                // TODO
                return true;
            case R.id.nav_accounts:
                // TODO
                return true;
            case R.id.nav_profile:
                // TODO
                return true;
            case R.id.nav_logout:
                // TODO
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
