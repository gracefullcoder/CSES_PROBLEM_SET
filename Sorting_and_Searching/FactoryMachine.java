import java.util.*;
import java.io.*;

public class FactoryMachine {

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

    public static long numOfProd(long time, int arr[]) {
        long num = 0;

        for (int i = 0; i < arr.length; i++)
            num += time / arr[i];

        return num;
    }

    static void solve(FastReader in, FastWriter out) throws IOException {
        int n = in.nextInt();
        int t = in.nextInt();

        int arr[] = new int[n];

        long ei = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
            ei = Math.min(ei, arr[i]);
        }

        long si = 0;
        ei *= t;
        long mid = 0;
        long ans = 0;

        while (si < ei) {
            if(ei - si == 1) {
                long numOfP = numOfProd(si, arr);
                if(numOfP == t){
                    ans =si;
                    break;
                }
                ans = ei;
                break;
            }

            mid = (ei - si) / 2 + si;
            long numOfP = numOfProd(mid, arr);

            if (numOfP == t){
                ei = mid;
                ans = mid;
            }
            else if (numOfP > t)
                ei = mid;
            else
                si = mid;
        }

        out.println(ans);

    }

    static class FastReader implements Closeable {
        private final InputStream stream;
        private final byte[] buf = new byte[8192];
        private int curChar, numChars;

        public FastReader() {
            this.stream = System.in;
        }

        private int read() throws IOException {
            if (numChars == -1)
                throw new IOException();
            if (curChar >= numChars) {
                curChar = 0;
                numChars = stream.read(buf);
                if (numChars == -1)
                    return -1;
            }
            return buf[curChar++];
        }

        public int nextInt() throws IOException {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                res = res * 10 + c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        private boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        @Override
        public void close() throws IOException {
            stream.close();
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
