class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder result = new StringBuilder();
        int i = 0, j = 0;
        int n1 = word1.length(), n2 = word2.length();

        // Loop until all characters from both strings are processed
        while (i < n1 || j < n2) {
            if (i < n1) {
                result.append(word1.charAt(i++));
            }
            if (j < n2) {
                result.append(word2.charAt(j++));
            }
        
