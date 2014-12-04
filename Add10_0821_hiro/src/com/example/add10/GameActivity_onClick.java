package com.example.add10;

import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.RatingBar;
import android.widget.TextView;

public class GameActivity_onClick extends Activity {

	Random rnd = new Random();
	TextView tvQ;
	TextView tvRes;
	int num;
	Chronometer chrono;
	TextView tvAnim;
	Animation animation;
	int cnt;
	RatingBar ratingBar;
	int miss;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game1);
		tvQ = (TextView) findViewById(R.id.tv_q); //tv_qとtvQを紐づける！
		tvRes = (TextView) findViewById(R.id.tv_res);
		chrono = (Chronometer) findViewById(R.id.chronometer1); //参照を取得
		tvAnim = (TextView) findViewById(R.id.tv_anim); //参照を取得
		ratingBar = (RatingBar) findViewById(R.id.ratingBar1);
		animation = AnimationUtils.loadAnimation(this, R.anim.my_anim);
		animation.setAnimationListener(new AnimationListener() {

			@Override
			public void onAnimationStart(Animation animation) {
				// TODO 自動生成されたメソッド・スタブ

			}

			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO 自動生成されたメソッド・スタブ

			}

			@Override
			public void onAnimationEnd(Animation animation) {
				// TODO 自動生成されたメソッド・スタブ
				ratingBar.setRating((float)cnt/2);
				if(cnt >= 10) {
					Intent intent = new Intent();
					intent.putExtra("miss", miss);
					intent.putExtra("test", chrono.getText().toString());
					setResult(RESULT_OK, intent);
					finish();
				}
			}
		});
		chrono.start();
		num = rnd.nextInt(11);
		tvQ.setText(num + "+ 7 = 10"); //最初の問題
	}

	public void myClick(View view) {
		animation.cancel();
		Button b = (Button) view;
		String str = b.getText().toString();
		int n = Integer.parseInt(str);
		Log.v("", n + "が押されたよ");
		//判定処理
		if(num + n == 10) {
			//正解
			cnt++;
			if(cnt < 10) {
				tvRes.setTextColor(Color.RED);
				tvRes.setText(R.string.good); //goodはid

			}else {
				tvRes.setTextColor(Color.GREEN);
				tvRes.setText(R.string.clear); //goodはid
				chrono.stop();
			}
			tvAnim.setTextColor(Color.RED);
			tvAnim.setText("○");
		} else {
			//不正解
			miss++;
			if(cnt > 0) {
				cnt--;
			}
			tvRes.setTextColor(Color.BLUE);
			tvRes.setText(R.string.bad);
			tvAnim.setTextColor(Color.BLUE);
			tvAnim.setText("×");
		}
			tvAnim.startAnimation(animation);

			num = rnd.nextInt(11);
			tvQ.setText(num + "+ 7 = 10");


	}
}
