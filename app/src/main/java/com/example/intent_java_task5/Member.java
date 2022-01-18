package com.example.intent_java_task5;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Member implements Parcelable {
    String kotlin;
    String java;
    public Member(String kotlin, String java) {
        this.kotlin = kotlin;
        this.java = java;
    }

    protected Member(Parcel in) {
        kotlin = in.readString();
        java = in.readString();
    }

    public static final Creator<Member> CREATOR = new Creator<Member>() {
        @Override
        public Member createFromParcel(Parcel in) {
            return new Member(in);
        }

        @Override
        public Member[] newArray(int size) {
            return new Member[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(kotlin);
        parcel.writeString(java);
    }

    @NonNull
    @Override
    public String toString() {
        return "Member{" +
                "kotlin='" + kotlin + '\'' +
                ", java='" + java + '\'' +
                '}';
    }
}
