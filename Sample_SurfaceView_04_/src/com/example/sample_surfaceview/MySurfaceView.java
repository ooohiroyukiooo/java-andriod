package com.example.sample_surfaceview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

public class MySurfaceView extends SurfaceView implements
		SurfaceHolder.Callback, Runnable {

	//Ball ball;
	Droid droid;
	Thread thread;
	SurfaceHolder holder;

	public MySurfaceView(Context context) {
		super(context);
		getHolder().addCallback(this);
		//ball=new Ball();
		droid=new Droid();
		Bitmap bm1=BitmapFactory.decodeResource(
				context.getResources(), R.drawable.blue_1);
		Bitmap bm2=BitmapFactory.decodeResource(
				context.getResources(), R.drawable.blue_2);
		
		Bitmap[]bms={bm1,bm2};
		droid.setBmAry(bms);
		
		setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				droid.setToX(event.getX());
				droid.setToY(event.getY());
				return true;
			}
		});
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
				//paint.setColor(ball.getColor());
				//canvas.drawCircle((int)ball.getX(), (int)ball.getY(), ball.getRad(), paint);
				canvas.drawBitmap(droid.getBm(), droid.getX(), droid.getY(), paint);
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
		droid.stop();
		thread = null;
	}
}
