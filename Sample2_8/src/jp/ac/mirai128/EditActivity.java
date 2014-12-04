package jp.ac.mirai128;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class EditActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit);

		// Button型のインスタンスに対する参照を取得
		Button button = (Button) findViewById(R.id.button1);

		// クリック時のイベントリスナを設定
		button.setOnClickListener(new View.OnClickListener() {


			@Override
			public void onClick(View view) {

				// EditText型のインスタンスに対する参照を取得
				EditText editText = (EditText) findViewById(R.id.editText1);

				// TextView型のインスタンスに対する参照を取得
				TextView textview = (TextView) findViewById(R.id.textView1);

				// 入力内容をTextView型のインスタンスに転記
				textview.setText(editText.getText());
			}
		});
	}
}
