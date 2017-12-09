package org.lactor.consultant.displaydata.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @Author Matthew Page
 * @Date 11/19/17
 */

public class SupplementEntry implements Parcelable {
    public String entryDate;
    public String suptype;
    public String supmethod;
    public String numberdiapers;
    public String totalamount;
    public String numbertimes;

    protected SupplementEntry(Parcel in) {
        entryDate = in.readString();
        suptype = in.readString();
        supmethod = in.readString();
        numberdiapers = in.readString();
        totalamount = in.readString();
        numbertimes = in.readString();
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
        parcel.writeString(entryDate);
        parcel.writeString(suptype);
        parcel.writeString(supmethod);
        parcel.writeString(numberdiapers);
        parcel.writeString(totalamount);
        parcel.writeString(numbertimes);
    }
}
