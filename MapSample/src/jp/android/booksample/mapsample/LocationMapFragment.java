package jp.android.booksample.mapsample;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class LocationMapFragment extends Fragment {

	public LocationMapFragment() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		TextView view = new TextView(getActivity());
		Bundle param = getArguments();
		if(param != null) {
			String name = param.getString("place");
			view.setText(name);
		}
		return view;// 戻り値として設定したビューが、画面に表示される
	}

}
