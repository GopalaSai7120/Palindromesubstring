# Palindromesubstring
Longest palindrome using REST api

1. Spring Boot
2. Spring REST API
3. Spring Data JPA-Data access layer
4. Spring H2- for database

<------Longest Palindrome SubString Logic------>

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

Test#1

![1](https://user-images.githubusercontent.com/44416146/112493997-a7f9d400-8d50-11eb-9348-326e4c4cfdf2.PNG)

Test#2
![2](https://user-images.githubusercontent.com/44416146/112494551-25bddf80-8d51-11eb-87b4-ba29caf4a9c6.PNG)

get api call output
![3](https://user-images.githubusercontent.com/44416146/112494599-2fdfde00-8d51-11eb-821a-b4ecb6ee6342.PNG)

Database
![4](https://user-images.githubusercontent.com/44416146/112494652-3b330980-8d51-11eb-9436-d7c8c27bece1.PNG)
