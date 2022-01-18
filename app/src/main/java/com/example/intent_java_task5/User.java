package com.example.intent_java_task5;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class User implements Parcelable {

    private final String name;
    private final String surname;

    public User(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    protected User(Parcel in) {
        name = in.readString();
        surname = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    @NonNull
    @Override
    public String toString() {
        return name + " " + surname;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(surname);
    }
}
