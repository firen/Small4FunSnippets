package eu.firen.small4funsnippets;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertThat;

/**
 * Created by firen on 2014-11-30.
 */
public class FibonacciTest {
    @Test
    public void shouldReturnZeroForZero() {
        FibonacciGenerator fibonacciGenerator = new FibonacciGenerator();

        Integer n = fibonacciGenerator.findValue(0);

        assertThat(n, is(0));
    }

    @Test
    public void shouldReturnOneForOne() {
        FibonacciGenerator fibonacciGenerator = new FibonacciGenerator();
        int n = fibonacciGenerator.findValue(1);

        assertThat(n, is(1));
    }

    @Test
    public void shouldReturn144For12() {
        FibonacciGenerator fibonacciGenerator = new FibonacciGenerator();
        int n = fibonacciGenerator.findValue(12);

        assertThat(n, is(144));
    }

    @Test
    public void shouldReturnMaxValueForIntegerPrecision() {
        FibonacciGenerator fibonacciGenerator = new FibonacciGenerator();

        Integer max = fibonacciGenerator.maxValue();

        Integer overflowedValue;

        Integer maxByHand = 0;
        Iterator<Integer> iterator = fibonacciGenerator.iterator();
        while (iterator.hasNext()) {
            maxByHand = iterator.next();
        }
        overflowedValue = iterator.next();

        assertThat(max, greaterThan(overflowedValue));
        assertThat(max, is(maxByHand));
    }

}
