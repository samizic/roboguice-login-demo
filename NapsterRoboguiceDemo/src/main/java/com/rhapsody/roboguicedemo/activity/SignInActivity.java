package com.rhapsody.roboguicedemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.inject.Inject;
import com.rhapsody.roboguicedemo.R;
import com.rhapsody.roboguicedemo.login.LoginError;
import com.rhapsody.roboguicedemo.login.LoginManager;
import com.rhapsody.roboguicedemo.login.LoginResponseListener;
import com.rhapsody.roboguicedemo.user.UserDetails;
import com.rhapsody.roboguicedemo.user.UserManager;
import roboguice.activity.RoboActivity;
import roboguice.inject.InjectView;

public class SignInActivity extends RoboActivity {

	@InjectView(R.id.editText_username) 	private EditText _username;
	@InjectView(R.id.editText_password) 	private EditText _password;
	@InjectView(R.id.btn_sign_in) 			private Button _signInButton;

	@Inject private LoginManager _loginManager;
	@Inject private UserManager _userManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

		_signInButton.setOnClickListener(new OnSignInClickListener());

    }

	private class OnSignInClickListener implements View.OnClickListener {

		@Override
		public void onClick(View v) {
			String username = _username.getText().toString();
			String password = _password.getText().toString();

			_loginManager.logIn(username, password, new LoginResponseListener() {
				@Override
				public void onSuccess(String username, String password, String accountType) {
					UserDetails user = new UserDetails(username, password, accountType);
					_userManager.setUser(user);
					startActivity(new Intent(SignInActivity.this, HomeActivity.class));
					finish();
				}

				@Override
				public void onError(LoginError error) {
					Toast.makeText(SignInActivity.this, error.message, Toast.LENGTH_LONG).show();
				}
			});
		}
	}


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.sign_in, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }



}
