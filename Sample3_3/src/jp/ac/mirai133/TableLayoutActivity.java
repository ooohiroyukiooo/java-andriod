package jp.ac.mirai133;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TableLayoutActivity extends Activity {

	TextView tvSum, tvAve;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_table_layout);//Javaのmain関数と同じ

		// Button型のインスタンスに対する参照を取得
		Button button = (Button) findViewById(R.id.buttonCount);

		// クリック時のイベントリスナを設定
		button.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {
				// EditText型のインスタンスに対する参照を取得
				EditText etEng, etMath, etJpn;

				etEng = (EditText) findViewById(R.id.editEnglish);
				etMath = (EditText) findViewById(R.id.editMath);
				etJpn = (EditText) findViewById(R.id.editJapaneseLanguage);

				// 取得したデータを文字列型から数値型に変換する
				String strEng = etEng.getText().toString();
				int iEng = Integer.parseInt(strEng);
				String strMath = etMath.getText().toString();
				int iMath = Integer.parseInt(strMath);
				String strJpn = etJpn.getText().toString();
				int iJpn = Integer.parseInt(strJpn);

				int sum = iEng + iMath + iJpn;
				int ave = sum / 3;

				// 表示するデータを送る
				tvSum.setText("合計:" + sum);
				tvAve.setText("平均:" + ave);

			}
		});
	}
}
