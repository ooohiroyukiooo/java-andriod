package jp.ac.mirai123;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class GraphicSampleView extends View {
	// 画面中心の位置の、x座標を取得
	private int centerX = 0;

	// 画面中心の位置の、y座標を取得
	private int centerY = 0;

	public GraphicSampleView(Context context) {
		super(context);

		setFocusable(false);
	}

	@Override
	protected void onDraw(Canvas canvas) {

		super.onDraw(canvas);

		// 背景色の設定を行う。
		canvas.drawColor(Color.BLACK);

		// 描画用のオブジェクトを生成する。
		Paint paint = new Paint();

		// アンチエイリアス処理を有効にする。
		paint.setAntiAlias(true);

		// 塗りつぶしスタイルにする。
		paint.setStyle(Paint.Style.FILL);

		// 四角形を描画してみる。
		paint.setColor(Color.BLUE);
		canvas.drawRect(10, 100, 60, 150, paint);

		// 円を描画してみる。
		paint.setColor(Color.RED);
		canvas.drawCircle(centerX, centerY, 80, paint);

		// 直線を描画してみる。
		paint.setColor(Color.WHITE);
		canvas.drawLine(40, 300, 140, 320, paint);
	}

	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {

		super.onSizeChanged(w, h, oldw, oldh);

		// 画面の幅の中央のx座標を算出する。
		centerX = w / 2;
		centerY = h / 2;
	}
}
