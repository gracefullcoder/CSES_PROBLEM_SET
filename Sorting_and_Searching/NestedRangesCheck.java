import java.util.*;
import java.io.*;

public class NestedRangesCheck {

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

    static class Range implements Comparable<Range> {
        int i;
        int s;
        int e;

        Range(int i, int s, int e) {
            this.i = i;
            this.s = s;
            this.e = e;
        }

        @Override
        public int compareTo(Range x) {
            if (this.s == x.s)
                return x.e - this.e;
            return this.s - x.s;
        }
    }

    static void solve(FastReader in, FastWriter out) throws IOException {
        int n = in.nextInt();
        ArrayList<Range> ranges = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int s = in.nextInt();
            int e = in.nextInt();
            ranges.add(new Range(i, s, e));
        }

        Collections.sort(ranges);

        int containing[] = new int[n];
        int contained[] = new int[n];

        int maxEnd = 0;

        for (int i = 0; i < n; i++) {
            if (ranges.get(i).e <= maxEnd)
                contained[ranges.get(i).i] = 1;
            maxEnd = Math.max(maxEnd, ranges.get(i).e);
        }

        int minEnd = Integer.MAX_VALUE;

        for (int i = n - 1; i >= 0; i--) {
            if (ranges.get(i).e >= minEnd)
                containing[ranges.get(i).i] = 1;
            minEnd = Math.min(minEnd, ranges.get(i).e);
        }

        for (int i = 0; i < n; i++)
            out.print(containing[i] + " ");
        out.println("");
        for (int i = 0; i < n; i++)
            out.print(contained[i] + " ");

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
