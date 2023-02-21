package Programmers.전화번호_목록;

import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Map<String, String> map = new HashMap<>();
        for (String number : phone_book) {
            map.put(number, number);
        }
        for (String number : phone_book) {
            for (int i=1; i < number.length(); i++) {
                String part = number.substring(0, i);
                if (map.containsKey(part)) return false;
            }
        }
        return true;
    }
}
