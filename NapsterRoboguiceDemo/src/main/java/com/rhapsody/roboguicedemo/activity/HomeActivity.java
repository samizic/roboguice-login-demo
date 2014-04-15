package com.rhapsody.roboguicedemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.google.inject.Inject;
import com.rhapsody.roboguicedemo.R;
import com.rhapsody.roboguicedemo.login.LoginManager;
import com.rhapsody.roboguicedemo.user.UserDetails;
import com.rhapsody.roboguicedemo.user.UserManager;
import roboguice.activity.RoboActivity;
import roboguice.inject.InjectView;

/**
 * Created by samizic on 14.04.14..
 */
public class HomeActivity extends RoboActivity{

	@InjectView(R.id.username_textView) 	private TextView _username;
	@InjectView(R.id.account_type_textView) private TextView _accountType;
	@InjectView(R.id.btn_sign_out)			private Button _signOut;

	@Inject LoginManager _loginManager;
	@Inject UserManager _userManager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.screen_home);

		UserDetails user = _userManager.getUser();

		_username.setText(user.getUsername());
		_accountType.setText(user.getAccountType());

		_signOut.setOnClickListener(new SignOutClickListener());
	}

	private class SignOutClickListener implements View.OnClickListener {
		@Override
		public void onClick(View v) {
			_loginManager.logOut();

			if(_userManager.isSignedIn()){
				Toast.makeText(HomeActivity.this, "There was a problem while signing out. User is still signed in.", Toast.LENGTH_LONG).show();
				return;
			}

			startActivity(new Intent(HomeActivity.this, SignInActivity.class));
			finish();
		}
	}
}
