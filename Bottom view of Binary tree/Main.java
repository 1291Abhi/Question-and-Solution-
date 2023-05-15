
import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}


class Main {
    static Node buildTree(String str){
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        String ip[] = str.split(" ");
        Node root = new Node(Integer.parseInt(ip[0]));
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            Node currNode = queue.peek();
            queue.remove();
            String currVal = ip[i];
            if(!currVal.equals("N")) {
                currNode.left = new Node(Integer.parseInt(currVal));
                queue.add(currNode.left);
            }
            i++;
            if(i >= ip.length)
                break;
            currVal = ip[i];
            if(!currVal.equals("N")) {
                currNode.right = new Node(Integer.parseInt(currVal));
                queue.add(currNode.right);
            }
            i++;
        }
        return root;
    }
    void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t-- > 0){
            String s = br.readLine();
            Node root = buildTree(s);
            Solution tree = new Solution();
            ArrayList<Integer> ans = tree.bottomView(root);

            for(Integer num:ans)
                System.out.print(num+" ");

            System.out.println();
        }
    }
}
class Pair{
    int level;
    Node root;
    Pair(int level,Node root)
    {
        this.level=level;
        this.root=root;
    }
}


class Solution{

    public ArrayList <Integer> bottomView(Node root)
    {
        ArrayList<Integer> ans=new ArrayList<>();
        if(root==null)
            return ans;
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(0,root));
        int min=0,max=0;
        HashMap<Integer,Integer> hm=new HashMap<>();
        while(q.size()>0){
            int size=q.size();
            for(int i=0;i<size;i++){
                Pair temp=q.remove();
                hm.put(temp.level,temp.root.data);
                if(temp.root.left!=null)
                    q.add(new Pair(temp.level-1,temp.root.left));
                if(temp.root.right!=null)
                    q.add(new Pair(temp.level+1,temp.root.right));
                if(min>temp.level)
                    min=temp.level;
                if(max<temp.level)
                    max=temp.level;
            }
        }
        while(min<=max){
            ans.add(hm.get(min));
            min++;
        }
        return ans;
    }
}
