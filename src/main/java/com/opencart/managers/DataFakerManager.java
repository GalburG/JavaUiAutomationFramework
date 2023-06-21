package com.opencart.managers;

import com.github.javafaker.Faker;

public class DataFakerManager {

    private static Faker fakerObject = new Faker();

    public static String getRandomEmail(String prefix, String sufix) {
        String midPart = String.valueOf(fakerObject.random().nextInt(1, 999999999));
        return prefix + midPart + sufix;
    }

    public static String getRandomFirstName() {
        return fakerObject.funnyName().name();
    }

    public static String getRandomLastName() {
        return fakerObject.funnyName().name();
    }

    public static String getRandomPassword(int min, int max) {
        return fakerObject.internet().password(min, max);
    }


}
