package jp.ac.mirai126;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class AquariumActivity extends Activity {

	// 本アプリケーションのView内にあるImageViewを表す変数
	ImageView imageView = null;

	// 本アプリケーションのView内にあるTextViewを表す変数
	TextView textView = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_aquarium);

		// TextView型のウィジェットを取得
		textView = (TextView) findViewById(R.id.headerText);

		// ImageView型のウィジェットを取得
		imageView = (ImageView) findViewById(R.id.image1);

		// Button型のウィジェットを取得
		Button b1 = (Button) findViewById(R.id.button1);
		Button b2 = (Button) findViewById(R.id.button2);
		Button b3 = (Button) findViewById(R.id.button3);
		Button b4 = (Button) findViewById(R.id.button4);



		// 初期状態ではリソースIDがsu0000の画像を読み込む
		imageView.setImageResource(R.drawable.su0000);

		// イベントリスナの設定
		b1.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {
				// リソースIDがsu0001の画像に表示切替
				imageView.setImageResource(R.drawable.su0001);
				// 説明用のテキストも更新
				textView.setText(R.string.message_1);
			}
		});

		// イベントリスナの設定
		b2.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {
				// リソースIDがsu0002の画像に表示切替
				imageView.setImageResource(R.drawable.su0002);
				// 説明用のテキストも更新
				textView.setText(R.string.message_2);
			}
		});

		// イベントリスナの設定
		b3.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {
				// リソースIDがpenguinの画像に表示切替
				imageView.setImageResource(R.drawable.penguin);
				// 説明用のテキストも更新
				textView.setText(R.string.message_3);
			}
		});

		// イベントリスナの設定
		b4.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {
				// リソースIDがpenguinの画像に表示切替
				imageView.setImageResource(R.drawable.su0000);
				// 説明用のテキストも更新
				textView.setText(R.string.message_0);
			}
		});
	}
}
