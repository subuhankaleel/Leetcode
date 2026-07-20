class Solution {
    public int myAtoi(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int i = 0;
        int n = s.length();

        // 1. Skip leading whitespaces
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        // Check if we reached the end after spaces
        if (i == n) {
            return 0;
        }

        // 2. Check for optional sign
        int sign = 1;
        if (s.charAt(i) == '+' || s.charAt(i) == '-') {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        // 3. Convert characters to digits and handle overflow
        int result = 0;
        while (i < n) {
            char ch = s.charAt(i);
            
            // Stop if the character is not a digit
            if (ch < '0' || ch > '9') {
                break;
            }

            int digit = ch - '0';

            // 4. Rounding / Overflow Check
            // We check if result * 10 + digit will exceed Integer.MAX_VALUE
            if (result > Integer.MAX_VALUE / 10 || 
               (result == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = result * 10 + digit;
            i++;
        }

        return result * sign;
    }
}
