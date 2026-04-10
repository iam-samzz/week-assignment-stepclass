import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- PROBLEM 1: Transactions ---");
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction("id1", 10.5, "10:00")); // [cite: 29]
        transactions.add(new Transaction("id2", 25.0, "09:30")); // [cite: 30]
        transactions.add(new Transaction("id3", 5.0, "10:15"));  // [cite: 31]

        System.out.println("Original: " + transactions);
        Problem1.bubbleSortAsc(transactions);
        System.out.println("BubbleSort (fees): " + transactions); // [cite: 32]

        Problem1.insertionSort(transactions);
        System.out.println("InsertionSort (fee+ts): " + transactions); // [cite: 33]
        Problem1.flagOutliers(transactions);

        System.out.println("\n--- PROBLEM 2: Client Risk ---");
        Client[] clients = {
                new Client("clientC", 80, 1000), // [cite: 58]
                new Client("clientA", 20, 5000), // [cite: 58]
                new Client("clientB", 50, 2500)  // [cite: 58]
        };
        Problem2.bubbleSortAsc(clients);
        System.out.println("Bubble (asc): " + Arrays.toString(clients)); // [cite: 58]

        Problem2.insertionSortDesc(clients);
        System.out.println("Insertion (desc): " + Arrays.toString(clients)); // [cite: 58]
        Problem2.printTop10Risks(clients); // [cite: 58]

        System.out.println("\n--- PROBLEM 3: Trade Volume ---");
        Trade[] trades = {
                new Trade("trade3", 500), // [cite: 85]
                new Trade("trade1", 100), // [cite: 85]
                new Trade("trade2", 300)  // [cite: 85]
        };
        Trade[] tradesForMerge = trades.clone();
        Problem3.mergeSort(tradesForMerge, 0, tradesForMerge.length - 1);
        System.out.println("MergeSort (asc): " + Arrays.toString(tradesForMerge)); // [cite: 86]

        Trade[] tradesForQuick = trades.clone();
        Problem3.quickSort(tradesForQuick, 0, tradesForQuick.length - 1);
        System.out.println("QuickSort (desc): " + Arrays.toString(tradesForQuick)); // [cite: 87]
        System.out.println("Total Volume: " + Problem3.computeTotalVolume(trades)); // [cite: 87]

        System.out.println("\n--- PROBLEM 4: Portfolio Returns ---");
        Asset[] assets = {
                new Asset("AAPL", 12.0, 1.5), // [cite: 109]
                new Asset("TSLA", 8.0, 3.0),  // [cite: 109]
                new Asset("GOOG", 15.0, 1.2)  // [cite: 109]
        };
        Asset[] assetsMerge = assets.clone();
        Problem4.mergeSort(assetsMerge, 0, assetsMerge.length - 1);
        System.out.println("Merge (asc): " + Arrays.toString(assetsMerge)); // [cite: 110]

        Asset[] assetsQuick = assets.clone();
        Problem4.quickSort(assetsQuick, 0, assetsQuick.length - 1);
        System.out.println("Quick (desc): " + Arrays.toString(assetsQuick)); // [cite: 110]

        System.out.println("\n--- PROBLEM 5: Account ID Lookup ---");
        String[] logs = {"accB", "accA", "accB", "accC"}; // [cite: 135]
        Problem5.linearSearch(logs, "accB"); // [cite: 136]

        String[] sortedLogs = logs.clone();
        Arrays.sort(sortedLogs); // Binary search requires sorted array [cite: 121, 125]
        Problem5.binarySearchCount(sortedLogs, "accB"); // [cite: 137]

        System.out.println("\n--- PROBLEM 6: Risk Thresholds ---");
        int[] risks = {10, 25, 50, 100}; // [cite: 158]
        Problem6.linearSearchThreshold(risks, 30); // [cite: 159]
        Problem6.binarySearchFloorCeil(risks, 30); // [cite: 160]
    }
}