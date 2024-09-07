import java.util.*;

public class Repetitions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        StringBuilder sb = new StringBuilder(str);
        int n = sb.length();
        int ans = 1;
        int curr = 1;
        for (int i = 1; i < n; i++) {
            if(sb.charAt(i) == sb.charAt(i-1)){
                curr++;
                ans = Math.max(ans,curr);
            }else curr = 1;
        }

        System.out.println(ans);
    }
}
