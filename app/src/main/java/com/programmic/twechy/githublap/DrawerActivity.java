package com.programmic.twechy.githublap;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.programmic.twechy.githublap.Login_Registration.LoginActivity;
import com.programmic.twechy.githublap.UI_Views.UserList;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class DrawerActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{


    private static final String TAG = DrawerActivity.class.getSimpleName();
    private String id, name, lastName, age, job, mobile, email, image_path, date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);
        ButterKnife.bind(this);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        passValues();

        Log.d(TAG, "onCreate: imagePath: " + image_path);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void passValues() {
        Intent i = getIntent();

        id = i.getStringExtra("id");
        name = i.getStringExtra("name");
        lastName = i.getStringExtra("lastName");
        age = i.getStringExtra("age");
        job = i.getStringExtra("job");
        mobile = i.getStringExtra("mobile");
        email = i.getStringExtra("email");
        image_path = i.getStringExtra("image_path");
        date = i.getStringExtra("date");
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.drawer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.Login) {
            startActivity(new Intent(getApplicationContext(), LoginActivity.class));

        } else if (id == R.id.user_profile) {

            Intent intent = new Intent(getApplicationContext(), UserProfile.class);
            intent.putExtra("id", id);
            intent.putExtra("name", name);
            intent.putExtra("lastName", lastName);
            intent.putExtra("age", age);
            intent.putExtra("job", job);
            intent.putExtra("mobile", mobile);
            intent.putExtra("email", email);
            intent.putExtra("image_path", image_path);
            intent.putExtra("date", date);
            startActivity(intent);

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @OnClick(R.id.cardMyLocationList)
    public void onCardMyLocationListClicked() {
        startActivity(new Intent(getApplicationContext(), CarsList.class));
    }

    @OnClick(R.id.cardCurrentLocation)
    public void onCardCurrentLocationClicked() {

        startActivity(new Intent(getApplicationContext(), ListActivity.class));
    }

    @OnClick(R.id.cardUsersList)
    public void onCardUsersListClicked() {
        startActivity(new Intent(getApplicationContext(), UserList.class));
    }

}
