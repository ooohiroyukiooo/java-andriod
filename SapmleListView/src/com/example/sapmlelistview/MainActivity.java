package com.example.sapmlelistview;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {
	ListView list;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		list = (ListView)findViewById(R.id.listView1);
		String[]ary = {"項目1","項目2","項目3","項目4","項目5"};


		// thisはMainActivity自身
		// android.R.layout.simple_list_item_1はアンドロイドが標準に持っているレイアウト（どこにある？）

		ArrayAdapter<String>adapter =
				new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, ary);
		list.setAdapter(adapter);
	}
}
