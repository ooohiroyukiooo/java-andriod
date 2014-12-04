package jp.ac.mirai142;

import android.app.Activity;
import android.os.Bundle;

public class TouchEventActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(new TouchEventView(this));
		// TouchEventViewを生成して表示しなさい！
	}
}
