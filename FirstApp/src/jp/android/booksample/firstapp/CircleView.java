package jp.android.booksample.firstapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * 円を描画するビューです。
 */
public class CircleView extends View {

	Paint mFillPen;

	public CircleView(Context context) {
		super(context);
		init();
	}

	public CircleView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public CircleView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}

	/**
	 * 独自の初期化処理です。
	 */
	private void init() {
		mFillPen = new Paint();
		mFillPen.setAntiAlias(true);
		mFillPen.setColor(Color.BLUE);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		int w = getWidth();
		int h = getHeight();
		canvas.drawCircle(w / 2, h / 2, Math.min(w, h) / 2, mFillPen);
	}

}
