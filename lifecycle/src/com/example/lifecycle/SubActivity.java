package com.example.lifecycle;

import android.app.Activity;
import android.os.Bundle;

public class SubActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自動生成されたメソッド・スタブ
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sub);
	}

}
