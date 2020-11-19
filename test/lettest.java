package test;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import sun.jvm.hotspot.ci.ciKlass;

public class lettest {
    @Test
    public void test3() {
        int num = 123 + 456;
        ListNode result = new ListNode();
        int x = 0;
        do{
            if(x == 0){
                result.val = num % 10;
            }
            else{
                ListNode n = NewNode(result);
                n.val = num % 10;
            }
            num = num / 10;
            x++;
        }while (num > 0);

        ListNode f1 = result;
        while (f1 != null) {
            System.out.println(f1.val);
            f1 = f1.next;
        }
    }

    public ListNode NewNode(ListNode head) {
        
        ListNode foo = head;
        while(foo.next != null){
            foo = foo.next;
        }
        foo.next = new ListNode();
        return foo.next; 
    }

    public static int lengthOfLongestSubstring(String s) {
        s.indexOf(s, 0);
        int num = 0;
        int len = s.length();
        if(len < 2){
            return len;
        }
        int i = 0;
        int r = 0;
        boolean flag = false;
        for (int x = i+1; x < len;) {
            if(s.charAt(i) == s.charAt(x)){  
                if (x - r > num){
                    num = x - r;
                }
                r = i + 1;
                flag = true;
            }
            if(x - i > 1){
                i++;
            }else{
                x++;
                if(x < len){
                    i = r;
                }
                
            }
        }
        if(flag){
            if(len - r > num){
                num = len - r;
            }
        }else{
            return len;
        }
        return num;   
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int al = nums1.length;
        int bl = nums2.length;
        int len = al + bl;
        int n = len;
        al = al - 1;
        bl = bl -1;
        int[] temp = new int[len];
        while (al > -1 || bl > -1) {
            if(al < 0){
                temp[--len] = nums2[bl--];
            }else if(bl < 0){
                temp[--len] = nums1[al--];
            }else{
                temp[--len] = nums1[al] > nums2[bl] ? nums1[al--] : nums2[bl--];
            }
            // temp[temp_start++] = nums1[num1_start] > nums2[num2_start] ? nums2[num2_start++] : nums1[num1_start++];
        }
        if(n % 2 == 0){
            return (temp[n/2] + temp[n/2-1])/2.0; 
        }else{
            return temp[n/2];
        }
    }

    //第四题最长回文字符串
    

    public static String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        int maxLen = 1;
        String res = s.substring(0, 1);
        // 中心位置枚举到 len - 2 即可
        for (int i = 0; i < len - 1; i++) {
            String oddStr = centerSpread(s, i, i);
            String evenStr = centerSpread(s, i, i + 1);
            String maxLenStr = oddStr.length() > evenStr.length() ? oddStr : evenStr;
            if (maxLenStr.length() > maxLen) {
                maxLen = maxLenStr.length();
                res = maxLenStr;
            }
        }
        return res;
    }

    private static String centerSpread(String s, int left, int right) {
        // left = right 的时候，此时回文中心是一个字符，回文串的长度是奇数
        // right = left + 1 的时候，此时回文中心是一个空隙，回文串的长度是偶数
        int len = s.length();
        int i = left;
        int j = right;
        while (i >= 0 && j < len) {
            if (s.charAt(i) == s.charAt(j)) {
                i--;
                j++;
            } else {
                break;
            }
        }
        // 这里要小心，跳出 while 循环时，恰好满足 s.charAt(i) != s.charAt(j)，因此不能取 i，不能取 j
        return s.substring(i + 1, j);
    }

    public static String convert(String s, int numRows) {
        int len = s.length();
        char[][] temp = new char[numRows][len / numRows * 2];
        int a = 0, b = 0;
        for (int i = 0; i < len; i++) {
            temp[a][b] = s.charAt(i);
            a++;
            if (a == numRows) {
                a--;
                for (; a > 0;) {
                    b++;
                    a--;
                    i++;
                    temp[a][b] = s.charAt(i);
                }
            }
        }
        String string = Arrays.toString(temp);
        for (int i = 0; i < temp.length; i++) {
            System.out.println(Arrays.toString(temp[i]));
        }
        // for (int i = 0; i < temp.length; i++) {
        //     System.out.println(string.toString());
        // }
        return string;
    }

    public static String convert1(String s, int numRows){
        String temp = "";
        temp += s.charAt(0);
        int len = s.length();
        if(numRows < 2 || len < 3 || len == numRows || len < numRows){
            return s;
        }
        if(numRows == 2){
            int x = 2;
            for (int i = 0; i < len - 1; i++) {
                temp += s.charAt(x);
                x += 2;
                if(x >= len){
                    x = 1;
                }
            }
            return temp;
        }
        int Column_base_number = numRows + (numRows - 2);
        int Base_number_of_rows = numRows -2;
        int a = Column_base_number;
        int b = Base_number_of_rows * 2;
        int x = 1;
        int y = a;
        int j = 0;
        boolean f = false;
        for (int i = 0; i < len - 1; i++) {
            if(a >= len){
                a = x;
                x++;
                if(x > 2){
                    b = b - 2;
                }
                y = b;
                j += 2;
                f = true;
                if(x == numRows){
                    y = Column_base_number;
                }
            }
            temp += s.charAt(a);
            a = a + y;
            if(y == b && f == true){
                y = j;
                f = false;
            }else if(y == j && x != numRows){
                y = b;
                f = true;
            }
            
        }
        return temp;
    }

    @Test
    public static int reverse(int x) {
        int flag = 1;
        if(x < 0){
            flag = 0;
        }
        int val = Math.abs(x);
        String s = String.valueOf(val);
        String string = new StringBuilder(s).reverse().toString();
        try {
            int a = Integer.valueOf(string);
            if(flag == 0){
                a = ~a + 1;
            }
            return a;
        } catch (Exception e) {
            return 0;
        }
    }

    public static int myAtoi(String s) {
        s = s.trim();
        int len = s.length();
        if(len == 0){
            return 0;
        }
        String c = "+-";
        int i = 0;
        String temp = "";
        int appear = c.indexOf(s.charAt(0));
        if(appear >= 0){
            if(s.charAt(0) == '-'){
                temp += '-';
                i++;
            }else{
                i++;
            }
        }
        // String num = "0123456789";
        for (; i < len; i++) {
            if(Character.isDigit(s.charAt(i))){
                temp += s.charAt(i);
            }else{
                if(temp.length() == 0){
                    return 0;
                }
                break; 
            }
        }
        if(temp.length() > 2){
            char l = temp.charAt(1);
            if(l == '+' || l == '-'){
                return 0;
            }
        }
        try {
            Double w = Double.valueOf(temp);
            if(w > Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }else if(w < Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }else{
                return Integer.valueOf(temp);
            }
        } catch (Exception e) {
            return 0;
        }
    }

    public static boolean isPalindrome(int x) {

        String s = String.valueOf(x);
        String temp = String.valueOf(x);
        int len = s.length();
        int str = len - 1;
        for (int i = 0; i < len; i++, str--) {
            if (s.charAt(i) == temp.charAt(str)) {
            } else {
                return false;
            }
        }
        return true;
    }

    public static void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int line = matrix[0].length;
        int[] temp = new int[line];
        int f = 0;
        int[] x = new int[row];
        for (int j = 0; j < row; j++) {
            for (int o = 0; o < line; o++) {
                if (matrix[j][o] == 0) {
                    if (temp[o] == 1) {
                        if (x[j] == 1) {
                            f = 1;
                        }
                        continue;
                    } else {
                        temp[o] = 1;
                        f = 1;
                        for (int l = 0; l < row; l++) {
                            if (matrix[l][o] == 0 && l != j) {
                                x[l] = 1;
                            } else {
                                matrix[l][o] = 0;
                            }
                        }
                    }
                }
            }
            if (f == 1) {
                for (int i = 0; i < line; i++) {
                    matrix[j][i] = 0;
                }
                f = 0;
            }
        }
        for (int[] i : matrix) {
            for (int j : i) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] a = {};
        int[] b = { 4, 5 };
        int[][] c = {{0,0,0,5},
                    {4,3,1,4},
                    {0,1,1,4},
                    {1,2,1,3},
                    {0,0,1,1}};
        int[][] l = {{1,1,1},
                    {1,0,1},
                    {1,1,1}};
        isMatch("aa", "..a");
        // "PINALSIGYAHRPI"
        // aasd.*asd.*asd.*asd aasd a asd a asd a asd
    }

    //

    public static boolean isMatch(String s, String p) {
        int sl = s.length();
        int pl = p.length();

        boolean[][] a = new boolean[sl + 1][pl + 1];
        a[0][0] = true;
        for (int i = 0; i <= sl; ++i) {
            for (int j = 1; j <= pl; ++j) {
                if (p.charAt(j - 1) == '*') {
                    a[i][j] = a[i][j - 2];
                    if (matchs(s, p, i, j - 1)) {
                        a[i][j] = a[i][j] || a[i - 1][j];
                    }
                } else {
                    if (matchs(s, p, i, j)) {
                        a[i][j] = a[i - 1][j - 1];
                    }
                }
            }
        }
        return a[sl][pl];
    }

    public static boolean matchs(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }

    public static boolean isMatch1(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[][] f = new boolean[m + 1][n + 1];
        f[0][0] = true;
        for (int i = 0; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (p.charAt(j - 1) == '*') {
                    f[i][j] = f[i][j - 2];
                    if (matches1(s, p, i, j - 1)) {
                        f[i][j] = f[i][j] || f[i - 1][j];
                    }
                } else {
                    if (matches1(s, p, i, j)) {
                        f[i][j] = f[i - 1][j - 1];
                    }
                }
            }
        }
        return f[m][n];
    }

    public static boolean matches1(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }


}


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}