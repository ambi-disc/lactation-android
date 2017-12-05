package org.lactor.consultant.displaydata.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @Author Matthew Page
 * @Date 11/19/17
 */

public class MorbidityEntry implements Parcelable {
    public long timestamp;
    public String type;

    protected MorbidityEntry(Parcel in) {
        timestamp = in.readLong();
        type = in.readString();
    }

    public static final Creator<MorbidityEntry> CREATOR = new Creator<MorbidityEntry>() {
        @Override
        public MorbidityEntry createFromParcel(Parcel in) {
            return new MorbidityEntry(in);
        }

        @Override
        public MorbidityEntry[] newArray(int size) {
            return new MorbidityEntry[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(timestamp);
        parcel.writeString(type);
    }
}
