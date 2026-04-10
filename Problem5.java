import java.util.Arrays;

public class Problem5 {
    // Linear Search for first and last occurrence
    public static void linearSearch(String[] logs, String target) {
        int first = -1, last = -1, comps = 0;
        for (int i = 0; i < logs.length; i++) {
            comps++;
            if (logs[i].equals(target)) {
                if (first == -1) first = i;
                last = i;
            }
        }
        System.out.println("Linear First " + target + ": index " + first + " (" + comps + " comparisons)");
        // Time Complexity: O(N) [cite: 124]
    }

    // Binary Search to find exact match and count occurrences
    public static void binarySearchCount(String[] sortedLogs, String target) {
        int low = 0, high = sortedLogs.length - 1;
        int firstIndex = -1, comps = 0;

        while (low <= high) {
            comps++;
            int mid = low + (high - low) / 2;
            int cmp = sortedLogs[mid].compareTo(target);
            if (cmp == 0) {
                firstIndex = mid;
                high = mid - 1; // Keep searching left for the first occurrence
            } else if (cmp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        if (firstIndex != -1) {
            int count = 0;
            int i = firstIndex;
            while (i < sortedLogs.length && sortedLogs[i].equals(target)) {
                count++;
                i++;
            }
            System.out.println("Binary " + target + ": index " + firstIndex + " (" + comps + " comparisons), count = " + count);
        }
        // Time Complexity: O(log N) [cite: 125]
    }
}