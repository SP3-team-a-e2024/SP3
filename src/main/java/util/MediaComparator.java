package util;

import java.util.Comparator;

public class MediaComparator implements Comparator<String> {
    @Override
    public int compare(String string1, String string2) {
        if (string1.length() != string2.length()) {
            return string1.length() - string2.length();
        }
        return string1.compareTo(string2);
    }
}
