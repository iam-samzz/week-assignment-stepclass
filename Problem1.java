import java.util.List;
import java.util.ArrayList;

class Transaction {
    String id;
    double fee;
    String timestamp;

    public Transaction(String id, double fee, String timestamp) {
        this.id = id;
        this.fee = fee;
        this.timestamp = timestamp;
    }

    @Override
    public String toString() { return id + ":" + fee + "@" + timestamp; }
}

public class Problem1 {
    // Bubble Sort: adjacent swaps, early termination [cite: 13]
    public static void bubbleSortAsc(List<Transaction> list) {
        int n = list.size();
        int swaps = 0, passes = 0;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            passes++;
            for (int j = 0; j < n - i - 1; j++) {
                if (list.get(j).fee > list.get(j + 1).fee) {
                    Transaction temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                    swapped = true;
                    swaps++;
                }
            }
            if (!swapped) break;
        }
        System.out.println("Passes: " + passes + ", Swaps: " + swaps);
    }

    // Insertion Sort: building sorted subarray, shift operations [cite: 14]
    public static void insertionSort(List<Transaction> list) {
        for (int i = 1; i < list.size(); i++) {
            Transaction key = list.get(i);
            int j = i - 1;
            while (j >= 0) {
                Transaction curr = list.get(j);
                if (curr.fee > key.fee || (curr.fee == key.fee && curr.timestamp.compareTo(key.timestamp) > 0)) {
                    list.set(j + 1, list.get(j));
                    j--;
                } else {
                    break;
                }
            }
            list.set(j + 1, key);
        }
    }

    public static void flagOutliers(List<Transaction> list) {
        for (Transaction t : list) {
            if (t.fee > 50.0) {
                System.out.println("High-fee outlier: " + t.id);
            }
        }
    }
}