import java.util.*;

public class Spy1322 {

    public static boolean sort_b(Pair b_1, Pair b_2){
        if(b_1.second==b_2.second)
            return b_1.first<b_2.first;
        return b_1.second<b_2.second;
    }

    public static void restore(Pair[] bukva, int n, int index){
        int current = index;
        for(int i=0; i<n; i++){
            System.out.print(bukva[current].second);
            current = bukva[current].first;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int index = sc.nextInt();
        index--;
        String initial = sc.next();
        int n = initial.length();
        Pair[] bukva = new Pair[n];
        for(int i = 0; i<n; i++)
            bukva[i] = new Pair(i, initial.charAt(i));
        Arrays.sort(bukva, new Comparator<Pair>() {
            public int compare(Pair b_1, Pair b_2) {
                return sort_b(b_1, b_2) ? -1 : 1;
            }
        });
        restore(bukva,n, index);
        sc.close();
    }

    public static class Pair {
        int first;
        char second;
        Pair(int first, char second) {
            this.first = first;
            this.second = second;
        }
    }
}
