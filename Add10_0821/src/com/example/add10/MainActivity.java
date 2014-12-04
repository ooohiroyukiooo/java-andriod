package com.example.add10;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	public static final String KEY_MISS = "miss";
	public static final String KEY_TIME = "time";
	Button btnStart;
	TextView tv_1;
	TextView tv_2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btnStart = (Button) findViewById(R.id.button1);
		tv_1 = (TextView) findViewById(R.id.textView1);
		tv_2 = (TextView) findViewById(R.id.textView2);
		btnStart.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this,
						GameActivity_onclick.class);
				startActivityForResult(intent, 1);
			}
		});
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (resultCode == RESULT_OK && data != null) {
			int m = data.getIntExtra("KEY_MISS", 0);
			String str = data.getStringExtra("KEY_TIME");
			tv_1.setText(getString(R.string.res_miss1) + " "+m
					+ getString(R.string.res_miss2));
			tv_2.setText(getString(R.string.res_time1) +" "+ str
					+ getString(R.string.res_time2));
		}

	}

}
