package com.rhapsody.roboguicedemo.test;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.rhapsody.roboguicedemo.login.LoginDataService;

/**
 * Created by samizic on 15.04.14..
 */
public class TestNapsterModule implements Module {

	@Override
	public void configure(Binder binder) {
		binder.bind(LoginDataService.class).to(TestLoginDataService.class);
	}
}
