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

public class GameActivity_onclick extends Activity {

	private Random rnd = new Random();
	private TextView tvQ;
	private TextView tvRes;
	private int num;
	private Chronometer chrono;
	private TextView tvAnim;
	private Animation animation;
	private int cnt;
	private RatingBar ratingBar;
	private int miss;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game1);
		tvQ = (TextView) findViewById(R.id.tv_q);
		tvRes=(TextView) findViewById(R.id.tv_res);
		chrono=(Chronometer)findViewById(R.id.chronometer1);
		tvAnim=(TextView)findViewById(R.id.tv_anim);
		ratingBar=(RatingBar)findViewById(R.id.ratingBar1);
		animation=AnimationUtils.loadAnimation(this, R.anim.my_anim);
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
				ratingBar.setRating((float)cnt/2);
				if(cnt>=10){
					Intent intent=new Intent();
					intent.putExtra(MainActivity.KEY_MISS, miss);
					intent.putExtra(MainActivity.KEY_TIME, chrono.getText().toString());
					setResult(RESULT_OK, intent);
					finish();
				}
			}
		});
		chrono.start();
		showNextQuestion();
//		num = rnd.nextInt(11);
//		tvQ.setText(num + "+?=10");
	}

	public void myClick(View view){
		Button b = (Button) view;
		String str = b.getText().toString();
		int n = Integer.parseInt(str);
		Log.v("", n + "が押されたよ");
		// 判定処理
		if(isGood(n)){
			//正解
			cnt++;
			if(cnt<10){
				tvRes.setTextColor(Color.RED);
				tvRes.setText(R.string.good);
			}else{
				tvRes.setTextColor(Color.GREEN);
				tvRes.setText(R.string.clear);
				chrono.stop();
			}
			tvAnim.setTextColor(Color.RED);
			tvAnim.setText("○");
		}else{
			//不正解
			miss++;
			if(cnt>0){
				cnt--;
			}
			tvRes.setTextColor(Color.BLUE);
			tvRes.setText(R.string.bad);
			tvAnim.setTextColor(Color.BLUE);
			tvAnim.setText("×");
		}

		tvAnim.startAnimation(animation);
		showNextQuestion();
		num = rnd.nextInt(11);
		tvQ.setText(num + "+?=10");
	}
	public void showNextQuestion(){
		num = rnd.nextInt(11);
		tvQ.setText(num + "+ ? = 10");
	}
	public boolean isGood(int n) {

		return num + n == 10;

	}
}
