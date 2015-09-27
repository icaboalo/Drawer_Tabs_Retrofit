package com.icaboalo.tabsdrawerretrofitwithbutternife.ui.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.icaboalo.tabsdrawerretrofitwithbutternife.R;
import com.icaboalo.tabsdrawerretrofitwithbutternife.constants.PrefsConstants;
import com.icaboalo.tabsdrawerretrofitwithbutternife.ui.fragment.CourseraFragment;
import com.icaboalo.tabsdrawerretrofitwithbutternife.ui.fragment.HomeFragment;
import com.icaboalo.tabsdrawerretrofitwithbutternife.ui.fragment.UdacityFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.app_bar)
    Toolbar mToolbar;

    @Bind(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;

    @Bind(R.id.navigation_view)
    NavigationView mNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);

        if (!isUserDataSaved()){
            goToLogin();
        }

        replaceFragment(new HomeFragment());

        navigationViewOnClick();

    }

    private void navigationViewOnClick() {
            mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(MenuItem menuItem) {
                    Fragment fragment = null;
                    switch (menuItem.getItemId()) {
                        case R.id.action_udacity:
                            fragment = new UdacityFragment();
                            break;
                        case R.id.action_home:
                            fragment = new HomeFragment();
                            break;
                        case R.id.action_coursera:
                            fragment = new CourseraFragment();
                            break;
                    }
                    replaceFragment(fragment);
                    mDrawerLayout.closeDrawers();
                    return false;
                }
            });
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.container, fragment).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (id){
            case R.id.action_settings:
                return true;
            case R.id.action_log_out:
                logOut();
                showMessage(R.string.log_out_message);
                break;
        }


        return super.onOptionsItemSelected(item);
    }

    private void showMessage(int stringId) {
        String message = getString(stringId);
        Snackbar.make(mDrawerLayout, message, Snackbar.LENGTH_SHORT).show();
    }

    public boolean isUserDataSaved(){
        SharedPreferences sharedPreferences = getSharedPreferences(PrefsConstants.FILE_LOGIN, MODE_PRIVATE);
        return sharedPreferences.contains(PrefsConstants.PREF_USERNAME)
                && sharedPreferences.contains(PrefsConstants.PREF_PASSWORD);
    }

    private void goToLogin() {
        Intent goToLogIn = new Intent(this, LogInActivity.class);
        startActivity(goToLogIn);
        finish();
    }

    private void logOut() {
        SharedPreferences sharedPreferences = getSharedPreferences(PrefsConstants.FILE_LOGIN, MODE_PRIVATE);
        sharedPreferences.edit()
                .remove(PrefsConstants.PREF_USERNAME)
                .remove(PrefsConstants.PREF_PASSWORD)
                .apply();
        Intent goToLogIn = new Intent(this, LogInActivity.class);
        startActivity(goToLogIn);
        finish();
    }
}
