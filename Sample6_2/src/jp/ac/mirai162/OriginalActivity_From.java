package jp.ac.mirai162;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class OriginalActivity_From extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.original_from);

		Button b1 = (Button) findViewById(R.id.from_button1);

		b1.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				// メッセージのテキストを書き換え
				TextView tv = (TextView) findViewById(R.id.message);
				tv.setText(R.string.button_start);

				// 自作Activityの呼び出し
				Intent intent = new Intent(OriginalActivity_From. //呼出元
						this,OriginalActivity_To.class); //呼出先
				startActivity(intent);
			}
		});
	}
}
