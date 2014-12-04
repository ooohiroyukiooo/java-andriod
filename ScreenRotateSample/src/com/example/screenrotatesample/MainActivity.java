package com.example.screenrotatesample;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	private static final String KEY_MSG="msg";

	EditText et;
	TextView tv;
	Button btn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tv = (TextView)findViewById(R.id.tv);
		if(savedInstanceState != null) {
			String str = savedInstanceState.getString(KEY_MSG);
			tv.setText(str);
		}

		et = (EditText)findViewById(R.id.edit);
		btn = (Button)findViewById(R.id.btn);
		btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				tv.setText(tv.getText().toString() + "\n"
					+ et.getText().toString());
			}
		});
	}


	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putString(KEY_MSG, tv.getText().toString());
	}


}
