package ja.android.booksample.webapisample;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Date;
import java.util.Calendar;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.AsyncTaskLoader;
import android.content.Context;

public class WebAPILoader extends AsyncTaskLoader<JSONObject> {

	private int mCityId;
	private boolean mEnableCache;

	public WebAPILoader(Context context,boolean enableCache, int cityId) {
		super(context);
		this.mEnableCache = enableCache; //追加
		this.mCityId = cityId;
	}

	public WebAPILoader(Context context) {
		super(context);
	}

	/**
	 * ローダー処理開始時呼び出されるメソッドです。 ロード開始処理を行います。
	 */
	@Override
	protected void onStartLoading() {
		forceLoad();
		super.onStartLoading();
	}

	/**
	 * サブスレッドで行いたい処理を記述します。
	 */
	@Override
	public JSONObject loadInBackground() {
		URL url;
		JSONObject result = null;
		try {
			File cachefile = new File(getContext().getCacheDir(), "weather.json");
			Calendar calendar = Calendar.getInstance();
			if (cachefile.exists()) {
				calendar.setTime(new Date(cachefile.lastModified()));
				calendar.add(Calendar.HOUR, 3);
			}
			String json;
			if (!mEnableCache || !cachefile.exists()
					|| calendar.getTime().before(new Date())) {
				// キャッシュファイルが無効な場合は、再読込を行う

				// HTTPコネクションを作成する
				url = new URL(String.format("http://weather.livedoor.com/forecast/webservice/json/v1?city=%1$d", mCityId));
				HttpURLConnection connection = (HttpURLConnection) url
						.openConnection();
				connection.setRequestMethod("GET");
				// 通信を開始する
				connection.connect();
				// JSONデータを取得する
				json = loadInputStream(connection.getInputStream());
				// 読み込んだデータをキャッシュデータとして保存する
				FileOutputStream cache = null;
				try {
					cache = new FileOutputStream(cachefile);
					cache.write(json.getBytes());
				} finally {
					if (cache != null) {
						cache.close();
					}
				}
			} else {
				// キャッシュファイルが有効な場合、キャッシュファイルを読み込む
				InputStream stream = new FileInputStream(cachefile);
				json = loadInputStream(stream);
			}
			// 取得したデータをJSONオブジェクトに変換する
			result = new JSONObject(json);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * ストリームから文字列を取得します。
	 *
	 * @param stream
	 *            入力ストリーム
	 * @return ストリームから読み込まれた文字列
	 * @throws IOException
	 *             入出力エラー
	 */
	private String loadInputStream(InputStream stream) throws IOException {
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(stream));
		// レスポンス文字列を取得する
		String line;
		StringBuilder lines = new StringBuilder();
		while ((line = reader.readLine()) != null) {
			lines.append(line);
		}
		return lines.toString();
	}
}
