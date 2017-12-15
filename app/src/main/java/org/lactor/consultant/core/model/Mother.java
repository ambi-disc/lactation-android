package org.lactor.consultant.core.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @Author Matthew Page
 * @Date 11/19/17
 */

public class Mother implements Parcelable {
    public String name;
    public int motherId;
    public String address;
    public String age;
    public String ethnicity;
    public String race;
    public String education;
    public String houseIncome;
    public String occupation;
    public String residence;
    public String parity; // NULL
    public String poh; // NULL
    public String mhdp;
    public String methodOfDelivery;
    public String pbe;
    public String phone;

    protected Mother(Parcel in) {
        name = in.readString();
        motherId = in.readInt();
        address = in.readString();
        age = in.readString();
        ethnicity = in.readString();
        race = in.readString();
        education = in.readString();
        houseIncome = in.readString();
        occupation = in.readString();
        residence = in.readString();
        parity = in.readString();
        poh = in.readString();
        mhdp = in.readString();
        methodOfDelivery = in.readString();
        pbe = in.readString();
        phone = in.readString();
    }

    public static final Creator<Mother> CREATOR = new Creator<Mother>() {
        @Override
        public Mother createFromParcel(Parcel in) {
            return new Mother(in);
        }

        @Override
        public Mother[] newArray(int size) {
            return new Mother[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeInt(motherId);
        parcel.writeString(address);
        parcel.writeString(age);
        parcel.writeString(ethnicity);
        parcel.writeString(race);
        parcel.writeString(education);
        parcel.writeString(houseIncome);
        parcel.writeString(occupation);
        parcel.writeString(residence);
        parcel.writeString(parity);
        parcel.writeString(poh);
        parcel.writeString(mhdp);
        parcel.writeString(methodOfDelivery);
        parcel.writeString(pbe);
        parcel.writeString(phone);
    }
}
