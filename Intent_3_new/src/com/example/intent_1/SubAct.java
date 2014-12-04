package com.example.intent_1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class SubAct extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sub);
		
		Intent intent = getIntent();
		Bundle bundle = intent.getExtras();

		String strFirstName = bundle.getString("first_name");
		String strFamilyName = bundle.getString("family_name");
		int age = bundle.getInt("age");

		TextView tv = 
				(TextView) findViewById(R.id.textView1);
		// new TextView(this);

		tv.setText("呼び出されたアクティビティーです" + "\n" + "姓:" + strFamilyName + "\n"
				+ "名:" + strFirstName + "\n" + "年齢:" + age);
		
		Button resBtn=(Button)findViewById(R.id.button1);
		resBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				RadioGroup rg=(RadioGroup)findViewById(R.id.radioGroup1);
				int num=rg.getCheckedRadioButtonId();
				RadioButton rb=(RadioButton)findViewById(num);
				String msg=rb.getText().toString();
				
				Intent resIntent=new Intent();
				resIntent.putExtra("res", msg);
				setResult(RESULT_OK, resIntent);
				finish();
				
			}
		});
		
	}

}
