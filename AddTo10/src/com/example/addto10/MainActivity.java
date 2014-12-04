package com.example.addto10;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button b1 = (Button) findViewById(R.id.main_button1);

		b1.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				// 次の画面の呼び出し
				Intent intent = new Intent(MainActivity.this,SubActivity.class);
				// 結果不要
				startActivity(intent); //サブ画面の呼び出し
				// 結果を受け取る場合
				// startActivityForResult(intent,1);
			}
		});
	}
}