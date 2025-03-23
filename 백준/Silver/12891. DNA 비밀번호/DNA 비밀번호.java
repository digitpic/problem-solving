import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int[] check = new int[4];
    private static int count = 0;

    private static int[] status = new int[4];

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int s = Integer.parseInt(stringTokenizer.nextToken());
        int p = Integer.parseInt(stringTokenizer.nextToken());

        char[] dna = bufferedReader.readLine().toCharArray();

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < 4; i++) {
            check[i] = Integer.parseInt(stringTokenizer.nextToken());

            if (check[i] == 0) {
                count++;
            }
        }

        for (int i = 0; i < p; i++) {
            add(dna[i]);
        }

        int result = 0;
        if (count == 4) {
            result++;
        }

        // sliding window
        for (int i = p; i < s; i++) {
            int j = i - p;

            add(dna[i]);
            remove(dna[j]);

            if (count == 4) {
                result++;
            }
        }

        System.out.println(result);
    }

    private static void add(final char c) {
        switch (c) {
            case 'A':
                status[0]++;
                if (status[0] == check[0]) {
                    count++;
                }
                break;

            case 'C':
                status[1]++;
                if (status[1] == check[1]) {
                    count++;
                }
                break;

            case 'G':
                status[2]++;
                if (status[2] == check[2]) {
                    count++;
                }
                break;

            case 'T':
                status[3]++;
                if (status[3] == check[3]) {
                    count++;
                }
                break;
        }
    }

    private static void remove(final char c) {
        switch (c) {
            case 'A':
                if (status[0] == check[0]) {
                    count--;
                }
                status[0]--;
                break;

            case 'C':
                if (status[1] == check[1]) {
                    count--;
                }
                status[1]--;
                break;

            case 'G':
                if (status[2] == check[2]) {
                    count--;
                }
                status[2]--;
                break;
                
            case 'T':
                if (status[3] == check[3]) {
                    count--;
                }
                status[3]--;
                break;
        }
    }
}
