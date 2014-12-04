package com.example.sample_surfaceview;

import android.graphics.Bitmap;

public class Droid implements Runnable{
	private float x;
	private float toX;
	private float y;
	private float toY;
	private Thread thread;
	private Bitmap bm;
	private Bitmap[] bmAry;
	
	public Droid() {
		// TODO 自動生成されたコンストラクター・スタブ
		thread=new Thread(this);
		thread.start();
	}

	public float getX() {
		return x;
	}

	public void setToX(float toX) {
		this.toX = toX;
	}

	@Override
	public void run() {
		int cnt=0;
		while (thread!=null) {
			float def=toX-x;
			if(def>0){
				x++;
			}else if(def<0){
				x--;
			}else{
				//なにもしない
			}
			def=toY-y;
			if(def>0){
				y++;
			}else if(def<0){
				y--;
			}else{
				//なにもしない
			}
			bm=bmAry[cnt%bmAry.length];
			
			try {
				Thread.sleep(1000/120);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			cnt++;
		}
	}

	public float getY() {
		return y;
	}
	
	public void stop(){
		thread=null;
	}

	public void setToY(float toY) {
		this.toY = toY;
	}

	public Bitmap getBm() {
		return bm;
	}

	public void setBmAry(Bitmap[] bmAry) {
		this.bmAry = bmAry;
	}
}
