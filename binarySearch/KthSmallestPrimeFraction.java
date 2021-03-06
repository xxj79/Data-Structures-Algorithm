package binarySearch;

//Need to find p, q
//We set condition to count<=K and keep a record of the p, q candidate who is the highest value less than mid.
//if count<=K left = mid, else high = mid.

public class KthSmallestPrimeFraction {
    int p, q;

    // O(n) for each check.
    boolean check(double mid, int[] A, int K) {
        int n = A.length;
        int p1 = 0, q1 = 0;
        int total = 0;

        for (int i = 0, j = 0; i < n; i++) {
            for (; j < n; j++) { // j will not backtrack.
                if (i < j && A[i] < A[j] * mid) {
                    if (p1 == 0 || p1 * A[j] < A[i] * q1) {
                        p1 = A[i];
                        q1 = A[j];
                    }
                    break;
                }
            }
            total += n - j;
        }
        if (total <= K) {
            if (p == 0 || p * q1 < p1 * q) {
                p = p1;
                q = q1;
            }
            return true;
        } else {
            return false;
        }
    }

    public int[] kthSmallestPrimeFraction(int[] A, int K) {
        p = q = 0;
        double low = 0.0; //double since the prime fraction is not an int
        double high = 1.0;
        // Around 30 times of iteration
        while (high - low > 1e-8) {
            double mid = (low + high) / 2.0;
            if (check(mid, A, K)) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return new int[] { p, q };
    }
}
