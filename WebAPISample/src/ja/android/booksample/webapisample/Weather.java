package ja.android.booksample.webapisample;

public class Weather {

	private String mDateLabel;
	private String mTelop;
	private String mHighTemperture;
	private String mLowTemperture;

	/**
	 * 天気オブジェクトを初期化します。
	 */
	public Weather() {
		super();
		// 温度未設定時の文字列をあらかじめ格納
		this.mHighTemperture = "--";
		this.mLowTemperture = "--";
	}

	/**
	 * 日付を示す文字列を取得します
	 *
	 * @return 日付を示す文字列
	 */
	public String getDateLabel() {
		return mDateLabel;
	}

	/**
	 * 日付を示す文字列を設定します
	 *
	 * @param dateLabel
	 *            日付を示す文字列
	 */
	public void setDateLabel(String dateLabel) {
		this.mDateLabel = dateLabel;
	}

	/**
	 * 天気を示す文字列を取得します
	 *
	 * @return 天気を示す文字列
	 */
	public String getTelop() {
		return mTelop;
	}

	/**
	 * 天気を示す文字列を設定します
	 *
	 * @param telop
	 *            天気を示す文字列
	 */
	public void setTelop(String telop) {
		this.mTelop = telop;
	}

	/**
	 * 最高気温を示す文字列を取得します
	 *
	 * @return 最高気温を示す文字列
	 */
	public String getHighTemperture() {
		return mHighTemperture;
	}

	/**
	 * 最高気温を示す文字列を設定します
	 *
	 * @param highTemperture
	 *            最高気温を示す文字列
	 */
	public void setHighTemperture(String highTemperture) {
		this.mHighTemperture = highTemperture;
	}

	/**
	 * 最低気温を示す文字列を取得します
	 *
	 * @return 最低気温を示す文字列
	 */
	public String getLowTemperture() {
		return mLowTemperture;
	}

	/**
	 * 最低気温を示す文字列設定します
	 *
	 * @param lowTemperture
	 *            最低気温を示す文字列
	 */
	public void setLowTemperture(String lowTemperture) {
		this.mLowTemperture = lowTemperture;
	}

}
