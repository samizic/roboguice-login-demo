package com.rhapsody.roboguicedemo.roboguice;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.rhapsody.roboguicedemo.login.LoginDataService;
import com.rhapsody.roboguicedemo.login.NapsterLoginDataService;

/**
 * Created by samizic on 15.04.14..
 */
public class NapsterModule implements Module{

	@Override
	public void configure(Binder binder) {

		binder.bind(LoginDataService.class).to(NapsterLoginDataService.class);
	}
}
