package jp.android.booksample.arsample;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import android.app.Activity;
import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Face;
import android.hardware.Camera.FaceDetectionListener;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PictureCallback;
import android.os.Bundle;
import android.os.Environment;
import android.text.format.DateFormat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.WindowManager;

public class MainActivity extends Activity implements SurfaceHolder.Callback, AutoFocusCallback, PictureCallback, FaceDetectionListener{

	private Camera mCamera;
	/**
	 * 端末に具備されたカメラの個数を示す値です。
	 */
	private int mCameraCounts;

	/**
	 * 現在アプリケーションで使用されているカメラのIDを示す値です。
	 */
	private int mIdCameraUsing;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_main);

		// サーフェイスビューの設定
		SurfaceView surfaceView = (SurfaceView) findViewById(R.id.surfaceView1);
		SurfaceHolder holder = surfaceView.getHolder();
		holder.addCallback(this);

		// カメラ関連の変数初期化
		mCameraCounts = Camera.getNumberOfCameras();
		mIdCameraUsing = 0;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		// カメラが二つ以上ある場合にのみ、カメラの切り替え機能を有効にする
		menu.findItem(R.id.operate_switchcamera).setVisible(mCameraCounts > 1);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		boolean result;
		switch (item.getItemId()) {
		case R.id.operate_switchcamera:
			// カメラの切り替え処理
			// カメラのプレビューを停止
			setCamera(null);

			// 次のカメラIDを選択
			mIdCameraUsing = (mIdCameraUsing + 1) % mCameraCounts;
			// カメラを開く
			Camera camera = Camera.open(mIdCameraUsing);
			setCamera(camera);

			// カメラのプレビューを開始
			camera.startPreview();
			startFaceDetectionProc();

			result = true;
			break;
		case R.id.operate_shutter:
			// オートフォーカスの開始
			mCamera.autoFocus(this);
			result = true;
			break;
		default:
			result = super.onOptionsItemSelected(item);
			break;
		}
		return result;
	}

	@Override
	protected void onPause() {
		// TODO 自動生成されたメソッド・スタブ
		super.onPause();
		setCamera(null);
	}

	@Override
	protected void onResume() {
		super.onResume();
		// カメラを開く
		Camera camera = Camera.open(mIdCameraUsing);
		setCamera(camera);

		// カメラのプレビューを開始
		camera.startPreview();
	}
	// Camera.FaceDetectionListenerの実装

	/**
	 * 顔認識が行われたときのイベントハンドラです。
	 */
	@Override
	public void onFaceDetection(Face[] faces, Camera camera) {
		FaceDetectorView faceDetectorView1 = (FaceDetectorView) findViewById(R.id.faceDetectorView1);
		faceDetectorView1.setFaces(faces);
	}

	// SurfaceHolder.Callbackの実装

	/**
	 * サーフェイスが作成されるときに呼び出されます。
	 */
	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		setPreviewDisplay();

	}

	/**
	 * サーフェイスが削除されるときに呼び出されます。
	 */
	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		if (mCamera != null) {
			// プレビューの停止
			mCamera.stopPreview();
		}

	}

	/**
	 * サーフェイスが変更されるときに呼び出されます。
	 */
	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		if (mCamera != null) {
			// プレビューの再開
			mCamera.stopPreview();
			mCamera.startPreview();
			startFaceDetectionProc();
		}

	}

	// Camera.AutoFocusCallbackの実装

	@Override
	public void onAutoFocus(boolean success, Camera camera) {
		camera.takePicture(null, null, this);
	}

	// Camera.PictureCallbackの実装

	@Override
	public void onPictureTaken(byte[] data, Camera camera) {
		// 保存するファイル名を作成する
		File dir = Environment
				.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
		File file = new File(dir, DateFormat.format("yyyyMMdd_kkmmss",
				new Date()) + ".jpg");
		// ファイルに書き出す
		FileOutputStream fos = null;
		try {
			try {
				fos = new FileOutputStream(file);
				fos.write(data);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} finally {
			try {
				// ストリームを閉じる
				if (fos != null) {
					fos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			// カメラのプレビューを再開する
			camera.startPreview();
			startFaceDetectionProc();

		}

	}

	// その他ユーティリティメソッド

	/**
	 * 顔認識を行うための設定を行うメソッドです。
	 */
	private void startFaceDetectionProc() {
		// カメラが前と後ろどちらについているものかを確認
		CameraInfo info = new CameraInfo();
		Camera.getCameraInfo(mIdCameraUsing, info);
		FaceDetectorView faceDetectorView1 = (FaceDetectorView) findViewById(R.id.faceDetectorView1);
		faceDetectorView1
				.setFrontCamera(info.facing == CameraInfo.CAMERA_FACING_FRONT);

		// 顔認識の処理を開始
		Parameters parameter = mCamera.getParameters();
		if (parameter.getMaxNumDetectedFaces() > 0) {
			// 顔認識の開始
			mCamera.setFaceDetectionListener(this);
			mCamera.startFaceDetection();
		}
	}

	/**
	 * カメラを設定し、サーフェイスホルダーの値を更新します。
	*
	* @param camera
	*            カメラオブジェクト
	*/
	private void setCamera(Camera camera) {
		if (camera == null) {
			// カメラのプレビューを停止する
			mCamera.release();
		}
		mCamera = camera;
		if (camera != null) {
			// サーフェイスを更新する
			setPreviewDisplay();
		}

	}

	/**
	 * カメラのプレビュー表示に用いる{@link SurfaceHolder}を再設定します。
	 */
	private void setPreviewDisplay() {
		if (mCamera != null) {
			SurfaceView surfaceView = (SurfaceView) findViewById(R.id.surfaceView1);
			try {
				mCamera.setPreviewDisplay(surfaceView.getHolder());
				surfaceView.requestLayout();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}

	}


}
