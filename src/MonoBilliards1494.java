import java.util.Scanner;
import java.util.Stack;

public class MonoBilliards1494 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int max = 0;
        Stack<Integer> balls = new Stack<>();
        for (int i = 0; i < n; i++) {
            int currentBall = scanner.nextInt();
            if (currentBall > max) {
                for (int j = max + 1; j <= currentBall - 1; j++) {
                    balls.push(j);
                }
                max = currentBall;
            } else {
                if (currentBall == balls.peek()) {
                    balls.pop();
                } else {
                    System.out.println("Cheater");
                    scanner.close();
                    return;
                }
            }
        }
        System.out.println("Not a proof");
        scanner.close();
    }
}