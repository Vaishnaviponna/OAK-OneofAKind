package com.oak.vaishnaviponna.oak_oneofakind;

/**
 * Created by vaishnavi ponna on 19-02-2017.
 */
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
////import android.support.design.widget.FloatingActionButton;
//import android.support.design.widget.Snackbar;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.KeyEvent;
//import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

//public class Oak extends AppCompatActivity
  //      implements NavigationView.OnNavigationItemSelectedListener {
    public class Oak extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener,Login.OnFragmentInteractionListener,BlankFragment.OnFragmentInteractionListener,Registration.OnFragmentInteractionListener,PlusOneFragment.OnFragmentInteractionListener,faq.OnFragmentInteractionListener{
    private DrawerLayout mDrawer;
    private Toolbar toolbar;
  private NavigationView nvDrawer;

    // Make sure to be using android.support.v7.app.ActionBarDrawerToggle version.
    // The android.support.v4.app.ActionBarDrawerToggle has been deprecated.

    // Make sure to be using android.support.v7.app.ActionBarDrawerToggle version.
    // The android.support.v4.app.ActionBarDrawerToggle has been deprecated.
    private ActionBarDrawerToggle drawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oak);
        // Set a Toolbar to replace the ActionBar.
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerToggle = setupDrawerToggle();
        mDrawer.addDrawerListener(drawerToggle);
       // ActionBar actionBar = getSupportActionBar();
       // actionBar.setDisplayShowHomeEnabled(true);
       // actionBar.setDisplayHomeAsUpEnabled(true);

          NavigationView navigationView = (NavigationView) findViewById(R.id.nvView);
          navigationView.setNavigationItemSelectedListener(this);

        //NavigationView navigationView = null;
         //navigationView.getHeaderView(0);
        // Find our drawer view
         nvDrawer = (NavigationView) findViewById(R.id.nvView);
      //   Setup drawer view
      //  setupDrawerContent(nvDrawer);
       displaySelectedScreen(R.id.nav_first_fragment);

    }
     /*   private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                       // selectDrawerItem(menuItem);
                       //displaySelectedScreen(menuItem);
                        return true;
                    }
                });
    }*/
/*  public void selectDrawerItem(MenuItem menuItem) {
        // Create a new fragment and specify the fragment to show based on nav item clicked
        Fragment fragment = null;
        Class fragmentClass;
        switch(menuItem.getItemId()) {
            case R.id.nav_first_fragment:
                fragmentClass = BlankFragment.class;
                break;
            case R.id.nav_second_fragment:
                fragmentClass = Registration.class;
                break;
            case R.id.nav_third_fragment:
                fragmentClass = ThirdFragment.class;
                break;
            default:
                fragmentClass = BlankFragment.class;
        }

        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Insert the fragment by replacing any existing fragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();

        // Highlight the selected item has been done by NavigationView
        menuItem.setChecked(true);
        // Set action bar title
        setTitle(menuItem.getTitle());
        // Close the navigation drawer
        mDrawer.closeDrawers();
    }*/

  private void displaySelectedScreen(int itemId) {

        //creating fragment object
        Fragment fragment = null;
      Activity activity;
        //initializing the fragment object which is selected
        switch (itemId) {
            case R.id.nav_first_fragment:
          fragment = new BlankFragment();
                break;
            case R.id.nav_second_fragment:
                //fragment = new Registration();
                Intent i= new Intent(Oak.this, RegistrationActivity.class);
                startActivity(i);

                break;
            case R.id.nav_third_fragment:
             //   fragment = new Login();
                Intent i1= new Intent(Oak.this, ActivityLogin.class);
                startActivity(i1);

                break;
            case R.id.plus_one_button:
                fragment = new PlusOneFragment();
                //Intent i2= new Intent(Oak.this, FaqActivity.class);
                //startActivity(i2);

                break;
            case R.id.faq:
                fragment = new faq();
                //Intent i3= new Intent(Oak.this, aboutus.class);
                //startActivity(i3);

                break;



        }

       // replacing the fragment
        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.flContent, fragment);
            ft.commit();
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }
 // ...

    private ActionBarDrawerToggle setupDrawerToggle() {
        // NOTE: Make sure you pass in a valid toolbar reference.  ActionBarDrawToggle() does not require it
        // and will not render the hamburger icon without it.
        return new ActionBarDrawerToggle(this, mDrawer, toolbar, R.string.drawer_open, R.string.drawer_close);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggles
        drawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // The action bar home/up action should open or close the drawer.
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawer.openDrawer(GravityCompat.START);
                return true;
        }

        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }


        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
     //   getMenuInflater().inflate(R.menu.activity_oak_drawer, menu);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected( MenuItem item) {
        displaySelectedScreen(item.getItemId());
        return true;
    }
   /* @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }  */

    @Override
    public void onBackPressed(){
        android.app.FragmentManager fm = getFragmentManager();
        if (fm.getBackStackEntryCount() > 0) {
            Log.i("MainActivity", "popping backstack");
            fm.popBackStack();
        } else {
            Log.i("MainActivity", "nothing on backstack, calling super");
            super.onBackPressed();
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)  {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            if( this.getFragmentManager().getBackStackEntryCount() != 0 ){
                this.getFragmentManager().popBackStack();
                return true;
            }
            // If there are no fragments on stack perform the original back button event
        }

        return super.onKeyDown(keyCode, event);
    }


}

