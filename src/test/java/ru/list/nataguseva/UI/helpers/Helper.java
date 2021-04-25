package ru.list.nataguseva.UI.helpers;
import ru.list.nataguseva.UI.tests.*;

public class Helper {

    public static int getCount(String mailSearchResult) {
        String[] words = mailSearchResult.split(" ");
        return Integer.parseInt(words[0]);
    }
}
