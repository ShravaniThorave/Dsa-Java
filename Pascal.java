import java.util.*;

public class Pascal {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for(int row = 1; row <= n; row++) {

            int ans = 1;

            for(int col = 1; col <= row; col++) {

                System.out.print(ans + " ");

                ans = ans * (row - col);
                ans = ans / col;
            }

            System.out.println();
        }
    }
}