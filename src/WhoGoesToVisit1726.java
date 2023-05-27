import java.util.Scanner;

public class WhoGoesToVisit1726 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] xCoords = new int[n];
        int[] yCoords = new int[n];
        for (int i = 0; i < n; i++) {
            xCoords[i] = sc.nextInt();
            yCoords[i] = sc.nextInt();
        }
        quickSort(xCoords, 0, n - 1);
        quickSort(yCoords, 0, n - 1);
        long sum = 0;
        for (int i = 1; i < n; i++) {
            sum += (long) ((xCoords[i] - xCoords[i - 1]) + (yCoords[i] - yCoords[i - 1])) * (i) * (n - i) * 2;
        }
        sum = sum / ((long) n * (n - 1));
        System.out.println(sum);
        sc.close();
    }

    public static void quickSort(int[] array, int left, int right) {
        int i = left, j = right;
        int pivot = array[(left + right) / 2];
        while (i <= j) {
            while (array[i] < pivot)
                i++;
            while (array[j] > pivot)
                j--;
            if (i > j)
                break;
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            i++;
            j--;
        }
        if (left < j)
            quickSort(array, left, j);
        if (i < right)
            quickSort(array, i, right);
    }
}
