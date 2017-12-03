package org.lactor.consultant.displaydata.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @Author Matthew Page
 * @Date 11/19/17
 */

public class BreastfeedEntry implements Parcelable {
    public long timestamp;
    public String breastfeedingDuration;
    public String pumpingMethod;
    public String infantState;
    public String maternalProblems;
    public String latching;
    public String side;
    public String pumpingAmount;

    protected BreastfeedEntry(Parcel in) {
        timestamp = in.readLong();
        breastfeedingDuration = in.readString();
        pumpingMethod = in.readString();
        infantState = in.readString();
        maternalProblems = in.readString();
        latching = in.readString();
        side = in.readString();
        pumpingAmount = in.readString();
    }

    public static final Creator<BreastfeedEntry> CREATOR = new Creator<BreastfeedEntry>() {
        @Override
        public BreastfeedEntry createFromParcel(Parcel in) {
            return new BreastfeedEntry(in);
        }

        @Override
        public BreastfeedEntry[] newArray(int size) {
            return new BreastfeedEntry[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(timestamp);
        parcel.writeString(breastfeedingDuration);
        parcel.writeString(pumpingMethod);
        parcel.writeString(infantState);
        parcel.writeString(maternalProblems);
        parcel.writeString(latching);
        parcel.writeString(side);
        parcel.writeString(pumpingAmount);
    }
}
