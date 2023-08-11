/*
 *      Longest Palindromic Substring
 */
public class LongestPalindrome {
    public static void main(String[] args) {
    
        String example = "babad";   //ANSWER: "bab" or "aba"
        String result = longestPalindrome(example);
        System.out.println(result);
    }

    public static String longestPalindrome(String s) {

        //Checking if string is just one character or else if it has length 2. 
        if (s.length() == 1) {
            return s;
        }
        else if (s.length() == 2) {
            if (s.charAt(0) == s.charAt(1)) {
                return s;
            } else {
                return String.valueOf(s.charAt(0));
            }
        }

        int length = s.length() - 1;
        int left = 0;
        int right = length;
        int j = 0;
        String result = "";


        for (int i=0; i<s.length(); i++) {
            right = length - i;
            left = i;
                                                                                // example: "cbbd"
            for (j = length-i; j>=i; j--) {                                     // outer loop: i=1, left=1, right=3
                if (left > j) {                                                 // 1: j=3, rigth--   => right=2
                    if (s.substring(i, right+1).length() > result.length()) {   // 2: j=2, left++    => left=2
                        result = s.substring(i, right+1);                       // 3: j=1, i=1       => left=2 > j=1 
                        return s.substring(i, right+1);                         // => substring(i=1, right+1=3) => "bb"
                    }
                }
                if (s.charAt(left) == s.charAt(j)) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }
}
