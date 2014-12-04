package com.example.sampleanim;

import jp.ac.mirai154.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class SampleAnimActivity extends Activity {

	TextView tvSum, tvAve;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sample_anim);

			// Button型のインスタンスに対する参照を取得
			Button button = (Button) findViewById(R.id.buttonCount);

			// TextView型のインスタンスに対する参照を取
			tvSum = (TextView) findViewById(R.id.textResult);
			tvAve = (TextView) findViewById(R.id.textResult2);

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

					if (sum < 50) {

						"不合格";
					} else {

						"合格";
					}

					// if文で合格ラインと不合格ライン決める
					// 計算ボタンを押した瞬間にアニメーションが動く

					TextView animationText = (TextView) findViewById(R.id.fugoukaku);
					Animation animation = AnimationUtils.loadAnimation(this, R.layout.activity_sample_anim);
					animationText.startAnimation(animation);

					TextView animationText = (TextView) findViewById(R.id.goukaku);
					Animation animation = AnimationUtils.loadAnimation(this, R.layout.activity_sample_anim);
					animationText.startAnimation(animation);


				}
			});
	}
}

