package com.kiwilss.xview.widget.tag;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 数据展示页的推荐热帖
 * 
 * @author yaohailong
 * @CreateAt 2016年1月28日
 *
 */
public class WeightHotTopicList implements Parcelable {


	/** 是否解决 1为是 0为否 */
	public int is_solve;
	/** 是否推举 1为是 0为否 */
	public int is_recommend;
	/** 是否精华1为是 0为否 */
	public int is_essence;
	/** 是否最优 1为是 0为否 */
	public int is_best;

	public WeightHotTopicList() {
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(this.is_solve);
		dest.writeInt(this.is_recommend);
		dest.writeInt(this.is_essence);
		dest.writeInt(this.is_best);
	}

	protected WeightHotTopicList(Parcel in) {
		this.is_solve = in.readInt();
		this.is_recommend = in.readInt();
		this.is_essence = in.readInt();
		this.is_best = in.readInt();
	}

	public static final Creator<WeightHotTopicList> CREATOR = new Creator<WeightHotTopicList>() {
		@Override
		public WeightHotTopicList createFromParcel(Parcel source) {
			return new WeightHotTopicList(source);
		}

		@Override
		public WeightHotTopicList[] newArray(int size) {
			return new WeightHotTopicList[size];
		}
	};
}
