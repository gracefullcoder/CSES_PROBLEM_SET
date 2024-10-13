import java.util.*;
import java.io.*;
 
public class Appartments {
 
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
        int n = in.nextInt(), m = in.nextInt(), k = in.nextInt();
        int appAval[] = new int[n];
        int appReq[] = new int[m];
 
        for (int i = 0; i < n; i++) {
            appAval[i] = in.nextInt();
        }
 
        for (int i = 0; i < m; i++) {
            appReq[i] = in.nextInt();
        }
 
        Arrays.sort(appAval);
        Arrays.sort(appReq);
        int start = 0, ans = 0;
 
        // for(int i = 0 ; i < appAval.length ; i++) out.println(appAval[i]);
        // for(int i = 0 ; i < appReq.length ; i++) out.println(appReq[i]);
 
        for (int i = 0; i < m; i++) {
            for (int j = start; j < n; j++) {
                if (appReq[i] >= appAval[j] - k) {
                    if (appReq[i] <= appAval[j] + k) {
                        ans++;
                        start = j + 1;
                        break;
                    }
                } else {
                    start = j;
                    break;
                }
            }
        }
        out.println(ans);
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