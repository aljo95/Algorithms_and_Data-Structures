import java.util.Arrays;

public class LongestCommonPrefixImproved {
    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
        
    }   
    public static String longestCommonPrefix(String[] strs) {
        
        //strings sorted by alphabetical order: ["flight","flow","flower"]
        Arrays.sort(strs);

        String first = strs[0];
        String last = strs[strs.length - 1];

        int index = 0;
        while(index < first.length() && index < last.length()) {

            //because strings are sorted alphabetically we can just compare the first and last string elements
            if (first.charAt(index) == last.charAt(index)) {
                index++;
            } else {
                break;
            }
        }
        return first.substring(0, index);
    }
}
