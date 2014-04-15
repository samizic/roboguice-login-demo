package com.rhapsody.roboguicedemo.login;

import android.app.Application;
import android.net.ConnectivityManager;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * Created by samizic on 14.04.14..
 */
@Singleton
public class NapsterLoginDataService implements LoginDataService {

	public void doEremedyLogin(String username, String password, LoginResponseListener listener)
	{
		listener.onSuccess(username, password, "RoboguiceDemoUser");

	}
}
