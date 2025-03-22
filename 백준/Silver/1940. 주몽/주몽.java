import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(bufferedReader.readLine());
        int m = Integer.parseInt(bufferedReader.readLine());

        int[] elements = new int[n];

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {
            elements[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        Arrays.sort(elements);

        int count = 0;

        int start = 0;
        int end = n - 1;

        while (start < end) {
            int sum = elements[start] + elements[end];
            if (sum < m) {
                start++;
            }

            if (sum == m) {
                count++;
                start++;
                end--;
            }

            if (sum > m) {
                end--;
            }
        }

        System.out.println(count);
    }
}
