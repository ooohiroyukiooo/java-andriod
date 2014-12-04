package com.example.webapisample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

public class WebAPILoader extends AsyncTaskLoader<JSONObject> {
	/**
	 * 天気を取得する都市IDです。
	 */
	private int mCityId;

	/**
	 * APIのURLです。
	 */
	private final static String API_URL = "http://weather.livedoor.com/forecast/webservice/json/v1?city=%1$d";

	public WebAPILoader(Context context, int cityId) {
		super(context);
		this.mCityId = cityId;
	}

	public WebAPILoader(Context context) {
		super(context);
		// TODO 自動生成されたコンストラクター・スタブ
	}

	@Override
	public JSONObject loadInBackground() {
		URL url;
		JSONObject result = null;
		try {

			// HTTPコネクションを作成する
			url = new URL(String.format(API_URL, mCityId));
			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			connection.setRequestMethod("GET");
			// 通信を開始する
			connection.connect();
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					connection.getInputStream()));
			// レスポンス文字列を取得する
			String line;
			StringBuilder lines = new StringBuilder();
			while ((line = reader.readLine()) != null) {
				lines.append(line);
			}
			String json = lines.toString();
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

	@Override
	protected void onStartLoading() {
		forceLoad();
		super.onStartLoading();
	}

}
