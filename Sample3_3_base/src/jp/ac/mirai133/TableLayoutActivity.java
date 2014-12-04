package jp.ac.mirai133;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TableLayoutActivity extends Activity {
	Button btn;
	EditText etEng;
	EditText etMath;
	EditText etLng;
	TextView tv;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		btn = (Button)findViewById(R.id.buttonCount);
		etEng = (EditText)findViewById(R.id.editEnglish);
		etMath = (EditText)findViewById(R.id.editMath);
		etLng = (EditText)findViewById(R.id.editJapaneseLanguage);
		tv = (TextView)findViewById(R.id.textView1);

		btn.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// 文字列取得
				String strEng = etEng.getText().toString();
				String strMath = etMath.getText().toString();
				String strLng = etLng.getText().toString();

				// 数値に変換
				int iEng = Integer.parseInt(strEng);
				int iMath = Integer.parseInt(strMath);
				int iLng = Integer.parseInt(strLng);

				// 合計点算出
				int sum = iEng + iMath + iLng;

				// 合否判定
				if (sum < 100) {
					// 不合格
					tv.setText("不合格");
					tv.setText(Color.BLUE);
				} else {
					// 合格
					tv.setText("合格");
					tv.setText(Color.RED);
				}
				Animation animation = AnimationUtils.loadAnimation(
						TabletLayoutActivity
						);

			}
		});
	}
}