import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static final int MAX_N = 30;

    private static int n;
    private static int c;
    private static int[] weights = new int[MAX_N];
    private static List<Integer> left = new ArrayList<>();
    private static List<Integer> right = new ArrayList<>();
    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(reader.readLine());
        n = Integer.parseInt(tokens.nextToken());
        c = Integer.parseInt(tokens.nextToken());

        tokens = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            weights[i] = Integer.parseInt(tokens.nextToken());
        }
        int mid = n / 2;

        find(0, mid, 0, left);
        find(mid, n, 0, right);

        Collections.sort(right);

        for (int l : left) {
            answer += upperBound(right, c - l);
        }

        System.out.println(answer);
    }

    private static void find(int start, int end, int sum, List<Integer> list) {
        if (sum > c) {
            return;
        }

        if (start == end) {
            list.add(sum);
            return;
        }

        find(start + 1, end, sum, list);
        find(start + 1, end, sum + weights[start], list);
    }

    private static int upperBound(List<Integer> list, int target) {
        int left = 0;
        int right = list.size();
        while (left < right) {
            int mid = (left + right) / 2;
            if (list.get(mid) <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
