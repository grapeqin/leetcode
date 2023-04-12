package github.grapeqin.string;

public class LeetCode415 {
    public String addStrings(String num1, String num2) {
        int n = num1.length();
        int m = num2.length();

        int i = n - 1;
        int j = m - 1;
        int carrybit = 0;
        int result = 0;
        StringBuilder sb = new StringBuilder("");
        while (i >= 0 || j >= 0 || carrybit > 0) {
            //当对应数组的下标为负数时直接给它补0
            int a = i >= 0 ? num1.charAt(i) - '0' : 0;
            int b = j >= 0 ? num2.charAt(j) - '0' : 0;
            result = a + b + carrybit;
            //计算进位
            carrybit = result / 10;
            //计算当前位的值
            result %= 10;

            sb.append(result);
            i--;
            j--;
        }
        //记得要反转字符串获得结果
        return sb.reverse().toString();
    }
}
