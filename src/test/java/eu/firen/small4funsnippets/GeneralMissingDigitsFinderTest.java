package eu.firen.small4funsnippets;

import com.google.common.collect.Lists;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by firen on 2014-11-29.
 */
public class GeneralMissingDigitsFinderTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void shouldReturnEmptyListForEmptyArrayAndZero() {
        final int maxDigitInSequence = 0;
        final List<Integer> digits = new ArrayList<>();

        MissingDigitsFinder missingDigitsFinder = new MissingDigitsFinder();
        List<Integer> result = missingDigitsFinder.findMissingDigits(digits, maxDigitInSequence);

        assertThat(result, is(Lists.newArrayList()));
    }

    @Test
    public void shouldThrowExceptionWhenMaxDigitInSequenceIsLowerThanAnyElementInList() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("maxDigitInSequence argument must be bigger or equals any element in the digits list");
        final int maxDigitInSequence = 1;
        final List<Integer> digits = Lists.newArrayList(1, 2);

        MissingDigitsFinder missingDigitsFinder = new MissingDigitsFinder();
        missingDigitsFinder.findMissingDigits(digits, maxDigitInSequence);
    }

    @Test
    public void shouldReturnMissingDigits() {
        final int maxDigitInSequence = 4;
        final List<Integer> digits = Lists.newArrayList(1, 3);

        MissingDigitsFinder missingDigitsFinder = new MissingDigitsFinder();
        List<Integer> result = missingDigitsFinder.findMissingDigits(digits, maxDigitInSequence);

        assertThat(result, is(Lists.newArrayList(2, 4)));
    }

    @Test
    public void shouldReturnMissingDigitsInArrayWithDuplicates() {
        final int maxDigitInSequence = 4;
        final List<Integer> digits = Lists.newArrayList(1, 3, 3);

        MissingDigitsFinder missingDigitsFinder = new MissingDigitsFinder();
        List<Integer> result = missingDigitsFinder.findMissingDigits(digits, maxDigitInSequence);

        assertThat(result, is(Lists.newArrayList(2, 4)));
    }
}
