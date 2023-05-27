import java.util.Scanner;

public class Walls2025 {
    public static void main(String[] args) {
        int t,n,k,m,ost,sum;
        Scanner scanner = new Scanner(System.in);
        t = scanner.nextInt();
        for (int i=0; i<t; i++){
            n = scanner.nextInt();
            k = scanner.nextInt();

            m = n/k;
            ost = n%k;
            sum = 0;
            for (int j=0; j<ost; j++){
                n =n-(m+1);
                sum= sum+(n*(m+1));
            }
            for (int j=0; j<(k-ost); j++){
                n =n-m;
                sum= sum+(n*m);
            }
            System.out.println(sum);
        }
    }
}
