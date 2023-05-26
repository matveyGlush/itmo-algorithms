import java.util.Arrays;
import java.util.Scanner;

public class Rocks1005 {
    static int ans = 2000000;

    public static void diff(int[] mas, int left, int right, int depth, int size) {
        if(depth == size) {
            ans = Math.min(ans, Math.abs(left-right));
        } else {
            diff(mas,left+mas[depth],right,depth+1,size);
            diff(mas, left, right+mas[depth],depth+1,size);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            int temp = scanner.nextInt();
            arr[i] = temp;
        }
        Arrays.sort(arr);
        diff(arr,0,0,0, n);
        System.out.println(ans);
    }
}
