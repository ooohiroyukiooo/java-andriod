package jp.ac.mirai125;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class ButtonActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_button);

		// ボタンのインスタンスを取得
		Button b1 = (Button) findViewById(R.id.button1);

		// マウスクリック時のイベントリスナーを匿名クラスで設定
		b1.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {
				// ボタンのテキストを書き換え
				//v.setBackgroundColor(Color.RED);
				((Button) view).setText(R.string.button_word);
			}
		});

		// ボタンのインスタンスを取得
		Button b2 = (Button) findViewById(R.id.button2);

		// マウスクリック時のイベントリスナーを匿名クラスで設定
		b2.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {


				// ログを出力
				Log.v("onClick", "b2 is clicked.");
			}
		});

		// ボタンのインスタンスを取得
		Button b3 = (Button) findViewById(R.id.button3);

		// マウスクリック時のイベントリスナーを匿名クラスで設定
		b3.setOnClickListener(new View.OnClickListener() {

			public void onClick(View view) {

			// アラートダイアログを表示
			AlertDialog.Builder dlg;
			dlg = new AlertDialog.Builder(view.getContext());
			dlg.setTitle("メッセージ");
			dlg.setMessage("アラートダイアログのテスト");
			dlg.show();
			}
		});
	}
}
