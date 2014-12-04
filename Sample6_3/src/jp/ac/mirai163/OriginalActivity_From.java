package jp.ac.mirai163;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class OriginalActivity_From extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.original_from);

		Button b1 = (Button) findViewById(R.id.button1);

		b1.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				// エディットテキストのインスタンスを取得
				EditText et1 = (EditText) findViewById(R.id.edittext1);
				// 次の画面の呼び出し
				Intent intent = new Intent(OriginalActivity_From.this,OriginalActivity_To.class);
				intent.putExtra("text",et1.getText().toString());
				startActivityForResult(intent,1);
			}
		});
	}

	@Override
	protected void onActivityResult(int requestCode,int resultCode,Intent intent) {
		// メッセージのテキストを書き換え
		TextView tv = (TextView) findViewById(R.id.message);
		String message = "";
		if (resultCode == Activity.RESULT_OK){
			message = "前の画面で完了ボタンが押されました。";
		}
		else if (resultCode == Activity.RESULT_CANCELED){
			message = "前の画面で取消ボタンが押されました。";
		}
		else {
			message = "前の画面でボタンが押されませんでした。";
		}
		tv.setText(message);
	}
}