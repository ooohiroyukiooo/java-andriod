package com.example.buttonivent;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

Button b1;
Button b2;
Button b3;
// ボタン3用のリスナ
OnClickListener myClick = new OnClickListener() {
	@Override
	public void onClick(View v) {
		Log.v("test", "ボタン押された！");
	}
};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		b1 = (Button)findViewById(R.id.button1);
		b1.setOnClickListener(new OnClickListener() {//匿名クラス


			@Override
			public void onClick(View v) {
				//Log.v("test", "ボタンが押されたよ");
				System.out.println("ボタンが押されたぞ");
			}
		});

		b2 = (Button) findViewById(R.id.button2);
		b2.setOnClickListener(new MyClickListener());
		b3 = (Button) findViewById(R.id.button3);
		b3.setOnClickListener(myClick);
	}

	class MyClickListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			Log.v("test", "ボタンが押されたよ");
		}

	}
}
