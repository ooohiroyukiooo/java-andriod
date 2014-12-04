package com.example.add10;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	Button btnStart;
	TextView tv_1;
	TextView tv_2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btnStart = (Button) findViewById(R.id.button1); //button1とbtnStartを紐づける
		tv_1 = (TextView)findViewById(R.id.textView1);
		tv_2 = (TextView)findViewById(R.id.textView2);
		btnStart.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) { //匿名クラス
				Intent intent = new Intent(MainActivity.this, GameActivity_onClick.class);
				startActivityForResult(intent, 1); //第２引数の1は(resuestCode)
			}
		});
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if(resultCode == RESULT_OK && data != null) {
			int m = data.getIntExtra("miss", 0);
			String str = data.getStringExtra("time");
			tv_1.setText(getString(R.string.res_miss1) + " " + m +  getString(R.string.res_miss2));
			tv_2.setText(getString(R.string.res_time1) + " " + str + getString(R.string.res_time2));
		}
	}
}
