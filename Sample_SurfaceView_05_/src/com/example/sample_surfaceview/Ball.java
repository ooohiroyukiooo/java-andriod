package com.example.sample_surfaceview;

import android.graphics.Color;

public class Ball implements Runnable{
	private float x;
	private float toX;
	private float y;
	private float toY;
	private float rad=50;
	private int color=Color.BLUE;
	private Thread thread;
	public Ball() {
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
			try {
				Thread.sleep(1000/120);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}
	}

	public float getY() {
		return y;
	}

	public float getRad() {
		return rad;
	}

	public int getColor() {
		return color;
	}
	
	public void stop(){
		thread=null;
	}

	public void setToY(float toY) {
		this.toY = toY;
	}
}
