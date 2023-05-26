import java.util.*;

public class CountryOfFools1604 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        Pair[] ns = new Pair[k];
        for (int i = 0; i < k; i++) {
            ns[i] = new Pair(i + 1, scanner.nextInt());
        }
        Arrays.sort(ns, CountryOfFools1604::compare);
        List<Integer> result = new ArrayList<>();
        int j = k - 1;
        for (int i = 0; i < j;) {
            while (i < j && ns[i].second < 1)
                i++;
            if (i != j && ns[i].second-- > 0)
                result.add(ns[i].first);
            while (i < j && ns[j].second < 1)
                j--;
            if (i != j && ns[j].second-- > 0)
                result.add(ns[j].first);
        }
        for (int x : result) {
            System.out.print(x + " ");
            if (ns[j].second-- > 0)
                System.out.print(ns[j].first + " ");
        }
        while (ns[j].second-- > 0)
            System.out.print(ns[j].first + " ");
    }

    static int compare(Pair x1, Pair x2) {
        return Integer.compare(x2.second, x1.second);
    }

    static class Pair {
        int first, second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}