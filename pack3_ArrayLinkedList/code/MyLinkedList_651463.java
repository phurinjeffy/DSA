package code;
import java.util.HashSet;
import java.util.ArrayList;

public class MyLinkedList_651463 {
    public class Node{
        int data;
        Node next;
        public Node(int d) {
            data = d;
        }
    }
    Node head = null;

    public String toString() {
        StringBuffer sb = new StringBuffer("head ");
        Node p = head;
        while (p != null) {
            sb.append("--> [");
            sb.append(p.data);
            sb.append("] ");
            p = p.next;
        }
        sb.append("-> null");
        return new String(sb);
    }

    public void add(int d) {
        Node p = new Node(d);
        p.next = head;
        head = p;
    }

    public void insert(int d) {
        Node q = new Node(d);
        if (head == null || head.data >= d) {
            q.next = head;
            head = q;
            return;
        }
        Node p = head;
        while (p.next != null && p.next.data < d) {
            p = p.next;
        }
        q.next = p.next;
        p.next = q;
    }

    public int find(int d) {
        Node p = head;
        int i = 0;
        while (p != null){
            if(p.data == d){
                return i;
            }
            p = p.next;
            i++;
        }
        return -1;
    }

    public void delete(int d) {
        Node t = new Node(0);
        t.next = head;
        Node p = t;
        while ((p.next != null) && (p.next.data != d)) {
            p = p.next;
        }
        if (p.next != null) {
            p.next = p.next.next;
        }
        head = t.next;
    }

    private int size() {
        int count = 0;
        Node p = head;
        while (p != null){
            count++;
            p = p.next;
        }
        return count;
    }

    public void add(int[] d) {
        for (int i = d.length - 1; i >= 0; i--){
            add(d[i]);
        }
    }

    public void insert(int[] d) {
        for (int i = 0; i < d.length; i++){
            insert(d[i]);
        }
    }

    public void q1_rotate_clockwise(int k) {
        if (k >= size() || k < 1)
            return;
        Node cur = head;
        Node tail = head;
        int i = 0;

        while (i < k-1){
            cur = cur.next;
            i++;
        }
        tail = cur;
        while(tail.next != null){
            tail = tail.next;
        }
        tail.next = head;
        head = cur.next;
        cur.next = null;
    }

    public void q2_reverse() {
        Node p = null;
        while (head != null){
            Node q = new Node(head.data);
            q.next = p;
            p = q;
            head = head.next;
        }
        head = p;
    }

    public void q3_remove_dup(){
        Node prev = head;
        Node cur = head.next;
        while (cur != null) {
            if (prev.data != cur.data){
                prev.next = cur;
                prev = cur;
            }
            cur = cur.next;
        }
        prev.next = null;
    }

    public void q4_increment_digits() {
        q2_reverse();

        Node p = head;
        int carry = 1;
        while (p != null){
            if (carry == 1){
                p.data += 1;
                carry = 0;
            }
            if (p.data >= 10){
                carry = 1;
                p.data = 0;
            }
            p = p.next;
        }
        
        q2_reverse();
        
        if (carry == 1){
            Node q = new Node(1);
            q.next = head;
            head = q;
        }
    }

    public boolean q5_isPalindrome() {
        ArrayList<Integer> listValues = new ArrayList<Integer>();
        Node p = head;
        
        while (p != null){
            listValues.add(p.data);
            p = p.next;
        }
        
        int left = 0;
        int right = listValues.size() - 1;
        
        while (left < right) {
            if (listValues.get(left) != (listValues.get(right))) {
                return false;
            }
            left++;
            right--;
        }
        
        return true;
    }
}
