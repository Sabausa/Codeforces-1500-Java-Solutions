import java.util.Arrays;
import java.util.Scanner;

public class _1462E1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine()), r, l, ans;
        int[] a;
        for (int i = 0; i < t; i++) {
            sc.nextLine();
            a = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
            if (a.length < 3) {
                System.out.println(0);
                continue;
            }
            ans = 0;
            for (int j = 2; j < a.length; j++) {
                l = j;
                while (l > 0 && a[j] - a[l-1] <= 2) {
                    l--;
                }
                while(l <= j-2){
                    ans += binomialCoeff(j-l-1,1);
                    l++;
                }

            }
            System.out.println(ans);
        }
    }

    static int binomialCoeff(int n, int k) {

        if (k > n)
            return 0;
        if (k == 0 || k == n)
            return 1;

        return binomialCoeff(n - 1, k - 1)
                + binomialCoeff(n - 1, k);
    }
}
