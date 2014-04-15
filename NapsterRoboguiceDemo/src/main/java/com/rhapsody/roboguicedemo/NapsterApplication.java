package com.rhapsody.roboguicedemo;

import android.app.Application;
import com.rhapsody.roboguicedemo.roboguice.NapsterModule;
import roboguice.RoboGuice;

/**
 * Created by samizic on 15.04.14..
 */
public class NapsterApplication extends Application {

	@Override
	public void onCreate() {
		super.onCreate();

		// register NapsterModule with Roboguice
		RoboGuice.setBaseApplicationInjector(this,
				RoboGuice.DEFAULT_STAGE,
				RoboGuice.newDefaultRoboModule(this),
				new NapsterModule());
	}
}
