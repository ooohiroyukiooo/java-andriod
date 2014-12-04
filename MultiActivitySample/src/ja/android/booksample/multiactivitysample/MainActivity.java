package ja.android.booksample.multiactivitysample;

import android.app.ListActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.Menu;
import android.view.MenuItem;

//リストアクティビティに変更
public class MainActivity extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		MemoDBOpenHelper helper = new MemoDBOpenHelper(this); // コンストラクタ呼出
		SQLiteDatabase db = helper.getWritableDatabase(); // DBの生成

		// データベースクエリの発行
		// Cursorはレコードのかたまり
		// queryを投げている
		Cursor c = db.query("memo_data", null, null, null, null, null, null);

		// 表示する値の用意
		String[] from = new String[] { "title", "body" };
		int[] to = new int[] { android.R.id.text1, android.R.id.text2 };
		SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,
				android.R.layout.simple_list_item_2, c, from, to, 0);
		setListAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		boolean result;
		switch (item.getItemId()) {
		case R.id.operate_additem:
			// 「追加」メニュー
			result = true;
			break;
		case R.id.operate_deleteitem:
			// 「削除」メニュー
			result = true;
			break;
		default:
			result = super.onOptionsItemSelected(item);
			break;
		}
		return result;
	}


}
