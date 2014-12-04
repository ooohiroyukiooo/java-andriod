package com.example.gourmmy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class RecommendRecipeActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_recommend_recipe); //layoutをセットする
		ImageView imv = (ImageView) findViewById(R.id.imageView5); //idを取得してインスタンスに入れる
		imv.setOnClickListener(new OnClickListener() { //匿名クラス
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(RecommendRecipeActivity.this, OrderActivity.class);//OrderActivityに意図する
//				intent.putExtra("first_name", "太郎"); //idのfirst_nameと太郎をputする
//				intent.putExtra("family_name", "山田");
//				intent.putExtra("age", 20);

				startActivity(intent);
				//startActivityForResult(intent, 1); //startする
			}
		});
	}
}
