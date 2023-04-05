import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;


class Main {
    public static void main (String[] args) throws IOException{
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        //System.out.print(s);
        int n;
        n = sc.nextInt();
        int store[] = new int[n];
        for(int i=0;i<n;i++)
        {
            store[i] = sc.nextInt();
        }
        Solution answer = new Solution();
        System.out.println(answer.longestCycle(store));
    }
}



class Solution {
    public int longestCycle(int[] edges) {
        //your code here
        int ans=0;
        for(int i=0;i<edges.length;i++){
            int t=i;
            boolean visited[]=new boolean[edges.length];
            int count=0;
            while(visited[t]==false){
                visited[t]=true;
                t=edges[t];
                count++;
                if(t==-1)
                    break;
            }
            if(i==t)
                ans=Math.max(ans,count);
        }
        if(ans==0)
            return -1;
        return ans;
    }
}