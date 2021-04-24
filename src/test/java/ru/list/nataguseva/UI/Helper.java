package ru.list.nataguseva.UI;

public class Helper {

    public static int getCount(String mailSearchResult) {
        String[] words = mailSearchResult.split(" ");
        return Integer.parseInt(words[0]);
    }
}
