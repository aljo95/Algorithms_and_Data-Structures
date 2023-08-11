/*
 *  Longest Substring Without Repeating Characters
 */

public class LongestSubstring {
    public static void main(String[] args) {

        String exampleString = "abcabcbb";

        int result = lengthOfLongestSubstring(exampleString);
        System.out.println(result);

    }
    public static int lengthOfLongestSubstring(String s) {

        char[] sChars = new char[s.length()];
        int count = 0;

        for (int i=0; i<s.length(); i++) {

            if (i > 0) {
                for (char j: sChars) {
                    if (j == s.charAt(i)) {
                        return count;
                    }
                }
            }
            sChars[i] = s.charAt(i);
            count++;
        }
        return count;
    }
}