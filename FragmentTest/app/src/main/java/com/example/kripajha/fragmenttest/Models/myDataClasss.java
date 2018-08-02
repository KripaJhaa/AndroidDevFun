package com.example.kripajha.fragmenttest.Models;

import android.os.Parcel;
import android.os.Parcelable;

public class myDataClasss {
    public String  name;
    public int id;

    public  myDataClasss(String str,int id){
        this.name=str;
        this.id=id;
    }
//
//    public myDataClasss(Parcel in) {
//        this.name = in.readString();
//        this.id=in.readInt();
//    }
//    @Override
//    public void writeToParcel(Parcel parcel, int i) {
//
//    }
//
//    public static final Parcelable.Creator<myDataClasss> CREATOR
//            = new Parcelable.Creator<myDataClasss>() {
//        public myDataClasss createFromParcel(Parcel in) {
//            return new myDataClasss(in);
//        }
//
//        public myDataClasss[] newArray(int size) {
//            return new myDataClasss[size];
//        }
//    };
//
//
//
//    @Override
//    public int describeContents() {
//        return 0;
//    }

}
