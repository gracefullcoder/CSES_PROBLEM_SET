import java.util.*;

public class Permutations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        if (n == 1) {
            System.out.println(1);
            return;
        } else if (n <= 3) {
            System.out.println("NO SOLUTION");
            return;
        }
        
        StringBuilder result = new StringBuilder();
        
        for (int i = 2; i <= n; i += 2) {
            result.append(i).append(" ");
        }
        
        for (int i = 1; i <= n; i += 2) {
            result.append(i).append(" ");
        }
        
        System.out.println(result);
    }
}

//ye wala code tc 17 pe tle converted to stringbuilder worked 
