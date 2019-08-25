package com.mathEasy;

public class ArrayWithNull
{
    public static GameCategories.Categories[] unnull(final GameCategories.Categories[] a) {
        int newRequiredSpaceInArray = 0;
        for (final GameCategories.Categories c : a) {
            if (c != null) {
                ++newRequiredSpaceInArray;
            }
        }
        final GameCategories.Categories[] arrayNonNull = new GameCategories.Categories[newRequiredSpaceInArray];
        int i = 0;
        for (final GameCategories.Categories c2 : a) {
            if (c2 != null) {
                arrayNonNull[i] = c2;
                ++i;
            }
        }
        return arrayNonNull;
    }
}
