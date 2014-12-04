package jp.ac.mirai153;

import android.app.Activity;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoViewTest extends Activity {

	private final static String URL = "http://www.gomplayer.jp/img/sample/mp4_h264_aac.mp4";

	/*
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.video_view_test);
	}
	*/

	@Override
	public void onCreate(Bundle vTest) {
		super.onCreate(vTest);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		LinearLayout layout=new LinearLayout(this);
		layout.setBackgroundColor(Color.rgb(255,255,255));
		layout.setOrientation(LinearLayout.VERTICAL);
		setContentView(layout);

		VideoView videoView = new VideoView(this);
		videoView.requestFocus();
		videoView.setMediaController(new MediaController(this));
		setLayParams(videoView);
		layout.addView(videoView);// LinearLayoutに乗っけるのがaddView

		try {
			videoView.setVideoURI(Uri.parse(URL));
		}
		catch (Exception e) {}
	}

	private static void setLayParams(View view) {
		view.setLayoutParams(new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.WRAP_CONTENT,
				LinearLayout.LayoutParams.WRAP_CONTENT));
	}
}
