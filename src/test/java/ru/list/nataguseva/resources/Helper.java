package ru.list.nataguseva.resources;

public class Helper {

    public static int getCount(String mailSearchResult) {
        String[] words = mailSearchResult.split(" ");
        return Integer.parseInt(words[0]);
    }
}
