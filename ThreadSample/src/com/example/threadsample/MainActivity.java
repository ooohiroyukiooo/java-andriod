package com.example.threadsample;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

public class MainActivity extends Activity implements Runnable{
	TextView tv;
	int cnt;
	Thread thread;
	Handler handler = new Handler();

		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_main);
			tv = (TextView)findViewById(R.id.textView);
			thread = new Thread (this);
			thread.start();
	}

	@Override
	public void run() {
		while (thread == null) {
			cnt++;
			handler.post(new Runnable() {
				@Override
				public void run() {
					tv.setText(cnt + "秒経過");
				}
		});
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		thread = null;
	}
}
