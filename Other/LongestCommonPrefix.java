public class LongestCommonPrefix {
    
    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {

        int currentCount;
        int maxCount = 0;
        int firstLength;
        int secondLength;
        int shortest;
        
        for (int i=0; i<strs.length-1; i++) {

            currentCount = 0;
            firstLength = strs[i].length();
            secondLength = strs[i+1].length();
            if (firstLength > secondLength) {
                shortest = secondLength;
            } else {
                shortest = firstLength;
            }

            for (int j=0; j<shortest; j++) {


                if(strs[i].charAt(j) == strs[i+1].charAt(j)) {
                    currentCount++;
                }

            }
            maxCount = Math.max(currentCount, maxCount);
        }
        
        

        System.out.println(maxCount);
        return strs[0].substring(0, maxCount);
    }

}
