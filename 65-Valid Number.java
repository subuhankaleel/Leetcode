lass Solution {
    public boolean isNumber(String s) {
        // Strip out leading/trailing whitespace if the environment doesn't do it automatically
        s = s.trim();
        
        boolean seenDigit = false;
        boolean seenDot = false;
        boolean seenExponent = false;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (Character.isDigit(c)) {
                seenDigit = true;
                
            } else if (c == '+' || c == '-') {
                // A sign is only valid at the beginning of the string 
                // OR immediately following an exponent character ('e' or 'E')
                if (i > 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') {
                    return false;
                }
                
            } else if (c == '.') {
                // A dot is invalid if we have already seen another dot 
                // OR if we have already seen an exponent
                if (seenDot || seenExponent) {
                    return false;
                }
                seenDot = true;
                
            } else if (c == 'e' || c == 'E') {
                // An exponent is invalid if we have already seen an exponent 
                // OR if we haven't encountered any digits yet
                if (seenExponent || !seenDigit) {
                    return false;
                }
                seenExponent = true;
                // Reset seenDigit to ensure there are digits following the exponent
                seenDigit = false;
                
            } else {
                // Any other character (like alphabets or special symbols) is immediately invalid
                return false;
            }
        }
        
        // The overall string is valid if we successfully parsed it and ended with a digit
        return seenDigit;
    }
}
