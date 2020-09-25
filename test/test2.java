package test;

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
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Node l1 = createNode(in);
        // System.out.println();
        Node l2 = createNode(in);
        in.close();
    }

    public Node addTwoNumbers(Node l1, Node l2) {
        int a = 0;
        String b = "";
        while (l1 != null) {
            System.out.println(l1.getData());
            b += l1.getData();
            l1 = l1.getNext();
        }
        return new Node("123");
    }

    public static Node createNode(Scanner in) {
        Node l1 = new Node("header");
        
        Node temp = new Node(null);
        l1.next = temp;
        System.out.println("请输入第一个数：");
        int a = in.nextInt();
        temp.data = String.valueOf(a);
        System.out.println("请输入第二个数：");
        int n = 3;
        a = in.nextInt();
        while (a > 0) {
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new Node((String.valueOf(a)));
            System.out.println("请输入第" + n + "个数：");
            a = in.nextInt();
            n++;
        };
        return l1;
    }
}
// @lc code=end

class Node{
    String data = null;
    Node next = null;

    public String getData() {
        return data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node(String data) {
        this.data = data;
    }

    
}