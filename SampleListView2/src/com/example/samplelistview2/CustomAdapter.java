package com.example.samplelistview2;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends ArrayAdapter<SampleData> {

	private Object mInflater;

	public CustomAdapter(Context context, List<SampleData> objects) {
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
            convertView = this.mInflater.inflate(R.layout.sample_row, parent,
                    false);

            // ホルダークラスを生成する
            holder = new ViewHolder();

            // ホルダークラスにレイアウト内のビューを設定する
            holder.textView = (TextView) convertView
                    .findViewById(R.id.textView);
            holder.imageView = (ImageView) convertView
                    .findViewById(R.id.imageView);

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

/**
 * アダプタに設定するデータ
 */
class SampleData {
    /** 画像のリソースID */
    int resourceId;

    /** 文字列 */
    String text;

    /**
     * コンストラクタ
     *
     * @param resourceId
     *            画像のリソースID
     * @param text
     *            文字列
     */
    public SampleData(int resourceId, String text) {
        this.resourceId = resourceId;
        this.text = text;
    }
}
</sampledata></sampledata>
