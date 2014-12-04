package com.example.sharedpredsample2;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	private static final String PREF_NAME = "myPref";
	private static final String USER_NAME = "userName";
	private static final String LEVEL = "level";

	EditText et;
	TextView tvLevel;
	Button bt;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		et = (EditText)findViewById(R.id.editText1);
		tvLevel = (TextView)findViewById(R.id.tv_level);
		bt = (Button)findViewById(R.id.button1);
		bt.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO 自動生成されたメソッド・スタブ
				int level = Integer.parseInt(tvLevel.getText().toString() + 1);
				tvLevel.setText(level +  "");
			}
		});

		// MODE_PRIVATEは他のアプリケーションから参照を不許可
		SharedPreferences sp = getSharedPreferences("PREF_NAME", MODE_PRIVATE);

		String name = sp.getString(USER_NAME, "");
		int level = sp.getInt(LEVEL, 0);
		et.setText(name);
		tvLevel.setText(level+ "");
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		SharedPreferences sp = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
		SharedPreferences.Editor editor = sp.edit();
		editor.putString(USER_NAME, et.getText().toString());
		editor.putInt(LEVEL, Integer.parseInt(tvLevel.getText().toString()));
		editor.commit();
	}

	@Override
	protected void onResume() {
		super.onResume();
		SharedPreferences sp = getSharedPreferences(PREF_NAME, MODE_PRIVATE);

		String name = sp.getString(USER_NAME, "");
		int level = sp.getInt(LEVEL, 0);
		et.setText(name);
		tvLevel.setText(level + "");

	}

	@Override
	protected void onPause() {
		super.onPause();
		SharedPreferences sp = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
		SharedPreferences.Editor editor = sp.edit();
		editor.putString(USER_NAME, et.getText().toString());
		editor.putInt(LEVEL, Integer.parseInt(tvLevel.getText().toString()));
		editor.commit();
	}






}
