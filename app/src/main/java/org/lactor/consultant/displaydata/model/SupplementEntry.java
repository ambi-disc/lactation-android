package org.lactor.consultant.displaydata.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @Author Matthew Page
 * @Date 11/19/17
 */

public class SupplementEntry implements Parcelable {
    public long timestamp;
    public String supType;
    public String supMethod;
    public String numberDiapers;
    public String totalAmount;
    public String numberTimes;

    protected SupplementEntry(Parcel in) {
        timestamp = in.readLong();
        supType = in.readString();
        supMethod = in.readString();
        numberDiapers = in.readString();
        totalAmount = in.readString();
        numberTimes = in.readString();
    }

    public static final Creator<SupplementEntry> CREATOR = new Creator<SupplementEntry>() {
        @Override
        public SupplementEntry createFromParcel(Parcel in) {
            return new SupplementEntry(in);
        }

        @Override
        public SupplementEntry[] newArray(int size) {
            return new SupplementEntry[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(timestamp);
        parcel.writeString(supType);
        parcel.writeString(supMethod);
        parcel.writeString(numberDiapers);
        parcel.writeString(totalAmount);
        parcel.writeString(numberTimes);
    }
}
