package ja.android.booksample.webapisample;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class WeatherAdapter extends BaseAdapter {


	/**
	 * レイアウトの作成に用いるオブジェクトです
	 */
	private LayoutInflater mInflater;

	/**
	 * 内部的に使用するデータリストです
	 */
	private ArrayList<Weather> mItems;

	/**
	 * 定数の取得に用いるコンテキストです
	 */
	private Context mContext;

	public WeatherAdapter(Context context, ArrayList<Weather> items) {
		super();
		this.mContext = context;
		this.mInflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		this.mItems = items;
	}

	/**
	 * アダプターオブジェクトが保有するアイテム数を返却します。 ここでは、内部的に保持しているArrayListの値を直接返します。
	 */
	@Override
	public int getCount() {
		return mItems.size();
	}

	/**
	 * アダプターオブジェクトの任意の項目を取得するための処理を記述します。 ここでは、内部的に保持しているArrayListの値を直接返します。
	 */
	@Override
	public Object getItem(int position) {
		return mItems.get(position);
	}

	/**
	 * アダプターオブジェクトの任意の項目を取得するための処理を記述します。 この項目にはIDがないため、仮のIDとして項目インデックスを返します。
	 */
	@Override
	public long getItemId(int position) {
		return position;
	}

	/**
	 * ビューを設定します。
	 */
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			// レイアウトが未作成の場合、XMLよりレイアウトを作成
			convertView = mInflater
					.inflate(R.layout.item_weather, parent, false);
		}
		// 値の設定
		Weather weather = mItems.get(position);
		// 日付を示す文字列の設定
		TextView display_datelabel = (TextView) convertView
				.findViewById(R.id.display_datelabel);
		display_datelabel.setText(weather.getDateLabel());
		// 天気を示す文字列の設定
		TextView display_telop = (TextView) convertView
				.findViewById(R.id.display_telop);
		display_telop.setText(weather.getTelop());
		// 最低気温を示す文字列の設定
		TextView display_lowtemperture = (TextView) convertView
				.findViewById(R.id.display_lowtemperature);
		display_lowtemperture.setText(mContext.getString(
				R.string.display_lowtemperature, weather.getLowTemperture()));
		// 最高気温を示す文字列の設定
		TextView display_hightemperture = (TextView) convertView
				.findViewById(R.id.display_hightemperature);
		display_hightemperture.setText(mContext.getString(
				R.string.display_hightemperature, weather.getHighTemperture()));

		return convertView;
	}
}
