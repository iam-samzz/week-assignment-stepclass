import java.util.Arrays;

class Client {
    String id;
    int riskScore;
    double accountBalance;

    public Client(String id, int riskScore, double accountBalance) {
        this.id = id;
        this.riskScore = riskScore;
        this.accountBalance = accountBalance;
    }

    @Override
    public String toString() { return id + "(" + riskScore + ")"; }
}

public class Problem2 {
    public static void bubbleSortAsc(Client[] clients) {
        int n = clients.length;
        int swaps = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (clients[j].riskScore > clients[j + 1].riskScore) {
                    Client temp = clients[j];
                    clients[j] = clients[j + 1];
                    clients[j + 1] = temp;
                    swaps++;
                }
            }
        }
        System.out.println("Swaps: " + swaps);
    }

    public static void insertionSortDesc(Client[] clients) {
        for (int i = 1; i < clients.length; i++) {
            Client key = clients[i];
            int j = i - 1;
            while (j >= 0) {
                Client curr = clients[j];
                boolean shouldShift = curr.riskScore < key.riskScore ||
                        (curr.riskScore == key.riskScore && curr.accountBalance < key.accountBalance);
                if (shouldShift) {
                    clients[j + 1] = clients[j];
                    j--;
                } else {
                    break;
                }
            }
            clients[j + 1] = key;
        }
    }

    public static void printTop10Risks(Client[] clients) {
        int limit = Math.min(10, clients.length);
        System.out.print("Top " + limit + " risks: ");
        for (int i = 0; i < limit; i++) {
            System.out.print(clients[i] + (i < limit - 1 ? ", " : ""));
        }
        System.out.println();
    }
}