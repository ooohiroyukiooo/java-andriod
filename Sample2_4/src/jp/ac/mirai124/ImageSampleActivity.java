package jp.ac.mirai124;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;

public class ImageSampleActivity extends Activity {

	// Wrap Contentを意味する定数
	private static final int WC = ViewGroup.LayoutParams.WRAP_CONTENT;

	// Fill Parentを意味する定数
	private static final int MP = ViewGroup.LayoutParams.MATCH_PARENT;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.image_sample);

		/*
		// リニアレイアウトを１つ生成します。
		LinearLayout linearLayout = new LinearLayout(this);
		linearLayout.setOrientation(LinearLayout.VERTICAL); //縦に並べる
		linearLayout.setLayoutParams(new LayoutParams(MP, MP));

		// ビューに対して、生成したリニアレイアウトをセットします。
		setContentView(linearLayout);

		// イメージビューを１つ生成します。
		ImageView imageView = new ImageView(this);
		imageView.setImageResource(R.drawable.kotori01);

		// リニアレイアウトに対して、生成したイメージビューをセットします。
		linearLayout.addView(imageView, new LayoutParams(WC, WC));

		// テキストビューを１つ生成します。
		TextView textView = new TextView(this);
		textView.setText(R.string.imageDescription);
		textView.setTextSize(16.0f);
		textView.setTextColor(Color.YELLOW);

		// リニアレイアウトに対して、生成したテキストビューをセットします。
		linearLayout.addView(textView, new LayoutParams(WC, WC));
		*/
	}
}
