import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        long n = scanner.nextInt();
        String input = scanner.next();
        char[] numbers = input.toCharArray();
        
        int sum = 0;
        for (char number : numbers) {
            sum += number - 48;
        }

        System.out.println(sum);
    }
}
