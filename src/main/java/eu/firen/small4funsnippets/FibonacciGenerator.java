package eu.firen.small4funsnippets;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * Inspired by http://codereview.stackexchange.com/questions/42473/project-euler-even-fibonacci-numbers-in-java-8
 */
public class FibonacciGenerator implements Iterable<Integer> {

    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            private int previous = 1;
            private int beforePrevious = 0;
            private int currentIndex = 0;
            private int currentValue = 0;

            @Override
            public java.lang.Integer next() {
                if (currentIndex == 0) {
                    currentIndex++;
                    return 0;
                }
                if (currentIndex == 1) {
                    currentIndex++;
                    return 1;
                }
                if (currentIndex > 1) {
                    currentIndex++;
                    currentValue = beforePrevious + previous;
                    beforePrevious = previous;
                    previous = currentValue;
                    return currentValue;
                }
                throw new IllegalStateException(currentIndex + " is not valid index value");
            }

            @Override
            public boolean hasNext() {
                return currentValue < beforePrevious + previous;
            }
        };
    }

    public Stream<Integer> stream() {
        return StreamSupport.stream(Spliterators.spliteratorUnknownSize(iterator(), Spliterator.ORDERED), false);
    }

    public Integer findValue(int n) {
        return stream().skip(n).findFirst().get();
    }

    public Integer maxValue() {
        return stream().reduce((prev, current)-> current).get();
    }

    public long maxValuesCount() {
        return stream().count();
    }
}