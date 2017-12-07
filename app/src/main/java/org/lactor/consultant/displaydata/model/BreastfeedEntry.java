package org.lactor.consultant.displaydata.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @Author Matthew Page
 * @Date 11/19/17
 */

public class BreastfeedEntry implements Parcelable {
    public long timestamp;
    public String breastfeedingduration;
    public String pumpingmethod;
    public String infantstate;
    public String maternalproblems;
    public String latching;
    public String side;
    public String pumpingamount;

    protected BreastfeedEntry(Parcel in) {
        timestamp = in.readLong();
        breastfeedingduration = in.readString();
        pumpingmethod = in.readString();
        infantstate = in.readString();
        maternalproblems = in.readString();
        latching = in.readString();
        side = in.readString();
        pumpingamount = in.readString();
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
        parcel.writeString(breastfeedingduration);
        parcel.writeString(pumpingmethod);
        parcel.writeString(infantstate);
        parcel.writeString(maternalproblems);
        parcel.writeString(latching);
        parcel.writeString(side);
        parcel.writeString(pumpingamount);
    }
}
