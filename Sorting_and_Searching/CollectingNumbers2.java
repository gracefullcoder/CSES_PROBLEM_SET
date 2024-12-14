import java.util.*;
import java.io.*;

public class CollectingNumbers2 {

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
        int n = in.nextInt(), m = in.nextInt();
        int check = 1;
        int ans = 1;
        int accArr[] = new int[n];
        int arr[] = new int[n];

        for (int i = 0; i < n; i++) {
            int temp = in.nextInt();
            accArr[i] = temp;
            arr[temp - 1] = i + 1;
        }

        for (int j = 0; j < m; j++) {
            int x = in.nextInt() - 1, y = in.nextInt() - 1;
            int xValue = accArr[x];
            int yValue = accArr[y];
            
            int temp = accArr[x];
            accArr[x] = accArr[y];
            accArr[y] = temp;

            temp = arr[xValue - 1];
            arr[xValue - 1] = arr[yValue -1];
            arr[yValue - 1] = temp;
        
        
            for (int i = 0; i < n; i++) {
                if (check > arr[i])
                    ans++;
                check = arr[i];
            }
            out.println(ans);
            check = 1;
            ans = 1;
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