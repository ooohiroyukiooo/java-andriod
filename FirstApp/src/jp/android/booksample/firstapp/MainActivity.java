package jp.android.booksample.firstapp;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

/**
 * アプリケーションメインアクティビティ
 */
public class MainActivity extends Activity implements Runnable, OnClickListener {

	/**
	 * タイマーによりタイマースレッドで呼び出されるタイマー用のタスクです。
	 */
	public final class MyTimerTask extends TimerTask {

		/**
		 * タイマー用タスクのメソッドです。このメソッドが定期的に呼び出されます。
		 */
		@Override
		public void run() {
			// メインスレッドにて処理を実行させる
			MainActivity.this.runOnUiThread(MainActivity.this);
		}
	}

	/**
	 * タイマーの呼び出し間隔を示します。
	 */
	private static final long TIMER_PERIOD = 50;

	/**
	 * タイマーオブジェクトです。
	 */
	private Timer mTimer;

	/**
	 * 円がアニメーションを行うかどうかを格納する変数です。
	 */
	private boolean mMoving;

	/**
	 * アクティビティ状態を保存するBundleクラスのキーです。円のX位置を記録します(int)。
	 */
	private static final String STATE_CIRCLEPOS_X = "pos-x";

	/**
	 * アクティビティ状態を保存するBundleクラスのキーです。円のY位置を記録します(int)。
	 */
	private static final String STATE_CIRCLEPOS_Y = "pos-y";

	/**
	 * アクティビティ生成時に呼び出されます。
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mMoving = true;
		CircleView circleView1 = (CircleView) findViewById(R.id.circleView1);
		// イベントハンドラの設定
		circleView1.setOnClickListener(this);
		if (savedInstanceState != null) {
			// onSaveInstanceStateで保存した状態の復元
			circleView1.setX(savedInstanceState.getInt(STATE_CIRCLEPOS_X));
			circleView1.setY(savedInstanceState.getInt(STATE_CIRCLEPOS_Y));
		}
	}

	/**
	 * アクティビティの操作が可能になったタイミングで呼び出されます。
	 */
	@Override
	protected void onResume() {
		super.onResume();
		// タイマーを開始
		mTimer = new Timer(true);
		mTimer.schedule(new MyTimerTask(), TIMER_PERIOD, TIMER_PERIOD);
	}

	/**
	 * アクティビティが操作不能になったタイミングで呼び出されます。
	 */
	@Override
	protected void onPause() {
		super.onPause();
		// タイマーを停止
		mTimer.cancel();
	}

	/**
	 * アクティビティインスタンスの状態を保存する必要があるときに呼び出されます。　　
	 */
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		// 円の位置を保存
		CircleView circleView1 = (CircleView) findViewById(R.id.circleView1);
		outState.putInt(STATE_CIRCLEPOS_X, (int) circleView1.getX());
		outState.putInt(STATE_CIRCLEPOS_Y, (int) circleView1.getY());
	}

	/**
	 * タイマーにより「メインスレッドで」呼び出されます。
	 */
	@Override
	public void run() {
		CircleView circleView1 = (CircleView) findViewById(R.id.circleView1);
		// 実際に円を移動させる
		if (mMoving) {
			circleView1.setX(circleView1.getX() + 1);
			circleView1.setY(circleView1.getY() + 1);
		}
	}

	/**
	 * ビューがクリック(タップ)されたときに呼び出されます。
	 */
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.circleView1:
			// 円がタップされたときの処理
			// 円の動作を止める
			mMoving = false;
			// ダイアログの表示
			TouchDialog dialog = new TouchDialog();
			dialog.show(getFragmentManager(), "");
			break;
		default:
			break;
		}
	}

}
