package jp.android.booksample.arsample;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.hardware.Camera.Face;
import android.util.AttributeSet;
import android.view.View;

public class FaceDetectorView extends View {

	/**
	 * 認識された顔データを格納している配列です。
	 */
	private Face[] mFaces;

	/**
	 * 現在使用しているカメラがフロントカメラであるかどうかを示す値です。
	 * 前面カメラでは座標が左右逆になるため、変換する必要があります。
	 */
	private boolean mFrontCamera;

	/**
	 * 顔の四角形を描画するペイントオブジェクトです。
	 */
	private Paint mRectPen;

	/**
	 * プレビュー画像の座標系を画面上の座標に変換するためのマトリックスです。
	 */
	private Matrix mMatrix;

	public FaceDetectorView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		initialize();
	}

	public FaceDetectorView(Context context, AttributeSet attrs) {
		super(context, attrs);
		initialize();
	}

	public FaceDetectorView(Context context) {
		super(context);
		initialize();
	}

	/**
	 * オブジェクトの初期化処理を行います。
	 */
	private void initialize() {
		setFocusable(false);


		// 描画に用いられるオブジェクトを生成
		mRectPen = new Paint();
		mRectPen.setColor(Color.RED);
		mRectPen.setStyle(Paint.Style.STROKE);
		mRectPen.setStrokeWidth(8.0f);
		mMatrix = new Matrix();
	}

	/**
	 * 現在認識されている顔を示す{@link Face}の配列を設定します。
	 *
	 * @param faces
	 *            現在認識している顔を示す{@link Face}の配列
	 */
	public void setFaces(Face[] faces) {
		this.mFaces = faces;
		invalidate();
	}
	/**
	 * 現在認識されている顔を示す{@link Face}の配列を返します。
	 *
	 * @return 現在認識している顔を示す{@link Face}の配列
	 */
	public Face[] getFaces() {
		return mFaces;
	}

	/**
	 * 現在のカメラがフロントカメラであるかどうかの値を取得します。
	 *
	 * @return フロントカメラであればtrue
	 */
	public boolean isFrontCamera() {
		return mFrontCamera;
	}

	/**
	 * 現在のカメラがフロントカメラであるかどうかの値を設定します。
	 *
	 * @param frontCamera
	 *            フロントカメラであればtrue
	 */
	public void setFrontCamera(boolean frontCamera) {
		this.mFrontCamera = frontCamera;
		this.mFaces = null;
		invalidate();
	}

	/**
	 * 枠の描画処理です。
	 */
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		canvas.drawColor(Color.TRANSPARENT);
		if (mFaces != null) {
			// faceで得られる座標をプレビューの実座標に変換する
			mMatrix.setScale(mFrontCamera ? -1 : 1, 1);
			mMatrix.postScale(getWidth() / 2000f, getHeight() / 2000f);
			mMatrix.postTranslate(getWidth() / 2f, getHeight() / 2f);
			// 顔認識のマトリックスをキャンバスに反映
			canvas.concat(mMatrix);
 			// 現在のマトリックスを保存
			int saveCount = canvas.save();
			for (Face face : mFaces) {
				// 矩形を描画
				canvas.drawRect(face.rect, mRectPen);
			}
			// 保存したマトリックスを戻す
			canvas.restoreToCount(saveCount);
		}
	}

}
