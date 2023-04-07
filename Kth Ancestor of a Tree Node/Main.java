import java.util.*;

class Solution {
    public int kthAncestor(int n, int[] parent, int node, int k) {
        //write code here
        int p=parent[node]; //taking the parent of node
        k--;                //decrease as we find first ancestor of node

        while(p!=-1 && k!=0){   //run unitil we find kth ancestor or there is no  more ancestor
            p=parent[p];//update ancestor
            k--;
        }

        return p;

    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int parent[] = new int[n];
        for (int i = 0; i < n; i++)
            parent[i] = sc.nextInt();
        int node = sc.nextInt();
        int k = sc.nextInt();
        Solution obj = new Solution();
        System.out.println(obj.kthAncestor(n, parent, node, k));
        sc.close();
    }
}