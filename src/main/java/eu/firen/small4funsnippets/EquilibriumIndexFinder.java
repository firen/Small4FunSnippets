package eu.firen.small4funsnippets;

import java.util.Arrays;

class EquilibriumIndexFinder {
    public int find(int[] A) {
        if( A == null || A.length == 0 ) {
            return -1;
        }
        long sumLeft = 0;
        long sumRight = Arrays.stream(A).asLongStream().sum();
        for( int p = 0; p < A.length; p++ ) {
            sumRight -= A[p];
            if(sumLeft == sumRight) {
                return p;
            } else {
                sumLeft += A[p];
            }
        }
        return -1;
    }
}
