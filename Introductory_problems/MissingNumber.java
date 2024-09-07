import java.util.*;

public class MissingNumber {
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      long sum = 0;
      int temp;

      for(int i = 1 ; i < n ; i++) {
        temp = sc.nextInt();
        sum += temp;
      }

      System.out.println((long)n*(n+1)/2 - sum);
    }
}
