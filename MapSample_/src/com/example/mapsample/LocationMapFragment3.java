package com.example.mapsample;

	import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

	public class LocationMapFragment3 extends MapFragment {

		@Override
		public void onResume() {
			super.onResume();
			GoogleMap map = getMap();

			// マップの設定を規定する
			map.setIndoorEnabled(false);
			map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
			map.setMyLocationEnabled(false);
			map.setTrafficEnabled(false);

			// インターフェースコントロールの配置を行う
			UiSettings ui = map.getUiSettings();
			ui.setZoomControlsEnabled(true);
			ui.setZoomGesturesEnabled(true);

			// パラメータに格納された座標を指定する
			Bundle param = getArguments();
			if (param != null) {
				LatLng latlng = param
						.getParcelable("latlng");
				String name = param.getString("place");

				// カメラの移動を行う
				CameraPosition position = new CameraPosition(latlng, 13.0f, 0, 0);
				CameraUpdate update = CameraUpdateFactory
						.newCameraPosition(position);
				map.moveCamera(update);

				// マーカーの配置を行う
				MarkerOptions options = new MarkerOptions();
				options.position(latlng);
				options.title(name);
				options.snippet(latlng.toString());
				map.addMarker(options);
			}
		}

	}
