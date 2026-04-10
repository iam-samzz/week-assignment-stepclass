public class Problem6 {
    // Linear Search
    public static void linearSearchThreshold(int[] unsortedRisks, int target) {
        int comps = 0;
        boolean found = false;
        for (int risk : unsortedRisks) {
            comps++;
            if (risk == target) {
                found = true;
                break;
            }
        }
        System.out.println("Linear: threshold=" + target + " -> " + (found ? "found" : "not found") + " (" + comps + " comps)");
    }

    // Binary Search for floor, ceiling, and insertion point
    public static void binarySearchFloorCeil(int[] sortedRisks, int target) {
        int low = 0, high = sortedRisks.length - 1;
        int floor = -1, ceil = -1, comps = 0;

        while (low <= high) {
            comps++;
            int mid = low + (high - low) / 2;

            if (sortedRisks[mid] == target) {
                floor = sortedRisks[mid];
                ceil = sortedRisks[mid];
                break;
            } else if (sortedRisks[mid] < target) {
                floor = sortedRisks[mid];
                low = mid + 1;
            } else {
                ceil = sortedRisks[mid];
                high = mid - 1;
            }
        }
        System.out.println("Binary floor(" + target + "): " + (floor == -1 ? "none" : floor) +
                ", ceiling: " + (ceil == -1 ? "none" : ceil) + " (" + comps + " comps)");
        System.out.println("Insertion point would be at index: " + low);
    }
}