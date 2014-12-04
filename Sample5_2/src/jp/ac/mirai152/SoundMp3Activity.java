package jp.ac.mirai152;

import android.app.Activity;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SoundMp3Activity extends Activity implements OnClickListener,OnCompletionListener {

	private final float FONT_SIZE = 35;
	private MediaPlayer _mp = null;
	private Button _btn = null;

	@Override
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		setContentView(R.layout.activity_sound_mp3);

		_btn = (Button) findViewById(R.id.btn); // btnを_btnに変換している！
		_btn.setTextSize(FONT_SIZE);
		_btn.setOnClickListener(this);
	}

	// 再生するMP3ファイルのセット
	public void onStart() { // システムがonStartを呼び出してくれる。onCreateの次にシステムが呼ぶメソッド。
		super.onStart();
		_mp=MediaPlayer.create(this,R.raw.mp3sample01); // mp3sample01を持ってこいの意味

		// mp3sample01 がファイル名 拡張子.mp3は省略
		try {
			_mp.start();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		_mp.setOnCompletionListener(this);
	}

	// 再生・停止ボタンの制御
	@Override
	public void onClick(View arg0) {
		if (_mp.isPlaying()) {
			_mp.pause();
			_btn.setText("再生");
		} else {
			_mp.seekTo(0); // 0の位置に巻き戻しする意味
			_mp.start();
			_btn.setText("停止");
		}
	}

	// 終了処理・リソース解放
	public void onStop() {
		super.onStop(); // システムがonStopを呼び出してくれる。onStartの次にシステムが呼ぶメソッド。
		if (_mp != null) {
			if (_mp.isPlaying()) {
				_mp.stop();
			}
			_mp = null; // リソースの解放 必ずすること！！
		}
	}

	// MP3ファイル再生終了後の処理
	@Override
	public void onCompletion(MediaPlayer arg0) {
		// ボタン表示の更新
		_btn.setText("再生");
	}
}
