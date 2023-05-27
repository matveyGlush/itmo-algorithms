import java.util.*;
import java.io.*;

public class MapColoring1080 {
    static ArrayList<Integer>[] g;
    static int[] mass;
    static boolean[] used;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        g = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<Integer>();
        }

        used = new boolean[n];
        mass = new int[n];
        Arrays.fill(mass, -1);

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int z = Integer.parseInt(st.nextToken());

            while (z != 0) {
                z--;
                g[z].add(i);
                g[i].add(z);
                z = Integer.parseInt(st.nextToken());
            }
        }

        if (dfs(0, 0)) {
            for (int i = 0; i < n; i++) {
                System.out.print(mass[i]);
            }
        } else {
            System.out.println(-1);
        }
    }

    static boolean dfs(int v, int z) {
        used[v] = true;
        mass[v] = z;

        for (int i = 0; i < g[v].size(); i++) {
            int u = g[v].get(i);
            if (used[u]) {
                if (mass[u] == z) {
                    return false;
                }
            } else {
                if (!dfs(u, 1 - z)) {
                    return false;
                }
            }
        }

        return true;
    }
}
