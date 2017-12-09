package org.lactor.consultant.displaydata.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @Author Matthew Page
 * @Date 11/19/17
 */

public class OutputEntry implements Parcelable {
    public long timestamp;
    public String urinecolor;
    public String urinesaturation;
    public String stoolcolor;
    public String stoolconsistency;
    public String numberdiapers;

    protected OutputEntry(Parcel in) {
        timestamp = in.readLong();
        urinecolor = in.readString();
        urinesaturation = in.readString();
        stoolcolor = in.readString();
        stoolconsistency = in.readString();
        numberdiapers = in.readString();
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
        parcel.writeString(urinecolor);
        parcel.writeString(urinesaturation);
        parcel.writeString(stoolcolor);
        parcel.writeString(stoolconsistency);
        parcel.writeString(numberdiapers);
    }
}
