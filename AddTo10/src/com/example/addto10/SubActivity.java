package com.example.addto10;

import java.util.Random;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class SubActivity extends  Activity {

	private TextView tvQ, tvResult;
	private ImageView animationImage;
	private Animation animation;
	private RatingBar ratingBar;
	private Random rnd = new Random();
	final int STR_MAX = 5;
	int num;
	int str;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sub); // sub.xmlを読み込む！
		tvQ = (TextView) findViewById(R.id.textView0); // textView0にアクセスできるようにする！
		tvResult = (TextView) findViewById(R.id.textView1); // textView1にアクセスできるようにする！
		ratingBar = (RatingBar) findViewById(R.id.ratingBar1);
		nextQ(); // 一番最初の問題を表示する
	}

	// クリックを押された時の処理
	public void myClick(View view) {
		String s = ((Button) view).getText().toString(); // xmlのテキストを取得してStringのインスタンスに入れる
		int a = Integer.parseInt(s); // Int型に変換する
			//tvResult.setText(num + a == 10 ? "good" : "bad"); //
			if(num + a == 10) {
				tvResult.setText("good");
				ratingBar.setRating((float) 0.5);
				//animationImage = (ImageView) findViewById(R.id.mogu); //レイアウト
				//animation = AnimationUtils.loadAnimation(this, R.anim.anim_1); //画像
				animationImage.startAnimation(animation);
				} else {
				tvResult.setText("bad");
				ratingBar.setRating((float) -0.5);
				//animationImage = (ImageView) findViewById(R.id.mogu);
				//animation = AnimationUtils.loadAnimation(this, R.anim.anim_1);
				animationImage.startAnimation(animation);
			}
			nextQ();
	}

	// 問題を表示するメソッド
	void nextQ() {
		num = rnd.nextInt(11);
		tvQ.setText(num + "+?=10");
	}
}

// 残りの課題
// chronomaterが表示されない
// ratingの増やし方
// アニメーションの表示
// 星が満タンになった時の処理
