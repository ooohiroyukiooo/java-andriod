package com.example.sample_surfaceview;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

public class MySurfaceView extends SurfaceView implements
		SurfaceHolder.Callback, Runnable {

	private static final String TAG = null;
	// Ball ball;
	// Droid droid;
	ArrayList<Droid> droidAry = new ArrayList<Droid>();
	Thread thread;
	SurfaceHolder holder;

	Droid movableDroid;

	int[][] idAry = { { R.drawable.droid_blue1, R.drawable.droid_blue2 },
			{ R.drawable.droid_green1, R.drawable.droid_green2 },
			{ R.drawable.droid_red1, R.drawable.droid_red2 } };

	public MySurfaceView(Context context) {
		super(context);
		getHolder().addCallback(this);
		// ball=new Ball();

		for (int i = 0; i < idAry.length; i++) {
			Droid droid = new Droid();
			Bitmap[] bms = new Bitmap[idAry[i].length];
			for (int j = 0; j < bms.length; j++) {
				bms[j] = BitmapFactory.decodeResource(context.getResources(),
						idAry[i][j]);
			}
			// Bitmap bm1 = BitmapFactory.decodeResource(context.getResources(),
			// R.drawable.blue_1);
			// Bitmap bm2 = BitmapFactory.decodeResource(context.getResources(),
			// R.drawable.blue_2);
			// Bitmap[] bms = { bm1, bm2 };
			droid.setBmAry(bms);
			droid.setX(bms[0].getWidth() * i);
			droid.setToX(bms[0].getWidth() * i);
			droid.setMovable(false);
			droidAry.add(droid);
		}

		setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				float x = event.getX();
				float y = event.getY();

				boolean onDroid = false;
				for (int i = 0; i < droidAry.size(); i++) {
					Droid d=droidAry.get(i);
					
					RectF rect = d.getRect();
					if (rect.contains(x, y)) {
						//movableDroid = droidAry.get(i);
						d.setMovable(true);
						onDroid = true;
						movableDroid=d;
					} else {
						d.setMovable(false);
					}
				}
				if (!onDroid) {
					movableDroid.setToX(x);
					movableDroid.setToY(y);
				}

				return true;
			}
		});
		for (int i = 0; i < droidAry.size(); i++) {
			droidAry.get(i).start();
		}
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
				// paint.setColor(ball.getColor());
				// canvas.drawCircle((int)ball.getX(), (int)ball.getY(),
				// ball.getRad(), paint);
				for (int i = 0; i < droidAry.size(); i++) {
					Droid d = droidAry.get(i);
					Log.v(TAG, d.getBm()+"");
					canvas.drawBitmap(d.getBm(), d.getX(), d.getY(), paint);
				}

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
		for (int i = 0; i < droidAry.size(); i++) {
			droidAry.get(i).stop();
		}
		thread = null;
	}
}
