package jp.ac.mirai123;

import android.app.Activity;
import android.os.Bundle;

public class GraphicSampleActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Viewクラスのインスタンスを生成する
		GraphicSampleView view = new GraphicSampleView(getApplication());
		// 生成したViewを設定
		setContentView(view);
	}
}
