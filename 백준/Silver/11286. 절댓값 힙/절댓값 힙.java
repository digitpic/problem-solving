import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        PriorityQueue<Integer> queue = new PriorityQueue<>(
                (first, second) -> {
                    int firstAbs = Math.abs(first);
                    int secondAbs = Math.abs(second);

                    if (firstAbs == secondAbs) {
                        return first - second;
                    }

                    return firstAbs - secondAbs;
                }
        );

        for (int i = 0; i < n; i++) {
            int number = scanner.nextInt();

            if (number == 0) {
                if (queue.isEmpty()) {
                    System.out.println("0");
                } else {
                    System.out.println(queue.poll());
                }
            } else {
                queue.add(number);
            }
        }
    }
}
