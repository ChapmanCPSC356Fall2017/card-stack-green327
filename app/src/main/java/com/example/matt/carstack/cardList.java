package com.example.matt.carstack;

/**
 * Created by Matt on 11/6/2017.
 */

public class cardList extends MainActivity {
    public int suit;
    public int value;

    public cardList(int suit, int value)
    {
        this.suit = suit;
        this.value = value;
    }

    public int getSuit()
    {
        return this.suit;
    }

    public int getValue()
    {
        return this.value;
    }
}
