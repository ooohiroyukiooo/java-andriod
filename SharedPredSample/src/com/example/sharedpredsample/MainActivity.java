package com.example.sharedpredsample;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView.BufferType;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		 Button saveButton = (Button)findViewById(R.id.bt_save);
	        saveButton.setOnClickListener(new OnClickListener() {
	            @Override
	            public void onClick(View arg0) {
	                saveButtonClick();
	            }
	        });

	        Button loadButton = (Button)findViewById(R.id.bt_load);
	        loadButton.setOnClickListener(new OnClickListener() {
	            @Override
	            public void onClick(View arg0) {
	                loadButtonClick();
	            }
	        });

	    }

	 private void saveButtonClick() {
	        // 保存
	        EditText editText = (EditText)findViewById(R.id.editText);

	        // 宣言
	        SharedPreferences sp ;

	        // getDefaultSharedPreferencesで標準プリファレンスの呼出
	        sp = PreferenceManager.getDefaultSharedPreferences(this);

	        // 書込用のオブジェクト
	        SharedPreferences.Editor editor;
	        editor = sp.edit();

	        // 書込用のオブジェクトに書き込む内容をputします
	        editor.putString("SaveString", editText.getText().toString());

	        // 書き込み実行
	        editor.commit();
	    }

	    private void loadButtonClick() {
	        // 読み込み
	        EditText editText = (EditText)findViewById(R.id.editText);
	        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
	        editText.setText(sp.getString("SaveString", null), BufferType.NORMAL);
	    }
}
