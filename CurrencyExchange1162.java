import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CurrencyExchange1162 {
    static class Edge {
        int a, b;
        double r, c;

        Edge(int a, int b, double r, double c) {
            this.a = a;
            this.b = b;
            this.r = r;
            this.c = c;
        }
    }

    static List<Edge> edges;
    static int n, m, s;
    static double v;
    static double[] nodes;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a, b;
        double rab, cab, rba, cba;

        n = scanner.nextInt();
        m = scanner.nextInt();
        s = scanner.nextInt();
        v = scanner.nextDouble();

        nodes = new double[101];
        nodes[s] = v;

        edges = new ArrayList<>(m);
        for (int i = 0; i < m; ++i) {
            a = scanner.nextInt();
            b = scanner.nextInt();
            rab = scanner.nextDouble();
            cab = scanner.nextDouble();
            rba = scanner.nextDouble();
            cba = scanner.nextDouble();

            edges.add(new Edge(a, b, rab, cab));
            edges.add(new Edge(b, a, rba, cba));
        }

        if (solve()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    static boolean solve() {
        for (int i = 0; i < n - 1; ++i) {
            for (int j = 0; j < edges.size(); ++j) {
                nodes[edges.get(j).b] = Math.max(nodes[edges.get(j).b], (nodes[edges.get(j).a] - edges.get(j).c) * edges.get(j).r);
            }
        }

        for (int i = 0; i < edges.size(); ++i) {
            if ((nodes[edges.get(i).a] - edges.get(i).c) * edges.get(i).r > nodes[edges.get(i).b]) {
                return true;
            }
        }

        return false;
    }
}
