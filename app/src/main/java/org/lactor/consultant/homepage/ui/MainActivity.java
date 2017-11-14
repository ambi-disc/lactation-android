package org.lactor.consultant.homepage.ui;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import org.lactor.consultant.InboxArchived;
import org.lactor.consultant.InboxCompose;
import org.lactor.consultant.InboxNew;
import org.lactor.consultant.ManageUsers;
import org.lactor.consultant.R;
import org.lactor.consultant.ViewEditChildInformation;
import org.lactor.consultant.ViewEditMotherInfromation;
import org.lactor.consultant.about.ui.AboutFragment;
import org.lactor.consultant.accounts.ui.AccountsFragment;
import org.lactor.consultant.accounts.ui.Questionnaires;
import org.lactor.consultant.dashboard.ui.DashboardFragment;
import org.lactor.consultant.displaydata.ui.DisplayDataFragment;
import org.lactor.consultant.inbox.ui.InboxFragment;
import org.lactor.consultant.notifications.ui.NotificationsFragment;
import org.lactor.consultant.preferences.ui.PreferencesFragment;
import org.lactor.consultant.profile.fragment.ProfileFragment;

import java.util.ArrayList;

public class MainActivity
        extends AppCompatActivity
        implements PreferencesFragment.OnFragmentInteractionListener,
                   DashboardFragment.OnFragmentInteractionListener,
                   NotificationsFragment.OnFragmentInteractionListener,
                   InboxFragment.OnFragmentInteractionListener,
                   AccountsFragment.OnFragmentInteractionListener,
                   DisplayDataFragment.OnFragmentInteractionListener,
                   ProfileFragment.OnFragmentInteractionListener,
                   AboutFragment.OnFragmentInteractionListener,
                   ViewEditMotherInfromation.OnFragmentInteractionListener,
                   ManageUsers.OnFragmentInteractionListener,
                   ViewEditChildInformation.OnFragmentInteractionListener,
                   Questionnaires.OnFragmentInteractionListener,
                   InboxArchived.OnFragmentInteractionListener,
                   InboxNew.OnFragmentInteractionListener,
                   InboxCompose.OnFragmentInteractionListener,
                   View.OnClickListener {

    public static final String EXTRA_LOGIN_TOKEN = "LoginToken";

    ListView mDrawerList;
    RelativeLayout mDrawerPane;
    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout;

    ArrayList<NavItem> mNavItems = new ArrayList<NavItem>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNavItems.add(new NavItem("Dashboard", "See Mother's Information", R.drawable.ic_action_dashboard));
        mNavItems.add(new NavItem("Notifications", "Notification Query Values", R.drawable.ic_action_notifications));
        mNavItems.add(new NavItem("Display Data", "Diary Query Values", R.drawable.ic_action_display_data));
        mNavItems.add(new NavItem("Inbox", "Unread Messages", R.drawable.ic_action_inbox));
        mNavItems.add(new NavItem("Accounts", "Manage Users", R.drawable.ic_action_accounts));
        mNavItems.add(new NavItem("About", "", R.drawable.ic_action_about));


        // DrawerLayout
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);

        // Populate the Navigtion Drawer with options
        mDrawerPane = (RelativeLayout) findViewById(R.id.drawerPane);
        mDrawerList = (ListView) findViewById(R.id.navList);
        DrawerListAdapter adapter = new DrawerListAdapter(this, mNavItems);
        mDrawerList.setAdapter(adapter);

        // Drawer Item click listeners
        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectItemFromDrawer(position);
            }
        });

        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.drawer_open, R.string.drawer_close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);

                invalidateOptionsMenu();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);

                invalidateOptionsMenu();
            }
        };

        mDrawerLayout.setDrawerListener(mDrawerToggle);
        findViewById(R.id.profileBox).setOnClickListener(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void selectItemFromDrawer(int position) {
        Fragment fragment = null;
        switch(position){
            case 0:
                fragment = new DashboardFragment();
                break;
            case 1:
                fragment = new NotificationsFragment();
                break;
            case 2:
                fragment = new DisplayDataFragment();
                break;
            case 3:
                fragment = new InboxFragment();
                break;
            case 4:
                fragment = new AccountsFragment();
                break;
            case 5:
                fragment = new AboutFragment();
                break;
        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.mainContent, fragment)
                .commit();

        mDrawerList.setItemChecked(position, true);
        setTitle(mNavItems.get(position).mTitle);
        mDrawerLayout.closeDrawer(mDrawerPane);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Pass the event to ActionBarDrawerToggle
        // If it returns true, then it has handled
        // the nav drawer indicator touch event
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        // Handle your other action bar items...

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.profileBox:
                Fragment fragment = new ProfileFragment();
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.mainContent, fragment)
                        .commit();
                setTitle("Your Profile");
                mDrawerLayout.closeDrawer(mDrawerPane);
        }
    }

    /*
    // Called when invalidateOptionsMenu() is invoked
    public boolean onPrepareOptionsMenu(Menu menu) {
        // If the nav drawer is open, hide action items related to the content view
        boolean drawerOpen = mDrawerLayout.isDrawerOpen(mDrawerList);
        menu.findItem(R.id.action_search).setVisible(!drawerOpen);

    }
    */
}
