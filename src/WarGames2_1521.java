import java.util.*;

public class WarGames2_1521 {
    static final int SIZE = 1000000;
    static int[] tree = new int[SIZE]; // segment tree
    static int[] soldier = new int[SIZE];
    static int n, k;

    /*
     * Build a segment tree.
     */
    static int node = 1;

    static void build_tree(int n, int i) {
        if (n == 1) {
            soldier[i] = node++;
        } else {
            /* Build a tree's child. */
            build_tree((n + 1) >> 1, left(i));
            build_tree((n) >> 1, right(i));
        }
        tree[i] = n;
    }

    /*
     * Return an index of next killed soldier.
     */
    static int sum = 0;

    static int kill_next(final int k) {
        sum = sum + k;
        while (sum > tree[0]) {
            sum -= tree[0];
        }
        int i = 0, next = sum--;

        while (tree[i] != 0) {
            tree[i]--;
            if (next <= tree[left(i)]) {
                i = left(i);
            } else {
                next -= tree[left(i)];
                i = right(i);
            }
            if (i >= SIZE)
                break;
        }
        return soldier[parent(i)];
    }

    static int parent(int i) {
        return (i - 1) >> 1;
    }

    static int left(int i) {
        return (i << 1) + 1;
    }

    static int right(int i) {
        return (i << 1) + 2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        build_tree(n, 0);
        for (int i = 0; i < n; i++) {
            System.out.print(kill_next(k) + " ");
        }
    }
}
