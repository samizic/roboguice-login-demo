package com.rhapsody.roboguicedemo.login;

import android.app.Application;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.rhapsody.roboguicedemo.user.UserManager;

/**
 * Created by samizic on 14.04.14..
 */

@Singleton
public class LoginManager {

	// Application is an equivalent of application context
	@Inject private Application _application;
	@Inject private UserManager _userManager;
	@Inject private LoginDataService _loginDataService;

	public void logIn(String username, String password, LoginResponseListener listener){

		if(!areCredentialsValid(username, password)){
			listener.onError(LoginError.INCORRECT_USERNAME_OR_PASSWORD);
		}
		else{
			doUserLogIn(username, password, listener);
		}
	}

	private void doUserLogIn(String username, String password, LoginResponseListener listener) {

		_loginDataService.doEremedyLogin(username, password, listener);

	}


	public void logOut(){
		_userManager.clearUser();
	}

	private boolean areCredentialsValid(String username, String password) {
		return username != null && username.length() > 0 && password != null && password.length() > 0;
	}

}
