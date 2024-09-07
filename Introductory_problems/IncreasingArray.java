import java.util.*;

public class IncreasingArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int prev = 0, curr;
        long ans = 0;
        for (int i = 0; i < n; i++) {
            curr = sc.nextInt();

            if (curr < prev) {
                ans += prev - curr;
                curr = prev;
            }
            prev = curr;
        }

        System.out.println(ans);
    }
}