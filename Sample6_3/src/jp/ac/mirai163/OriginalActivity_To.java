package jp.ac.mirai163;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class OriginalActivity_To extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.original_to);
		// インテントに含まれるパラメータを取得し、画面に表示
		TextView tv = (TextView) findViewById(R.id.textview1);
		Bundle extras = getIntent().getExtras();
		if (extras != null){
			tv.setText(extras.getString("text"));
		}
		// ボタンのインスタンスを取得
		Button b1 = (Button) findViewById(R.id.button1);
		Button b2 = (Button) findViewById(R.id.button2);
		// マウスクリック時のイベントリスナを匿名クラスで設定
		b1.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				// 戻りパラメータの設定
				setResult(Activity.RESULT_OK);
				// この画面の終了
				finish();
			}
		});
		// マウスクリック時のイベントリスナを匿名クラスで設定
		b2.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				// 結果コードの設定
				setResult(Activity.RESULT_CANCELED);
				// この画面の終了
				finish();
			}
		});

		// マウスクリック時のイベントリスナを匿名クラスで設定
		b2.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				// 結果コードの設定
				setResult(Activity.RESULT_CANCELED);
				// この画面の終了
				finish();
			}
		});
	}
}
