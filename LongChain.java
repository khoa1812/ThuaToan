import java.util.Scanner;

public class LongChain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap chuoi");
        String input = sc.nextLine();
        System.out.println("Chuỗi tăng dần lớn nhất: " + findLongChain(input));
    }

    private static String findLongChain(String str) {
        int n = str.length();
        int[] dp = new int[n];
        int maxLength = 0;
        int lastIndex = 0;

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (str.charAt(j) < str.charAt(i) && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
            if (maxLength < dp[i]) {
                maxLength = dp[i];
                lastIndex = i;
            }
        }

        StringBuilder result = new StringBuilder();
        result.append(str.charAt(lastIndex));
        int length = maxLength - 1;
        for (int i = lastIndex - 1; i >= 0; i--) {
            if (dp[i] == length && str.charAt(i) < str.charAt(lastIndex)) {
                result.insert(0, str.charAt(i));
                lastIndex = i;
                length--;
            }
        }

        return result.toString();
    }
}

