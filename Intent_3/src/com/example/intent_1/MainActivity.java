package com.example.intent_1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button btn = (Button)findViewById(R.id.button1);
		btn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this,SubActivity.class);
				intent.putExtra("first_name","太郎");
				intent.putExtra("family_name","山田");
				intent.putExtra("age",29);

				// startActivity(intent);
				startActivityForResult(intent, 1);
			}
		});
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
	if(resultCode == RESULT_OK) {
		String strRes = data.getExtras().getString("res");
		tv.setText(strRes+"ト思います");
	}else if(resultCode == RESULT_CANCELED) {
		tv.setText("返信なし");
	}
	}

}
