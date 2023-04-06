import java.util.*;
public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        LinkedList llist= new LinkedList();
        int a1=sc.nextInt();
        Node head= new Node(a1);
        llist.addToTheLast(head);
        for (int i = 1; i < n; i++)
        {
            int a = sc.nextInt();
            llist.addToTheLast(new Node(a));
        }

        Solution A = new Solution();
        llist.head = A.removeDuplicatesFromSortedList(llist.head);
        llist.printList();

    }
}

class Node
{
    int data;
    Node next;
    Node(int d) {data = d; next = null; }
}

class LinkedList
{
    Node head;
    Node tail;
    public void addToTheLast(Node node)
    {
        if (head == null)
        {
            head = node;
            tail = node;
        }
        else
        {
            tail.next = node;
            tail = node;
        }
    }
    void printList()
    {
        Node temp = head;
        while (temp != null)
        {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }

}

class Solution
{

    public static Node removeDuplicatesFromSortedList(Node head)
    {
        //use space complexity
        // Map<Integer,Integer> hm=new HashMap<>();
        // Node temp=head;
        // while(temp!=null){
        // 	hm.put(temp.data,hm.getOrDefault(temp.data,0)+1);
        // 	temp=temp.next;
        // }
        // while(head!=null && hm.get(head.data)>1)
        // 	head=head.next;
        // temp=head;
        // while(temp!=null){
        // 	if(temp.next!=null && hm.get(temp.next.data)>1){
        // 		temp.next=temp.next.next;
        // 		continue;
        // 	}
        // 	temp=temp.next;
        // }
        // return head;
        if(head==null)
            return head;
        Node temp=head;
        Node prev=null;
        while(temp!=null && temp.next!=null){
            if(temp.data==temp.next.data){
                while(temp!=null && temp.next!=null && temp.data==temp.next.data)
                    temp=temp.next;
                if(prev==null)
                    head=temp.next;
                else
                    prev.next=temp.next;
            }
            else
                prev=temp;
            temp=temp.next;

        }
        return head;

    }

}