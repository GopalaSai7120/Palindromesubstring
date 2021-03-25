package com.sai.demo.service;

public class PalindromeService {
    public String longestPalindrome(String s) {

        if (s.length() <=1) return s;

        int start=0, end = 0;

        for (int i=0; i< s.length(); i++) {
            int len1 = expand (s,i,i);
            int len2 = expand (s,i, i+1);

            int fLen = Math.max(len1,len2);

            if (fLen > (end-start)) {
                start = i - (fLen-1)/2;
                end = i + fLen/2;
            }

        }

        return s.substring(start,end+1);
    }

    private int expand(String s, int left, int right) {
        if (s.length() == 0 || left > right) return 0;

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return right - left - 1;
    }
}
