package com.example.add10;

import java.util.Random;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameActivity_onclick extends Activity {

	Random rnd = new Random();
	TextView tvQ;
	TextView tvRes;
	int num;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game1);
		tvQ = (TextView) findViewById(R.id.tv_q);
		tvRes=(TextView) findViewById(R.id.tv_res);
		
		num = rnd.nextInt(11);
		tvQ.setText(num + "+?=10");
	}
	
	public void myClick(View view){
		Button b = (Button) view;
		String str = b.getText().toString();
		int n = Integer.parseInt(str);
		Log.v("", n + "が押されたよ");
		// 判定処理
		if(num+n==10){
			//正解
			tvRes.setTextColor(Color.RED);
			tvRes.setText(R.string.good);
		}else{
			//不正解
			tvRes.setTextColor(Color.BLUE);
			tvRes.setText(R.string.bad);
		}
		num = rnd.nextInt(11);
		tvQ.setText(num + "+?=10");
	}
}
