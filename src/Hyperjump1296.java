import java.util.Scanner;

public class Hyperjump1296 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();

        int maxSum = 0;
        int currSum = 0;
        int num = 0;

        for (int i = 0; i < length; i++) {
            num = scanner.nextInt();
            currSum += num;
            if (currSum < 0) {
                currSum = 0;
            }
            if (currSum > maxSum) {
                maxSum = currSum;
            }
        }
        System.out.println(maxSum);
    }
}
