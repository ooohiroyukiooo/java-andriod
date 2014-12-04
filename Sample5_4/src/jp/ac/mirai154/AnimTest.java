package jp.ac.mirai154;

import android.app.Activity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class AnimTest extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_anim_test);

		ImageView animationImage = (ImageView) findViewById(R.id.mogu);
		Animation animation = AnimationUtils.loadAnimation(this, R.anim.anim_set);
		animationImage.startAnimation(animation);
	}
}
