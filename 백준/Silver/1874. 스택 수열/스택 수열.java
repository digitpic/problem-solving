import java.util.Scanner;
import java.util.Stack;

public class Main {
    private static final String LINE_SEPARATOR = System.lineSeparator();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        int count = 1;
        boolean flag = true;

        int n = scanner.nextInt();
        int[] numbers = new int[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }

        scanner.close();

        StringBuffer result = new StringBuffer();
        for (final int number : numbers) {
            if (number >= count) {
                while (number >= count) {
                    stack.push(count++);
                    result.append("+").append(LINE_SEPARATOR);
                }
                stack.pop();
                result.append("-").append(LINE_SEPARATOR);
            } else {
                int top = stack.pop();

                if (top > number) {
                    System.out.println("NO");
                    flag = false;
                    break;
                } else {
                    result.append("-").append(LINE_SEPARATOR);
                }
            }
        }

        if (flag) {
            System.out.println(result.toString());
        }
    }
}
