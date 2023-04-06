import java.util.*;

class Solution {
    static Long mostWater(int size, int arr[]) {

        long ans=0;
        int start=0,end=size-1;
        while(start<end){
            ans=Math.max((end-start)*Math.min(arr[start],arr[end]),ans);
            if(arr[start]<arr[end])
                start++;
            else
                end--;
        }
        return ans;
    }

}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int array[] = new int[n];

        for(int i=0; i<n; i++){
            array[i]= sc.nextInt();
        }
        Solution Obj = new Solution();
        System.out.println(Obj.mostWater(n,array));
    }
}
