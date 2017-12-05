package org.lactor.consultant.displaydata.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @Author Matthew Page
 * @Date 11/19/17
 */

public class OutputEntry implements Parcelable {
    public long timestamp;
    public String urineColor;
    public String urineSaturation;
    public String stoolColor;
    public String stoolConsistency;
    public String numberDiapers;

    protected OutputEntry(Parcel in) {
        timestamp = in.readLong();
        urineColor = in.readString();
        urineSaturation = in.readString();
        stoolColor = in.readString();
        stoolConsistency = in.readString();
        numberDiapers = in.readString();
    }

    public static final Creator<OutputEntry> CREATOR = new Creator<OutputEntry>() {
        @Override
        public OutputEntry createFromParcel(Parcel in) {
            return new OutputEntry(in);
        }

        @Override
        public OutputEntry[] newArray(int size) {
            return new OutputEntry[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(timestamp);
        parcel.writeString(urineColor);
        parcel.writeString(urineSaturation);
        parcel.writeString(stoolColor);
        parcel.writeString(stoolConsistency);
        parcel.writeString(numberDiapers);
    }
}
