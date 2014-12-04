package jp.ac.mirai162;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class OriginalActivity_To extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.original_to);

		// ボタンのインスタンスを取得
		Button b1 = (Button) findViewById(R.id.to_button1);
		// マウスクリック時のイベントリスナを匿名クラスで設定
		b1.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				// 自作Activityの終了
				finish();
			}
		});
	}
}
