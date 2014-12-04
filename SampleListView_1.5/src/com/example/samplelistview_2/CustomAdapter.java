package com.example.samplelistview_2;

import java.util.List;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends ArrayAdapter<SampleData> {

	private static final String TAG = "customadapter";
	LayoutInflater mInflater;

	/**
	 * コンストラクタ
	 *
	 * @param context
	 *            コンテキスト
	 * @param objects
	 *            行データ
	 */
	public CustomAdapter(Context context, List<SampleData> objects) {
		// 親のコンストラクタを呼び出す
		// ※ 2番目の引数はレイアウトのリソースIDだがgetViewで指定するのでここでは0を設定
		super(context, 0, objects);

		// インフレーターを取得する
		this.mInflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		Log.v(TAG, "getView"+ position);
		Log.v(TAG, "convertView"+ convertView);

		// ビューを設定する

		convertView = this.mInflater.inflate(R.layout.item_row, parent, false);

		TextView textView = (TextView) convertView.findViewById(R.id.textview1);
		ImageView imageView = (ImageView) convertView
				.findViewById(R.id.imageView1);

		// 指定された位置のアイテムを取得する
		SampleData data = getItem(position);

		// ※ convertViewに設定されている内容とgetItem(position)の内容が同じではないので再設定が必要
		imageView.setImageResource(data.resourceId);
		textView.setText(data.text);

		// 表示するビューを返す
		return convertView;
	}

}
