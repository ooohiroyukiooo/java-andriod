package com.example.tashite10_base;

import java.util.Random;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	private TextView tvQ, tvResult;
	private Random rnd = new Random();
	int num;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tvQ = (TextView) findViewById(R.id.textView0);
		tvResult = (TextView) findViewById(R.id.textView1);
		nextQ();
	}

	public void myClick(View view) {
		String s = ((Button) view).getText().toString();
		int a = Integer.parseInt(s);
		tvResult.setText(num + a == 10 ? "good" : "bad");
		nextQ();
	}

	void nextQ() {
		num = rnd.nextInt(11);
		tvQ.setText(num + "+?=10");
	}
}
