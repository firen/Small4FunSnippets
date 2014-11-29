package eu.firen.small4funsnippets;

import java.util.Set;

/**
 * MissingDigitFinder contains tool methods to finding missing values in arrays in relation to sequence 1,2,...,n.
 */
public class MissingDigitFinder {

    /**
     * Finds missing digit in {@code digits}. {@code digits} should not contain duplicates and only one missing value is allowed.
     *
     * @param digits
     * @param maxDigitInSequence
     * @return missing value in digits array
     */

    public int findMissingDigit(Set<Integer> digits, int maxDigitInSequence) {
        if(digits.size() > maxDigitInSequence) {
            throw new IllegalArgumentException("maxDigitInSequence argument must be bigger or equals the size of digits array");
        }

        int sumOfCompleteSequence = (maxDigitInSequence+1)*maxDigitInSequence/2;
        int sumOfElementsInArray = digits.stream().mapToInt(i -> i.intValue()).sum();

        return sumOfCompleteSequence - sumOfElementsInArray;
    }
}
