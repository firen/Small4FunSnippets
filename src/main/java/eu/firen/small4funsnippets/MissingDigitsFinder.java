package eu.firen.small4funsnippets;

import java.util.BitSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * MissingDigitsFinder contains tool methods to finding missing values in arrays in relation to sequence 1,2,...,n.
 */
public class MissingDigitsFinder {

    /**
     * Finds missing digit in {@code digits}. {@code digits} should not contain duplicates and only one missing value is allowed.
     * Implementation inspired by <a href="http://javarevisited.blogspot.com/2014/11/how-to-find-missing-number-on-integer-array-java.html">javarevisited</a>.
     *
     * @param digits
     * @param maxDigitInSequence
     * @return missing value in {@code digits}
     */

    public int findMissingDigit(Set<Integer> digits, int maxDigitInSequence) {
        if(digits.size() > maxDigitInSequence) {
            throw new IllegalArgumentException("maxDigitInSequence argument must be bigger or equals the size of digits array");
        }

        int sumOfCompleteSequence = (maxDigitInSequence+1)*maxDigitInSequence/2;
        int sumOfElementsInArray = digits.stream().mapToInt(i -> i.intValue()).sum();

        return sumOfCompleteSequence - sumOfElementsInArray;
    }

    /**
     * Finds all missing digits in {@code digits}.
     * Implementation inspired by <a href="http://javarevisited.blogspot.com/2014/11/how-to-find-missing-number-on-integer-array-java.html">javarevisited</a>.
     * Especially usage of BitSet.
     *
     * @param digits
     * @param maxDigitInSequence
     * @return list of missing values in {@code digits} list
     */
    public List<Integer> findMissingDigits(List<Integer> digits, int maxDigitInSequence) {
        if(digits.stream().anyMatch(i -> i > maxDigitInSequence)) {
            throw new IllegalArgumentException("maxDigitInSequence argument must be bigger or equals any element in the digits list");
        }
        BitSet bitSet = new BitSet(maxDigitInSequence);
        digits.forEach(i -> bitSet.set(i-1));

        return IntStream.range(1, maxDigitInSequence + 1).filter(i -> !bitSet.get(i - 1)).boxed().collect(Collectors.toList());
    }
}
