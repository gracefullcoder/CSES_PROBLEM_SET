import java.util.*;
import java.io.*;

public class FerrisWheel {

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
        int n = in.nextInt(), w = in.nextInt();
        int arr[] = new int[n];

        for(int i = 0 ; i < n ; i++) arr[i] = in.nextInt();

        Arrays.sort(arr);

        int l = 0, r = n - 1, curr = 0, ans = 0 ,count = 0;

        while (l < r) {
            if (count < 2 && curr + arr[r] <= w) {
                curr += arr[r];
                r--;
                count++;
            } else if (count < 2 && curr + arr[l] <= w) {
                curr += arr[l];
                l++;
                count++;
            } else {
                ans++;
                curr = 0;
                count = 0;
            }
        }

        if(l == r) {
            if(count == 2){curr = 0 ; ans++;}
            if(curr+ arr[l] <= w) ans++;
            else ans += 2;
        }

        //code kardiya for more than 2 in gondola
        // for (int i = n - 1; i >= 0; i--) {
        //     if (arr[i] <= w)
        //         break;
        //     else
        //         r--;
        // }


        // while (l < r) {
        //     if (curr + arr[r] <= w) {
        //         curr += arr[r];
        //         r--;
        //     } else if (curr + arr[l] <= w) {
        //         curr += arr[l];
        //         l++;
        //     } else {
        //         ans++;
        //         curr = 0;
        //     }
        // }

        // if(l == r) {
        //     if(curr+ arr[l] <= w) ans++;
        //     else ans += 2;
        // }

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
