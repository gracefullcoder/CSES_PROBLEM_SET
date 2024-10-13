import java.util.*;
import java.io.*;

public class ConcertTickets {

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

    static int findNearest(int offer, ArrayList<Integer> avl) {
        int si = 0;
        int ei = avl.size() - 1;
        int mid = 0;
        // System.out.println(avl);
        while (ei - si > 1) {
            mid = (ei - si) / 2 + si;

            if (avl.get(mid) == offer){
                avl.remove(mid);
                return offer;
            }
                

            else if (avl.get(mid) < offer)
                si = mid;
            else
                ei = mid - 1;
        }

        if (ei - si == 1) {
            if (avl.get(ei) <= offer) {
                int ans = avl.get(ei);
                avl.remove(ei);
                return ans;
            }
            if (avl.get(si) <= offer) {
                int ans = avl.get(si);
                avl.remove(si);
                return ans;
            }
        }else if (si == ei) {
            if (avl.get(si) <= offer) {
                int ans = avl.get(si);
                avl.remove(si);
                return ans;
            }
        }

        return -1;
    }

    static void solve(FastReader in, FastWriter out) throws IOException {
        int n = in.nextInt(), m = in.nextInt();
        ArrayList<Integer> ticketsAval = new ArrayList<>();
        int ticketsReq[] = new int[m];
        int ans[] = new int[m];

        for (int i = 0; i < n; i++)
            ticketsAval.add(in.nextInt());
        for (int i = 0; i < m; i++)
            ticketsReq[i] = in.nextInt();

        Collections.sort(ticketsAval);

        int ap = 0, rp = 0;
        int curr = -1;

        for (int i = 0; i < m; i++) {
            ans[i] = findNearest(ticketsReq[i], ticketsAval);
        }

        for (int i = 0; i < m; i++)
            out.println(ans[i]);

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