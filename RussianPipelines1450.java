import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class RussianPipelines1450 {
    private static final int N = 505;
    private static final long INF = 0x7ffffffffL;
    private static long[][] G = new long[N][N];
    private static long[] dp = new long[N];
    private static boolean[] v = new boolean[N];
    private static int s, t, m, n;

    private static void dfs(int x) {
        v[x] = true;
        for (int i = 0; i <= n; i++) {
            if (G[i][x] != 0 && !v[i]) {
                dfs(i);
            }
        }
    }

    private static long solve(int x) {
        if (dp[x] != -INF) {
            return dp[x];
        }
        long best = -INF;
        long tmp;
        for (int i = 1; i <= n; i++) {
            if (G[x][i] != 0 && v[i]) {
                tmp = dp[i] != -INF ? dp[i] + G[x][i] : solve(i) + G[x][i];
                if (tmp > best) {
                    best = tmp;
                }
            }
        }
        dp[x] = best;
        return dp[x];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        StringTokenizer tokenizer;
        while ((line = reader.readLine()) != null) {
            tokenizer = new StringTokenizer(line);
            n = Integer.parseInt(tokenizer.nextToken());
            m = Integer.parseInt(tokenizer.nextToken());
            Arrays.fill(dp, -INF);

            for (int i = 0; i < m; i++) {
                tokenizer = new StringTokenizer(reader.readLine());
                int a = Integer.parseInt(tokenizer.nextToken());
                int b = Integer.parseInt(tokenizer.nextToken());
                int c = Integer.parseInt(tokenizer.nextToken());
                G[b][a] = Math.max(c, G[b][a]);
            }

            tokenizer = new StringTokenizer(reader.readLine());
            s = Integer.parseInt(tokenizer.nextToken());
            t = Integer.parseInt(tokenizer.nextToken());

            dfs(s);
            dp[s] = 0;
            long ret = solve(t);
            if (ret < 0) {
                System.out.println("No solution");
            } else {
                System.out.println(ret);
            }
        }
    }
}