import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        String inputLine[] = br.readLine().trim().split(" ");
        int[] nums = new int[n];
        for(int i=0; i<n; i++)nums[i]=Integer.parseInt(inputLine[i]);
        int[] res = new Solution().nextLarger2(nums, n);
        for (int i = 0; i < n; i++)
            System.out.print(res[i] + " ");
        System.out.println();
    }
}
class Solution{

    public static int[] nextLarger2(int[] nums, int n)
    {
        int ans[]=new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!st.empty() && st.peek()<=nums[i])
                st.pop();
            if(st.empty())
                ans[i]=-1;
            else
                ans[i]=st.peek();
            st.push(nums[i]);
        }
        for(int i=n-1;i>=0;i--){
            while(!st.empty() && st.peek()<=nums[i])
                st.pop();
            if(st.empty())
                ans[i]=-1;
            else
                ans[i]=st.peek();
            st.push(nums[i]);
        }
        return ans;

    }
}