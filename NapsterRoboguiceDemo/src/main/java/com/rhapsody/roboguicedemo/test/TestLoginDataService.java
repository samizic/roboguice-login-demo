package com.rhapsody.roboguicedemo.test;

import com.google.inject.Singleton;
import com.rhapsody.roboguicedemo.login.LoginDataService;
import com.rhapsody.roboguicedemo.login.LoginResponseListener;

/**
 * Created by samizic on 15.04.14..
 */
@Singleton
public class TestLoginDataService implements LoginDataService {


	@Override
	public void doEremedyLogin(String username, String password, LoginResponseListener listener) {
		listener.onSuccess(username, password, "TestAccountType");
	}
}
