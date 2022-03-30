package main.helpers;

import java.util.List;

public class CommonHelper {
    static public String FindFirst(List<String> list, String regex, String userStr) {
        int start = 0;
        int end = list.size() - 1;
        int mid = (start + end) / 2;
        String first = "";
        while (start <= end) {
            String tmp = list.get(mid);
            if (tmp.matches(regex)) {
                if (list.get(mid - 1).matches(regex)) {
                    first = String.copyValueOf(list.get(mid - 1).toCharArray());
                    mid--;
                } else {
                    first = String.copyValueOf(tmp.toCharArray());
                    break;
                }
            } else {
                if (tmp.toCharArray()[0] == '\"')
                {
                    if (tmp.substring(1).compareTo(userStr) < 0)
                        start = mid + 1;
                    else
                        end = mid - 1;
                }
                else {
                    if (tmp.compareTo(userStr) < 0)
                        start = mid + 1;
                    else
                        end = mid - 1;

                }
                mid = (start + end) / 2;
            }
        }
        return first;
    }

    static public int FindCountOfStr(List<String> list, String regex, String first) {
        int count = 0;
        int i = list.indexOf(first);
        while (list.get(i++).matches(regex))
            count++;
        return count;
    }

    static public boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
