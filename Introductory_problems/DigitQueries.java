import java.io.*;
import java.util.*;
 
public class DigitQueries {
 
    public static void main(String[] args) throws IOException {
        FastReader in = new FastReader();
        FastWriter out = new FastWriter();
        int q = in.nextInt();
        while (q-- > 0) {
            long k = in.nextLong();
            out.println(findDigitAtPosition(k));
        }
        out.close();
    }
 
    static long findDigitAtPosition(long k) {
        long length = 1;
        long count = 9;
        long start = 1;
        
        while (k > length * count) {
            k -= length * count;
            length++;
            count *= 10;
            start *= 10;
        }
        
        long number = start + (k - 1) / length;
        int digitIndex = (int)((k - 1) % length);
        
        String numberStr = Long.toString(number);
        return numberStr.charAt(digitIndex) - '0';
    }
 
    static class FastReader {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");
 
        String next() throws IOException {
            while (!st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }
 
        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
 
        long nextLong() throws IOException {
            return Long.parseLong(next());
        }
    }
 
    static class FastWriter {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
 
        void println(Object obj) throws IOException {
            bw.write(obj.toString());
            bw.newLine();
        }
 
        void close() throws IOException {
            bw.close();
        }
    }
}
