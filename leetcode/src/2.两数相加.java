package leetcode;

import java.math.BigInteger;
import java.util.Scanner;

/*
 * @lc app=leetcode.cn id=2 lang=java
 *
 * [2] 两数相加
 */

// @lc code=start
/**
 * Definition for singly-linked list. 
 * public class ListNode { 
 *     int val;
 *     ListNode next; 
 *     ListNode(int x) { val = x; } }
 */
class Solution1 {

    public static void main(String[] args) {
        Scanner foo = new Scanner(System.in);
        ListNode l1 = new ListNode();
        ListNode l2 = new ListNode();
        l1.val = foo.nextInt();
        int x = 0;
        while ((x = foo.nextInt()) > 0) {
            addnum(l1, x);
        }
        // float a = foo.nextFloat();
        l2.val = foo.nextInt();
        while ((x = foo.nextInt()) > 0) {
            addnum(l2, x);
        }

        ListNode addTwoNumbers = addTwoNumbers(l1, l2);

        while (addTwoNumbers != null) {
            System.out.println(addTwoNumbers.val);
            addTwoNumbers = addTwoNumbers.next;
        }

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        String a = "";
        String b = "";
        while (l1 != null) {
            a += l1.val;
            l1 = l1.next;
        }
        while (l2 != null) {
            b += l2.val;
            l2 = l2.next;
        }

        
        // String c = String.valueOf(a + b);
        // System.out.println(new StringBuilder(a).reverse().toString());
        
        BigInteger a1 = new BigInteger(reverse1(a));
        BigInteger b1 = new BigInteger(reverse1(b));
        BigInteger num = a1.add(b1);
        System.out.println(num);
        a = num.toString();
        a = reverse1(a);
        System.out.println(a);
        
        ListNode result = new ListNode();

        // System.out.println(a.charAt(1) - '0');
        int x = 0;
        do {
            if (x == 0) {
                result.val = a.charAt(x) - '0';
            } else {
                ListNode n = NewNode(result);
                n.val = a.charAt(x) - '0';
            }
            x++;
        } while (x < a.length());

        return result;

    }

    public static ListNode NewNode(ListNode head) {

        ListNode foo = head;
        while (foo.next != null) {
            foo = foo.next;
        }
        foo.next = new ListNode();
        return foo.next;
    }

    public static boolean addnum(ListNode head, int a) {
        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new ListNode(a);
        return true;       
    }
    public static String reverse1(String str) {
        return new StringBuilder(str).reverse().toString();
    }
}
// @lc code=end

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}