import java.util.*;
import java.io.*;

public class TrafficLights {

    public static void main(String[] args) {
        try (FastReader in = new FastReader(); FastWriter out = new FastWriter()) {

            int testCases = 1;

            while (testCases-- > 0) {
                solve(in, out);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class Path implements Comparable<Path> {
        int start;
        int end;
        int length;

        Path(int start, int end, int length) {
            this.start = start;
            this.end = end;
            this.length = length;
        }

        @Override
        public int compareTo(Path p) {
            return Integer.compare(p.length, this.length);
        }
    }

    public static void addLight(int lightPos, PriorityQueue<Path> pq) {
        Path p;
        PriorityQueue<Path> tempQueue = new PriorityQueue<>();

        while (!pq.isEmpty()) {
            p = pq.poll();
            if (lightPos > p.start && lightPos < p.end) {
                tempQueue.offer(new Path(p.start, lightPos, lightPos - p.start));
                tempQueue.offer(new Path(lightPos, p.end, p.end - lightPos));
            } else {
                tempQueue.offer(p);
            }
        }

        pq.addAll(tempQueue);
    }

    static void solve(FastReader in, FastWriter out) throws IOException {
        int x = in.nextInt();
        int n = in.nextInt();

        PriorityQueue<Path> pq = new PriorityQueue<>();
        pq.add(new Path(0, x, x));
        int lightPos;

        for (int i = 0; i < n; i++) {
            lightPos = in.nextInt();
            addLight(lightPos, pq);
            out.print(pq.peek().length + " ");
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
