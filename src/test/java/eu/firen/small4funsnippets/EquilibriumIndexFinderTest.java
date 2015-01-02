package eu.firen.small4funsnippets;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by firen on 2015-01-02.
 */
public class EquilibriumIndexFinderTest {
    private EquilibriumIndexFinder equilibriumIndexFinder;

    @Before
    public void setUp() {
        equilibriumIndexFinder = new EquilibriumIndexFinder();
    }

    @Test
    public void shouldReturn1ForGivenSequence() {
        int result = equilibriumIndexFinder.find(new int[]{-1, 3, -4, 5, 1, -6, 2, 1});

        assertThat(result, is(1));
    }

    @Test
    public void shouldReturnLastIndexForGivenSequence() {
        int result = equilibriumIndexFinder.find(new int[]{-1, 1, 1});

        assertThat(result, is(2));
    }

    @Test
    public void shouldReturn_1ForEmptyTable() {
        int result = equilibriumIndexFinder.find(new int[0]);

        assertThat(result, is(-1));
    }

    @Test
    public void shouldReturn1ForIntegerOverflowingPositiveValues() {
        int result = equilibriumIndexFinder.find(new int[]{2147483647, 2147483647, 2147483647});

        assertThat(result, is(1));
    }

    @Test
    public void shouldReturn1ForIntegerOverflowingNegativeValues() {
        int result = equilibriumIndexFinder.find(new int[]{-2147483647, -2147483647, -2147483647});

        assertThat(result, is(1));
    }
}
