package jp.ac.mirai161;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class StandardActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_standard);

//		// ボタンのインスタンスを取得
//		Button b1 = (Button) findViewById(R.id.button1);
//
//		// マウスクリック時のイベントリスナを匿名クラスで設定
//		b1.setOnClickListener(new View.OnClickListener() {
//
//			public void onClick(View view) {
//				// メッセージのテキストを書き換え
//				TextView tv = (TextView) findViewById(R.id.message);
//				tv.setText(R.string.button_browser);
//
//				// Webブラウザの呼び出し
//				Intent intent = new Intent("android.intent.action.VIEW",
//						Uri.parse("http://www.google.co.jp/"));
//				startActivity(intent);
//			}
//		});
//
//		// ボタンのインスタンスを取得
//		Button b2 = (Button) findViewById(R.id.button2);
//
//		// マウスクリック時のイベントリスナを匿名クラスで設定
//		b2.setOnClickListener(new View.OnClickListener() {
//			public void onClick(View view) {
//				// メッセージのテキストを書き換え
//				TextView tv = (TextView) findViewById(R.id.message);
//				tv.setText(R.string.button_map);
//
//				// 地図の呼び出し
//				Intent intent = new Intent("android.intent.action.VIEW",
//						Uri.parse("geo:0,0?q=Hokkaido"));
//				startActivity(intent);
//			}
//		});


		// ボタンのインスタンスを取得
		Button b1 = (Button) findViewById(R.id.button1);
		// マウスクリック時のイベントリスナを匿名クラスで設定
		b1.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				// メッセージのテキストを書き換え
				TextView tv = (TextView) findViewById(R.id.message);
				tv.setText(R.string.button_browser);
				// Webブラウザの呼び出し
				Intent intent = new Intent("android.intent.action.VIEW",
						Uri.parse("http://www.google.co.jp/"));
				startActivity(intent);
			}
		});
		// ボタンのインスタンスを取得
		Button b2 = (Button) findViewById(R.id.button2);
		// マウスクリック時のイベントリスナを匿名クラスで設定
		b2.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				// メッセージのテキストを書き換え
				TextView tv = (TextView) findViewById(R.id.message);
				tv.setText(R.string.button_map);
				// 地図の呼び出し
				Intent intent = new Intent("android.intent.action.VIEW",
						Uri.parse("geo:0,0?q=Hokkaido"));
				startActivity(intent);
			}
		});




		// ボタンのインスタンスを取得
		Button b3 = (Button) findViewById(R.id.button3);

		// マウスクリック時のイベントリスナを匿名クラスで設定
		b3.setOnClickListener(new View.OnClickListener() {

			public void onClick(View view) {
				// メッセージのテキストを書き換え
				TextView tv = (TextView) findViewById(R.id.message);
				tv.setText(R.string.button_setting);

				// 設定画面の呼び出し
				Intent intent = new Intent("android.settings.SETTINGS");
				startActivity(intent);
			}
		});
	}
}
