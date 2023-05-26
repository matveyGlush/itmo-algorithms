import java.util.*;

class Dir {
    Map<String, Dir> subs = new TreeMap<>();
}

public class FolderStructure1067 {
    static Dir[] dirs = new Dir[50001];
    static int p = 1;

    static Dir addDir(Dir dir, String str) {
        Dir d = dir.subs.get(str);
        if (d == null) {
            d = new Dir();
            dir.subs.put(str, d);
            dirs[p++] = d;
        }
        return d;
    }

    static void print(Dir dir, int depth) {
        for (Map.Entry<String, Dir> entry : dir.subs.entrySet()) {
            String key = entry.getKey();
            Dir value = entry.getValue();
            for (int i = 0; i < depth; i++) {
                System.out.print(" ");
            }
            System.out.println(key);
            print(value, depth + 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        dirs[0] = new Dir();

        for (int i = 0; i < N; i++) {
            String str = sc.nextLine();
            Dir dir = dirs[0];
            String[] parts = str.split("\\\\");
            for (String part : parts) {
                dir = addDir(dir, part);
            }
        }

        print(dirs[0], 0);
    }
}
