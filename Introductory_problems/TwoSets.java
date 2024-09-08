import java.util.*;
import java.io.*;

public class TwoSets {

    public static void main(String[] args) {
        try (FastReader in = new FastReader();
                FastWriter out = new FastWriter()) {

            int testCases = 1;
            // testCases = in.nextInt();

            while (testCases-- > 0) {
                solve(in, out);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void solve(FastReader in, FastWriter out) throws IOException {
        int n = in.nextInt();

        if (n % 4 == 0 || (n + 1) % 4 == 0) {
            ArrayList<Integer> set1 = new ArrayList<>();
            ArrayList<Integer> set2 = new ArrayList<>();
            // long hs = n % 4 == 0 ? (long)n / 4 * (n + 1) : (long)n * ((n + 1) / 4);
            long hs = (long) n * (n + 1) / 4;
            // out.println(hs);
            long tempSum = 0;

            for (int i = n; i >= 1; i--) {
                if (tempSum + i <= hs) {
                    tempSum += i;
                    set1.add(i);
                } else {
                    set2.add(i);
                }
            }
            out.println("YES");
            out.println(set1.size());
            for (int i = 0; i < set1.size(); i++) {
                out.print(set1.get(i) + " ");
            }
            out.println("");
            out.println(set2.size());
            for (int i = 0; i < set2.size(); i++) {
                out.print(set2.get(i) + " ");
            }
            out.println("");
        } else {
            out.println("NO");
        }
    }

    static class FastReader implements Closeable {
        private BufferedReader br;
        private StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        @Override
        public void close() throws IOException {
            br.close();
        }
    }

    static class FastWriter implements Closeable {
        private final BufferedWriter bw;

        public FastWriter() {
            this.bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        public void print(Object object) throws IOException {
            bw.append(object.toString());
        }

        public void println(Object object) throws IOException {
            print(object);
            bw.append(System.lineSeparator());
        }

        @Override
        public void close() throws IOException {
            bw.close();
        }
    }

    // Utility methods
    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    static int mod(int a, int m) {
        return ((a % m) + m) % m;
    }

    static long mod(long a, long m) {
        return ((a % m) + m) % m;
    }
}