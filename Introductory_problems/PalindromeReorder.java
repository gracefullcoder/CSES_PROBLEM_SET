import java.util.*;
import java.io.*;

public class PalindromeReorder {

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
        String str = in.nextLine();
        StringBuilder sb = new StringBuilder(str);
        int charArr[] = new int[26];

        for (int i = 0; i < sb.length(); i++) {
            charArr[sb.charAt(i) - 'A']++;
        }

        int oddIdx = -1;

        for (int i = 0; i < 26; i++) {
            if (charArr[i] % 2 == 1) {
                if (oddIdx == -1)
                    oddIdx = i;
                else {
                    oddIdx = -2;
                    out.print("NO SOLUTION");
                    break;
                }
            }
        }

        if (oddIdx != -2) {

            StringBuilder halfAns = new StringBuilder("");

            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < charArr[i] / 2; j++) {
                    halfAns.append((char) ('A' + i));
                }
            }

            StringBuilder ans = new StringBuilder(halfAns);

            if (oddIdx != -1) {
                ans.append((char) ('A' + oddIdx));
            } 

            ans.append(halfAns.reverse());

            out.print(ans);
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