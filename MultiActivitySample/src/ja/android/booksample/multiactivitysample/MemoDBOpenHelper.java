package ja.android.booksample.multiactivitysample;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class MemoDBOpenHelper extends SQLiteOpenHelper {
	/**
	 * ここで扱うデータベースの名称です。
	 */
	private static final String DATABASE_NAME = "MEMO_DATA";

	/**
	 * データベースにテーブルを作成するSQL文です
	 */
	private static final String SQL_CREATE_TABLE = String
			.format("CREATE TABLE %1$s ( %2$s INTEGER PRIMARY KEY AUTOINCREMENT, %3$s TEXT NOT NULL, %4$s TEXT);",
					"memo_data", "_id", "title", "body");
	/**
	 * データベースのバージョンを示す値です。この値がデータベースのバージョン確認に用いられます。
	 */
	private static final int DATABASE_VERSION = 1;

	public MemoDBOpenHelper(Context context, String name,
			CursorFactory factory, int version) {
		super(context, name, factory, version);
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public MemoDBOpenHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION );
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(SQL_CREATE_TABLE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO 自動生成されたメソッド・スタブ

	}

}
