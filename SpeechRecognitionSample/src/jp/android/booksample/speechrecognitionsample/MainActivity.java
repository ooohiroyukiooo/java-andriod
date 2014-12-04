package jp.android.booksample.speechrecognitionsample;

import android.app.ListActivity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends ListActivity implements OnClickListener{

	private static final int REQUEST_SPEECHRECOGNIZE = 1;
	private ArrayAdapter<String> listAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		//イベントハンドラの設定
		Button operate_additem = (Button) findViewById(R.id.operate_additem);
		operate_additem.setOnClickListener(this);
		Button operate_deleteitem = (Button) findViewById(R.id.operate_deleteitem);
		operate_deleteitem.setOnClickListener(this);

		// リスト用のアダプタを設定
		listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
		setListAdapter(listAdapter);
	}

	@Override
	public void onClick(View v) {
		int id = v.getId();
		if (id == R.id.operate_additem) {
			//listAdapter.add("値の追加");
			//「追加」ボタン
			//音声認識ダイアログの表示を行うインテントの作成
			Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
			intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
			intent.putExtra(RecognizerIntent.EXTRA_PROMPT,this.getTitle());
		try {
			// 音声認識ダイアログの行事を行う
			startActivityForResult(intent, REQUEST_SPEECHRECOGNIZE);
		} catch (ActivityNotFoundException e) {
			Toast.makeText(MainActivity.this, R.string.wording_disablespeechrecognition, Toast.LENGTH_SHORT).show();
			e.printStackTrace();
		}


		} else if (id == R.id.operate_deleteitem) {
			if (listAdapter.getCount() > 0) {
				listAdapter.remove(listAdapter.getItem(listAdapter.getCount() - 1));
			}
		} else {

		}
	}
}
