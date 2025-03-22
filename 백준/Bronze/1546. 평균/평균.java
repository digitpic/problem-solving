import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();

        int[] grades = new int[n];
        for (int i = 0; i < n; i++) {
            grades[i] = scanner.nextInt();
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            if (max < grades[i]) {
                max = grades[i];
            }
        }
        double sum = 0.0;
        for (int i = 0; i < n; i++) {
            sum += (double) grades[i] / max * 100;
        }

        System.out.println(sum / n);
    }
}
