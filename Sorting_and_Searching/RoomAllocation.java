import java.util.*;
import java.io.*;

public class RoomAllocation {

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

    static class Info implements Comparable<Info> {
        int end;
        int room;

        Info(int end, int room) {
            this.end = end;
            this.room = room;
        }

        @Override
        public int compareTo(Info x) {
            return this.end - x.end;
        }
    }

    static void solve(FastReader in, FastWriter out) throws IOException {
        int n = in.nextInt();

        int duration[][] = new int[n][3];

        for (int i = 0; i < n; i++) {
            duration[i][0] = i;
            duration[i][1] = in.nextInt();
            duration[i][2] = in.nextInt();
        }

        Arrays.sort(duration, Comparator.comparingInt(o -> o[1]));

        PriorityQueue<Info> pq = new PriorityQueue<>();
        pq.add(new Info(duration[0][2], 1));

        int ans[] = new int[n];
        ans[duration[0][0]] = 1;
        int nextMax = 2;

        for (int i = 1; i < n; i++) {
            if (pq.peek().end >= duration[i][1]) {
                pq.add(new Info(duration[i][2], nextMax));
                ans[duration[i][0]] = nextMax;
                nextMax++;
            } else {
                Info x = pq.poll();
                pq.add(new Info(duration[i][2], x.room));
                ans[duration[i][0]] = x.room;
            }
        }

        out.println(nextMax - 1);

        for (int i = 0; i < n; i++) {
            out.print(ans[i] + " ");
        }
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
