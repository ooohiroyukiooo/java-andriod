package com.example.samplelistview_2;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		  // リストビューに表示する項目を生成する
        List<SampleData> list = new ArrayList<SampleData>();
        for (int i = 0; i < 10; i++) {
            list.add(new SampleData(R.drawable.ic_launcher, "項目" + i));
        }
 
        // リストビューを取得する
        ListView listView = (ListView) findViewById(R.id.listView1);
 
        // リストビューにカスタムしたリストアダプタを設定する
        listView.setAdapter(new CustomAdapter(this, list));
	}
}
