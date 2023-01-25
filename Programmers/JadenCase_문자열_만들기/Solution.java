package Programmers.JadenCase_문자열_만들기;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        boolean flag = true;
        for (String chr : s.split("")) {
            if (flag && !chr.equals(" ")) {
                sb.append(chr.toUpperCase());
                flag = false;
            } else if (!flag && !chr.equals(" ")) {
                sb.append(chr.toLowerCase());
            } else {
                sb.append(" ");
                flag = true;
            }
        }
        return sb.toString();
    }
}
