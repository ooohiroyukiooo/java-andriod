package jp.ac.mirai142;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class TouchEventView extends View implements OnTouchListener {

	// MotionEvent内の情報を保持するインスタンス変数
	int touchAction = 0;
	float touchX = 0.0f;
	float touchY = 0.0f;
	float touchSize = 0.0f;
	float touchPressure = 0.0f;

	// 描画座標
	private int drawX = 3;
	private int drawY = 40;

	private String action = "";

	// コンストラクタ
	public TouchEventView(Context context) {
		super(context);
		setBackgroundColor(Color.BLUE);
		setOnTouchListener(this);
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		touchAction = event.getAction();

		if(event.getAction() == MotionEvent.ACTION_DOWN) {
			action="押されたよ！";
		} else if (event.getAction() == MotionEvent.ACTION_HOVER_MOVE) {
			action="押したまま動いているよ！";
		} else if (event.getAction() == MotionEvent.ACTION_UP) {
			action="離されたよ！";
		}

		touchX = event.getX();
		touchY = event.getY();
		touchSize = event.getSize();
		touchPressure = event.getPressure();
		invalidate(); //再描画
		return true;
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		Paint paint = new Paint();
		paint.setColor(Color.WHITE);
		paint.setTextSize(16);

		canvas.drawText("touchAction= " + touchAction, drawX, drawY, paint);
		drawY += 20;
		canvas.drawText("touchX= " + touchX, drawX, drawY, paint);
		drawY += 20;
		canvas.drawText("touchY= " + touchY, drawX, drawY, paint);
		drawY += 20;
		canvas.drawText("touchSize= " + touchSize, drawX, drawY, paint);
		drawY += 20;
		canvas.drawText("touchPressure= " + touchPressure, drawX, drawY, paint);

		drawY = 40;
	}
}
