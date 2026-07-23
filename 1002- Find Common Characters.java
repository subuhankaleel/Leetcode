import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> commonChars(String[] words) {
        // Frequency array to store minimum occurrences of each letter ('a' to 'z')
        int[] minFreq = new int[26];
        
        // Initialize minFreq with character counts from the first word
        for (char c : words[0].toCharArray()) {
            minFreq[c - 'a']++;
        }
        
        // Compare frequencies across all remaining words
        for (int i = 1; i < words.length; i++) {
            int[] currentFreq = new int[26];
            for (char c : words[i].toCharArray()) {
                currentFreq[c - 'a']++;
            }
            
            // Update minFreq to hold the minimum count for each character
            for (int j = 0; j < 26; j++) {
                minFreq[j] = Math.min(minFreq[j], currentFreq[j]);
            }
        }
        
        // Construct the output list from minFreq
        List<String> result = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            while (minFreq[i] > 0) {
                result.add(String.valueOf((char) (i + 'a')));
                minFreq[i]--;
            }
        }
        
        return result;
    }
}
