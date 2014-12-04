package com.example.sample_surfaceview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class MySurfaceView extends SurfaceView implements
		SurfaceHolder.Callback, Runnable {

	Thread thread;
	SurfaceHolder holder;

	public MySurfaceView(Context context) {
		super(context);
		getHolder().addCallback(this);
	}

	@Override
	public void run() {
		float x = 0;
		Paint paint = new Paint();
		paint.setColor(Color.RED);
		paint.setStyle(Style.FILL);
		while (thread != null) {
			Canvas canvas = holder.lockCanvas();
			if (canvas != null) {
				canvas.drawColor(Color.WHITE);
				canvas.drawCircle(x, 200, 50, paint);
				holder.unlockCanvasAndPost(canvas);
				x++;
			}
		}
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		this.holder = holder;
		thread = new Thread(this);
		thread.start();
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		thread = null;
	}
}
