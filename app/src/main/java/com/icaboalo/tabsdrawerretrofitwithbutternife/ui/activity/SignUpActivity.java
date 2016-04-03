package com.icaboalo.tabsdrawerretrofitwithbutternife.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import com.icaboalo.tabsdrawerretrofitwithbutternife.R;
import com.icaboalo.tabsdrawerretrofitwithbutternife.sqlite.CoursesOpenHelper;
import com.icaboalo.tabsdrawerretrofitwithbutternife.util.VUtils;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SignUpActivity extends AppCompatActivity {

    @Bind(R.id.email)
    EditText mEmailInput;

    @Bind(R.id.first_name)
    EditText mFirstNameInput;

    @Bind(R.id.last_name)
    EditText mLastNameInput;

    @Bind({R.id.password, R.id.repeat_password})
    List<EditText> mPasswordsInput;

    @Bind(R.id.repeat_password)
    EditText mPasswordRepeatInput;

    CoursesOpenHelper openHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        ButterKnife.bind(this);
        openHelper = new CoursesOpenHelper(getApplicationContext());
    }

    @OnClick(R.id.sign_up)
    public void signUp() {
        if (formFilled()){
            //sign up
            openHelper.insertUser(VUtils.extractText(mEmailInput),
                    VUtils.extractText(mPasswordRepeatInput),
                    VUtils.extractText(mFirstNameInput), VUtils.extractText(mLastNameInput));
            goToMain();
        }else if (isEmailEmpty()){
            mEmailInput.setError(getString(R.string.email_input_error));
        }else if (isFirstNameEmpty()){
            mFirstNameInput.setError(getString(R.string.name_input_error));
        }else if (isLastNameEmpty()){
            mLastNameInput.setError("Please enter a ast name");
        }else if (isPasswordEmpty()){
            ButterKnife.apply(mPasswordsInput, EMPTY_ERROR);
        }else if (passwordsMatch()){
            ButterKnife.apply(mPasswordsInput, MATCH_ERROR);
        }
    }

    private void goToMain() {
        Intent goToMain = new Intent(this, MainActivity.class);
        startActivity(goToMain);
        finish();
    }

    private boolean passwordsMatch() {
        return (mPasswordsInput.get(0).getText().toString().equals(mPasswordsInput.get(1).getText().toString()));
    }

    private boolean formFilled() {
        return !(isNameEmpty() || isEmailEmpty() || isPasswordEmpty());
    }

    private boolean isNameEmpty() {
        return (isFirstNameEmpty() || isLastNameEmpty());
    }

    private boolean isEmailEmpty() {
        return (mEmailInput.getText().toString().isEmpty());
    }

    private boolean isFirstNameEmpty() {
        return (mFirstNameInput.getText().toString().isEmpty());
    }

    private boolean isLastNameEmpty() {
        return (mLastNameInput.getText().toString().isEmpty());
    }

    private boolean isPasswordEmpty() {
        for (EditText passwords : mPasswordsInput) {
            if (passwords.getText().toString().isEmpty())
                return true;
        }
        return false;
    }

    static final ButterKnife.Action<EditText> EMPTY_ERROR = new ButterKnife.Action<EditText>() {
        @Override
        public void apply(EditText view, int index) {
            view.setError("Please provide a password");
        }
    };

    static final ButterKnife.Action<EditText> MATCH_ERROR = new ButterKnife.Action<EditText>() {
        @Override
        public void apply(EditText view, int index) {
            view.setError("Passwords don't match!");
        }
    };


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sign_up, menu);
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
}
