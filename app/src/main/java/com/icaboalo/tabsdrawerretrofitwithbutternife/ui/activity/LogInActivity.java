package com.icaboalo.tabsdrawerretrofitwithbutternife.ui.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.icaboalo.tabsdrawerretrofitwithbutternife.R;
import com.icaboalo.tabsdrawerretrofitwithbutternife.constants.PrefsConstants;
import com.icaboalo.tabsdrawerretrofitwithbutternife.util.VUtils;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LogInActivity extends AppCompatActivity {

    @Bind(R.id.email_input)
    EditText mEmailInput;

    @Bind(R.id.password_input)
    EditText mPasswordInput;

    @Bind(R.id.main_container)
    RelativeLayout mContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.sign_up)
    void signup(){
        Intent goToSignUp = new Intent(this, SignUpActivity.class);
        startActivity(goToSignUp);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_log_in, menu);
        return true;
    }

    @OnClick(R.id.login_button)
    public void login(){
        if (isFormedFilled()){
            saveUserData(VUtils.extractText(mEmailInput), VUtils.extractText(mPasswordInput));
            showMessage(R.string.login_succes);
            goToMainActivity();
        }
        else if (isEmailEmpty()){
            mEmailInput.setError(getString(R.string.email_error));
        }
        else if (isPasswordEmpty()){
            mPasswordInput.setError(getString(R.string.password_error));
        }
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

    private void showMessage(int stringId) {
        String message = getString(stringId);
        Snackbar.make(mContainer, message, Snackbar.LENGTH_SHORT).show();
    }

    private boolean isFormedFilled(){
        return !(isPasswordEmpty() || isEmailEmpty());
    }

    private boolean isEmailEmpty(){
        return mEmailInput.getText().toString().isEmpty();
    }

    private boolean isPasswordEmpty(){
        return mPasswordInput.getText().toString().isEmpty();
    }

    private void saveUserData(String username, String password){
        SharedPreferences sharedPreferences = getSharedPreferences(PrefsConstants.FILE_LOGIN, MODE_PRIVATE);
        sharedPreferences.edit()
                .putString(PrefsConstants.PREF_USERNAME, username)
                .putString(PrefsConstants.PREF_PASSWORD, password)
                .apply();
    }

    private void goToMainActivity() {
        Intent goToMainActivity = new Intent(this, MainActivity.class);
        startActivity(goToMainActivity);
        finish();
    }
}
