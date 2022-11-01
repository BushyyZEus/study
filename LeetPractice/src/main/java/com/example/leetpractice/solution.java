package com.example.leetpractice;

class solution {
    public ListNode oddEvenList(ListNode head) {
        ListNode odd = new ListNode(-1);
        ListNode even = new ListNode(-1);
        ListNode cur = head;
        ListNode curOdd = odd;
        ListNode curEven = even;
        int flag = 1;
        while(cur != null){
            if(flag%2 == 1){
                curOdd.next = new ListNode(cur.val);
                curOdd = curOdd.next;
            }else if(flag%2 == 0){
                curEven.next = new ListNode(cur.val);
                curEven = curEven.next;
            }
            cur = cur.next;
            flag++;
        }
        curOdd.next = even.next;
        odd = odd.next;
        return odd;
    }
}
