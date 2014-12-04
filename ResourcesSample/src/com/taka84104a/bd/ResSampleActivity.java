package com.taka84104a.bd;

import android.app.Activity;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;

public class ResSampleActivity extends Activity {

	// バイブレーターを使う場合はマニフェストのパーミッション記述を忘れずに！
	private Vibrator vibrator;
	private MediaPlayer mp;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
		mp = MediaPlayer.create(this, R.raw.sample);
		mp.setOnCompletionListener(new OnCompletionListener() {
			@Override
			public void onCompletion(MediaPlayer mp) {
			}
		});
	}

	public void buttonClick(View v) {
		if (mp.isPlaying()) {
			mp.pause();
			mp.seekTo(0);
		}
		mp.start();
		vibrator.vibrate(15);
	}

	@Override
	protected void onPause() {
		super.onPause();
		// これ、やっとかないと「戻るボタン」や「ホームボタン」押しても鳴りっぱなしになる
		if (mp.isPlaying()) {
			mp.pause();
			mp.seekTo(0);
		}
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		mp.release();
	}
}