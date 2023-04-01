
import java.util.*;
class Main{
    public static void main(String[] args)
    {
        int n;
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        int nums[]=new int[n];
        for(int i=0;i<n;i++)
            nums[i]=in.nextInt();
        Solution obj=new Solution();
        System.out.println(obj.solve(nums));

    }

}

public class Solution{

    static int solve(int nums[])
    {
        // your code here
        int n=nums.length,count=0;
        Map<Integer,Integer> hm= new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int pairs= nums[i] & nums[j];
                hm.put(pairs, hm.getOrDefault(pairs,0)+1);

            }
        }

        for(int key: hm.keySet()){
            int val=hm.get(key);
            for(int i:nums){
                if((i & key)==0)
                    count+=val;
            }
        }
        return count;

    }
}