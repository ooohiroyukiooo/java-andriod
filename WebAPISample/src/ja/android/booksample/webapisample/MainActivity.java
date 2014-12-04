package ja.android.booksample.webapisample;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.ListActivity;
import android.app.LoaderManager;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.Loader;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.TextView;

public class MainActivity extends ListActivity implements LoaderCallbacks<JSONObject>{

	/**
	 * WebAPIへのアクセス処理でキャッシュを有効にするかどうかを指定する、引数のキーです(bool)。
	 */
	private static final String ARGS_CACHE_ENABLED = "cache_enabled";

	/**
	 * WebAPIへのアクセスを行うローダーのIDです。
	 */
	private static final int ID_LOADER_API = 1;

	/**
	 * 天気予報取得用都市IDのうち、「横浜」を示す値です。
	 */
	private static final int CITY_ID = 140010;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_PROGRESS);
		requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
		setContentView(R.layout.activity_main);

		// 天気予報の読み込みを開始する
		LoaderManager manager = getLoaderManager();
		manager.initLoader(ID_LOADER_API, null, this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		boolean result;
		switch (item.getItemId()) {
		case R.id.operate_refresh:
			// 天気予報の情報を再読み込みする
			Bundle args = new Bundle();
			args.putBoolean(ARGS_CACHE_ENABLED, false);
			LoaderManager manager = getLoaderManager();
			manager.restartLoader(ID_LOADER_API, args, this);
			result = true;
			break;
		default:
			result = super.onOptionsItemSelected(item);
			break;
		}
		return result;
	}

	// LoaderCallbacks

		/**
		 * ローダーオブジェクトを初期化するときに呼び出されるメソッドです。 ローダーオブジェクトを生成し、それを返します。
		 */

	@Override
	public Loader<JSONObject> onCreateLoader(int id, Bundle args) {
		Loader loader = null;
		switch (id) {
		case ID_LOADER_API:
			// プログレスバーの表示を開始する
			setProgressBarVisibility(true);
			// ローダーオブジェクトを生成する
			boolean cache = true;
			if(args != null){
				// パラメータにて指定したキャッシュの値を反映する
				cache = args.getBoolean(ARGS_CACHE_ENABLED, true);
			}
			loader = new WebAPILoader(this, cache, CITY_ID);
			break;
		default:
			break;
		}
		return loader;
	}

	@Override
	public void onLoadFinished(Loader<JSONObject> loader, JSONObject data) {
		TextView display_lastupdate = (TextView) findViewById(R.id.display_lastupdate);
		TextView display_description = (TextView) findViewById(R.id.display_description);
		TextView display_copyright_text = (TextView) findViewById(R.id.display_copyright_text);
		TextView display_copyright_url = (TextView) findViewById(R.id.display_copyright_url);
		if (data != null) {
			try {
				JSONObject description = data.getJSONObject("description");
				// 最終更新日を反映
				display_lastupdate.setText(description.getString("publicTime"));
				// 時刻を反映
				display_description.setText(description.getString("text"));
				// 天気を反映
				JSONArray weathers_json = data.getJSONArray("forecasts");
				ArrayList<Weather> weathers = new ArrayList<Weather>();
				for (int i = 0; i < weathers_json.length(); i++) {
					JSONObject weather_json = (JSONObject) weathers_json.get(i);
					Weather weather = new Weather();
					weather.setDateLabel(weather_json.getString("dateLabel"));
					weather.setTelop(weather_json.getString("telop"));
					JSONObject temperature = weather_json
							.getJSONObject("temperature");
					// 最低気温を取得(観測できなかった場合は存在しないため、nullチェックを行う)
					if (!temperature.isNull("min")) {
						JSONObject temperature_min = temperature
								.getJSONObject("min");
						weather.setLowTemperture(temperature_min
								.getString("celsius"));
					}
					// 最高気温を取得(観測できなかった場合は存在しないため、nullチェックを行う)
					if (!temperature.isNull("max")) {
						JSONObject temperature_max = temperature
								.getJSONObject("max");
						weather.setHighTemperture(temperature_max
								.getString("celsius"));
					}
					// リストに追加
					weathers.add(weather);
				}
				// アダプタを設定
				WeatherAdapter adapter = new WeatherAdapter(this, weathers);
				setListAdapter(adapter);

				JSONObject copyright = data.getJSONObject("copyright");
				JSONObject image = copyright.getJSONObject("image");
				// コピーライト文章を反映
				display_copyright_text.setText(image.getString("title"));
				display_copyright_url.setText(image.getString("link"));

			} catch (JSONException e) {
				e.printStackTrace();
			}
		} else {
			// 読み込み失敗した旨を表示
			display_lastupdate.setText(R.string.display_loadfailed);
			display_description.setText(R.string.display_loadfailed);
			setListAdapter(null);
			display_copyright_text.setText(R.string.display_loadfailed);
			display_copyright_url.setText(R.string.display_loadfailed);
		}
		setProgressBarVisibility(false);
	}

	@Override
	public void onLoaderReset(Loader<JSONObject> arg0) {
		// TODO 自動生成されたメソッド・スタブ

	}
}
