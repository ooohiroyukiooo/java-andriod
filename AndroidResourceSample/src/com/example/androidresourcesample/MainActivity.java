package com.example.androidresourcesample;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;

public class MainActivity extends Activity {
	ImageButton ib;
	Animation anim;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ib = (ImageButton)findViewById(R.id.imageButton1);
		anim = AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right);
		ib.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO 自動生成されたメソッド・スタブ
				ib.startAnimation(anim);
			}
		});
	}
}
