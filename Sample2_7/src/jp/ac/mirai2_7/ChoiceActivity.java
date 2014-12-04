package jp.ac.mirai2_7;

import android.app.Activity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class ChoiceActivity extends Activity {

	//TextView型のインスタンス変数
	TextView textView = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_choice);

		// TextView型のオブジェクトに対する参照を取得
		textView = (TextView) findViewById(R.id.textView);

		// RadioGroup型のオブジェクトに対する参照を取得
		RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);

		// RadioGroupに対してイベントリスナを設定
		radioGroup.setOnCheckedChangeListener(new RadioGroup. OnCheckedChangeListener() {

			// チェックが変更された場合のイベント
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {

				// RadioButton型のオブジェクトに対する参照を取得
				RadioButton radioButton = (RadioButton) findViewById(checkedId);

				// TextViewの表示を更新
				textView.setText(radioButton.getText());
			}
		});

		// CheckBox型のオブジェクトに対する参照を取得
		CheckBox checkbox1 = (CheckBox) findViewById(R.id.checkBox1);
		CheckBox checkbox2 = (CheckBox) findViewById(R.id.checkBox2);

		// イベントリスナを設定
		checkbox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton cb, boolean isChecked) {
				changeTextView(cb, isChecked);
			}
		});

		// イベントリスナを設定
		checkbox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton cb, boolean isChecked) {
				changeTextView(cb, isChecked);
			}
		});
	}

	private void changeTextView(CompoundButton cb, boolean isChecked) {
		CheckBox checkbox = (CheckBox) cb;
		textView.setText(checkbox.getText().toString() + ":" + isChecked);
	}
}
