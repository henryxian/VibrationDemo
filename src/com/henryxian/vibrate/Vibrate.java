package com.henryxian.vibrate;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;

public class Vibrate extends Activity {

	private static final long[] THREE_CYCLES = 
			new long[] {100, 1000, 1000, 1000, 1000, 1000};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
	}
	
	private void vibrateOnce(){
		Vibrator vibrator = (Vibrator)getApplication()
				.getSystemService(Service.VIBRATOR_SERVICE);
		vibrator.vibrate(1000);
	}
	
	private void vibrateMulti(long[] cycles){
		NotificationManager notificationManager = 
				(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
		Notification notification = new Notification();
		
		notification.vibrate = cycles;
		notificationManager.notify(0, notification);
	}
	
	public void shortVibrate(View v){
		vibrateOnce();
	}
	
	public void longVibrate(View v){
		vibrateMulti(THREE_CYCLES);
	}
	
}
