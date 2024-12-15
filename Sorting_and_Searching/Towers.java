import java.util.*;
import java.io.*;

public class Towers {

    public static void main(String[] args) {
        try (FastReader in = new FastReader();
                FastWriter out = new FastWriter()) {

            int testCases = 1;
            // testCases = in.nextInt();

            while (testCases-- > 0) {
                // solve(in, out);
                // optimized(in, out);
                // approach3(in, out);
                usingJCF(in, out);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void solve(FastReader in, FastWriter out) throws IOException {
        int n = in.nextInt();
        ArrayList<ArrayList<Integer>> numbers = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int temp = in.nextInt();
            boolean flag = false;

            for (int j = 0; j < numbers.size(); j++) {
                int currSize = numbers.get(j).size();

                if (numbers.get(j).get(currSize - 1) > temp) {
                    numbers.get(j).add(temp);
                    flag = true;
                    break;
                }

            }

            if (!flag) {
                ArrayList<Integer> newRound = new ArrayList<>();
                newRound.add(temp);
                numbers.add(newRound);
            }
        }

        out.println(numbers.size());
    }

    static void optimized(FastReader in, FastWriter out) throws IOException {
        int n = in.nextInt();
        // ArrayList<ArrayList<Integer>> numbers = new ArrayList<>();
        int towers[] = new int[n];
        int min = Integer.MAX_VALUE;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            towers[i] = in.nextInt();
        }

        for (int i = n - 1; i >= 0; i--) {
            if (min >= towers[i]) {
                ans++;
                min = towers[i];
            }
        }

        out.println(ans);
    }

    static void approach3(FastReader in, FastWriter out) throws IOException {
        int n = in.nextInt();
        ArrayList<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int temp = in.nextInt();
            boolean flag = false;

            for (int j = 0; j < numbers.size(); j++) {
                if (numbers.get(j) > temp) {
                    numbers.set(j, temp);
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                numbers.add(temp);
            }
            // out.println(numbers);
        }

        out.println(numbers.size());
    }

    static void usingJCF(FastReader in, FastWriter out) throws IOException {
        int n = in.nextInt();
        TreeMap<Integer, Integer> ms = new TreeMap<>();
        int temp;

        for (int i = 0; i < n; i++) {
            temp = in.nextInt();

            
            Integer upperBound = ms.higherKey(temp);

            if (upperBound == null) {
              
                ms.put(temp, ms.getOrDefault(temp, 0) + 1);
            } else {
                if (ms.get(upperBound) == 1) {
                    ms.remove(upperBound);
                } else {
                    ms.put(upperBound, ms.get(upperBound) - 1);
                }
                ms.put(temp, ms.getOrDefault(temp, 0) + 1);
            }
        }

        int size = 0;
        for (int count : ms.values()) {
            size += count;
        }

        out.println(size);
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