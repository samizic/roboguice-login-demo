package com.rhapsody.roboguicedemo.login;

/**
 * Created by samizic on 15.04.14..
 */
public interface LoginDataService {

	void doEremedyLogin(String username, String password, LoginResponseListener listener);

}
