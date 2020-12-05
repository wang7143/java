package leetcode;

// package leetcode;



import org.junit.Test;

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
public class test {

    // public static void main(String[] args) {
    //     Scanner foo = new Scanner(System.in);

    // }
    @Test
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int a = 0;
        int b = 0;
        while(l1.next != null){
            a += l1.val;
            l1 = l1.next;
        }
        while(l2.next != null){
            b += l2.val;
            l2 = l2.next;
        }

        // String c = String.valueOf(a + b);
        int num = a + b;
        ListNode result = new ListNode();
        int x = 0;
        do{
            if(x == 0){
                result.val = num % 10;
            }
            ListNode n = NewNode(result);
            n.val = num % 10;
            num = num / 10;
            x++;
        }while (num > 0);
        
        return result;

    }

    public ListNode NewNode(ListNode head) {
        
        ListNode foo = head;
        while(foo.next != null){
            foo = foo.next;
        }
        foo.next = new ListNode();
        return foo.next; 
    }


    @Test
    public void test3() {
        int num = 123 + 456;
        ListNode result = new ListNode();
        int x = 0;
        do{
            if(x == 0){
                result.val = num % 10;
            }
            ListNode n = NewNode(result);
            n.val = num % 10;
            num = num / 10;
            x++;
        }while (num > 0);

        System.out.println(result);
    }
}
// @lc code=end

// class ListNode {
//     int val;
//     ListNode next;
//     ListNode() {}
//     ListNode(int val) { this.val = val; }
//     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
// }