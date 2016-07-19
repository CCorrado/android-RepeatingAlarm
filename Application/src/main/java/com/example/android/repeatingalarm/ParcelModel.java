package com.example.android.repeatingalarm;

import org.parceler.Parcel;

/**
 * Simple Parcel Model class to demonstrate marshalling/unmarshalling from pending intent issue w/ N
 */
@Parcel
public class ParcelModel {

    public String testString;
    public int    testInt;
    public long   testLong;

    public ParcelModel() { /* Default Constructor */ }

    public ParcelModel(String testString, int testInt, long testLong) {
        this.testString = testString;
        this.testInt = testInt;
        this.testLong = testLong;
    }
}
