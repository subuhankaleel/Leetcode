class Solution {
    public int divide(int dividend, int divisor) {
        // Edge case: overflow condition (-2^31 / -1 = 2^31, which overflows to max int)
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Determine the sign of the result
        // True if the result should be negative, False if positive
        boolean isNegative = (dividend < 0) ^ (divisor < 0);

        // Convert both numbers to negative to prevent overflow issues with MIN_VALUE
        int negativeDividend = dividend < 0 ? dividend : -dividend;
        int negativeDivisor = divisor < 0 ? divisor : -divisor;

        int quotient = 0;

        // Loop while the dividend is "greater than or equal" to the divisor in negative space
        // Remember: in negatives, -10 <= -3 means -10 has a larger absolute value than -3
        while (negativeDividend <= negativeDivisor) {
            int currentDivisor = negativeDivisor;
            int numSubtractions = 1;

            // Double the divisor and the subtraction count using left shift
            // Ensure we don't overflow past Integer.MIN_VALUE / 2 before shifting
            while (currentDivisor >= Integer.MIN_VALUE >> 1 && negativeDividend <= (currentDivisor << 1)) {
                currentDivisor <<= 1;
                numSubtractions <<= 1;
            }

            // Subtract the largest accumulated chunk from the dividend
            negativeDividend -= currentDivisor;
            // Add the corresponding number of subtractions to the quotient
            quotient += numSubtractions;
        }

        // Return the final quotient with the correct sign
        return isNegative ? -quotient : quotient;
    }
}v
