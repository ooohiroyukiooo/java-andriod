package com.example.add10;

import java.util.Random;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class GameActivity extends Activity {

	Random rnd = new Random();
	TextView tvQ;
	int num;
	int[] ids = { R.id.button0, R.id.button1, R.id.button2, R.id.button3,
			R.id.button4, R.id.button5, R.id.button6, R.id.button7,
			R.id.button8, R.id.button9, R.id.button10 };
	Button[]btns=new Button[ids.length];

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game1);
		tvQ = (TextView) findViewById(R.id.textView2);
		num = rnd.nextInt(11);
		tvQ.setText(num + "+?=10");
		for (int i = 0; i < btns.length; i++) {
			btns[i]=(Button)findViewById(ids[i]);
			btns[i].setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					Button b = (Button) v;
					String str = b.getText().toString();
					int n = Integer.parseInt(str);
					Log.v("", n + "が押されたよ");
					// 判定処理
				}
			});
		}
	}
}
