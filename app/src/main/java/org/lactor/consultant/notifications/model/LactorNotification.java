package org.lactor.consultant.notifications.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by nbeesett on 12/11/17.
 */

public class LactorNotification implements Parcelable {
    public String date;
    public boolean seenByMother;
    public String title;
    public String description;

    protected LactorNotification(Parcel in) {
        date = in.readString();
        seenByMother = in.readByte() != 0;
        title = in.readString();
        description = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(date);
        dest.writeByte((byte) (seenByMother ? 1 : 0));
        dest.writeString(title);
        dest.writeString(description);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<LactorNotification> CREATOR = new Creator<LactorNotification>() {
        @Override
        public LactorNotification createFromParcel(Parcel in) {
            return new LactorNotification(in);
        }

        @Override
        public LactorNotification[] newArray(int size) {
            return new LactorNotification[size];
        }
    };
}
