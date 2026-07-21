class Solution {
    public boolean detectCapitalUse(String word) {
        int capitals = 0;
        int n = word.length();

        // Count the number of capital letters in the word
        for (int i = 0; i < n; i++) {
            if (Character.isUpperCase(word.charAt(i))) {
                capitals++;
            }
        }

        // Case 1: All characters are capitals (e.g., "USA")
        if (capitals == n) {
            return true;
        }

        // Case 2: All characters are lowercase (e.g., "leetcode")
        if (capitals == 0) {
            return true;
        }

        // Case 3: Only the first character is capital (e.g., "Google")
        if (capitals == 1 && Character.isUpperCase(word.charAt(0))) {
            return true;
        }

        return false;
    }
}
