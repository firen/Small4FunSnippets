package eu.firen.small4funsnippets;

import com.google.common.collect.Sets;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by firen on 2014-11-29.
 */
public class FindOnlyOneMissingDigitNoDuplicates {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void shouldReturnZeroForEmptyZero() {
        final int maxDigitInSequence = 0;
        final Set<Integer> digits = new TreeSet<>();

        MissingDigitFinder missingDigitFinder = new MissingDigitFinder();
        int result = missingDigitFinder.findMissingDigit(digits, maxDigitInSequence);

        assertThat(result, is(0));
    }

    @Test
    public void shouldThrowExceptionWhenMaxDigitInSequenceIsLowerThanArrayLength() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("maxDigitInSequence argument must be bigger or equals the size of digits array");
        final int maxDigitInSequence = 1;
        final Set<Integer> digits = Sets.newTreeSet(Arrays.asList(1, 2));

        MissingDigitFinder missingDigitFinder = new MissingDigitFinder();
        missingDigitFinder.findMissingDigit(digits, maxDigitInSequence);
    }

    @Test
    public void shouldReturnMissingDigit() {
        final int maxDigitInSequence = 3;
        final Set<Integer> digits = Sets.newTreeSet(Arrays.asList(1, 3));

        MissingDigitFinder missingDigitFinder = new MissingDigitFinder();
        int result = missingDigitFinder.findMissingDigit(digits, maxDigitInSequence);

        assertThat(result, is(2));
    }

}
