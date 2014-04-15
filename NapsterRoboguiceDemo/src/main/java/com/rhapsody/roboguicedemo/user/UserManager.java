package com.rhapsody.roboguicedemo.user;

import android.app.Application;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * Created by samizic on 14.04.14..
 */
@Singleton
public class UserManager {

	@Inject private Application _appContext;

	private UserDetails _user = UserDetails.EMPTY;

	@Inject
	public UserManager() { }

	public void setUser(UserDetails user){
		if(user != null){
			_user = user;
		}
	}

	public boolean isSignedIn(){
		return _user != UserDetails.EMPTY;
	}

	public void clearUser() {
		_user = UserDetails.EMPTY;
	}

	public UserDetails getUser() {
		return _user;
	}
}
