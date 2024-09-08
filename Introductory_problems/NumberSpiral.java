import java.io.*;

public class NumberSpiral {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());

        while (tc > 0) {
            String[] input = br.readLine().split(" ");  
            long x = Long.parseLong(input[0]);
            long y = Long.parseLong(input[1]);
            long ans;

            if (x > y) {
                if (x % 2 == 0) {
                    ans = x * x - y + 1;
                } else {
                    ans = (x - 1) * (x - 1) + y;
                }
            } else if (x < y) {
                if (y % 2 == 1) {
                    ans = y * y - x + 1;
                } else {
                    ans = (y - 1) * (y - 1) + x;
                }
            } else {
                if (x % 2 == 0) {
                    ans = x * x - y + 1;
                } else {
                    ans = y * y - x + 1;
                }
            }

            sb.append(ans).append("\n");
            tc--;
        }
        System.out.print(sb);
    }
}