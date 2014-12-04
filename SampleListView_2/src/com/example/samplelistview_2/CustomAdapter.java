package com.example.samplelistview_2;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends ArrayAdapter<SampleData> {

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
		// ホルダークラスを定義する
		// ※ ホルダークラスを使うことで再表示時にレイアウト内のビュー検索が無くなり高速化されます
		ViewHolder holder;

		// ビューを設定する
		if (convertView == null) {
			// はじめて呼ばれた時はビューはnullが設定されている
			// ビューに定義したレイアウトをインフレートする
			convertView = this.mInflater.inflate(R.layout.item_row,
					parent, false);

			// ホルダークラスを生成する
			holder = new ViewHolder();

			// ホルダークラスにレイアウト内のビューを設定する
			holder.textView = (TextView) convertView
					.findViewById(R.id.textview1);
			holder.imageView = (ImageView) convertView
					.findViewById(R.id.imageView1);

			// タグにホルダークラスを設定する
			convertView.setTag(holder);
		} else {
			// 2回目以降はビューが設定されている
			// タグからホルダークラスを取得する
			holder = (ViewHolder) convertView.getTag();
		}

		// 指定された位置のアイテムを取得する
		SampleData data = getItem(position);

		// ホルダークラスのビューの値を設定する
		// ※ convertViewに設定されている内容とgetItem(position)の内容が同じではないので再設定が必要
		holder.imageView.setImageResource(data.resourceId);
		holder.textView.setText(data.text);

		// 表示するビューを返す
		return convertView;
	}

	/**
	 * ホルダクラス
	 */
	class ViewHolder {
		/** イメージビュー */
		ImageView imageView;

		/** テキストビュー */
		TextView textView;
	}
}
