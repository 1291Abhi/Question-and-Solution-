import java.io.*;
import java.util.*;

public class Main {
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] A = new int[n];
        for(int i=0;i<n;i++)
            A[i] = sc.nextInt();

        Solution Obj= new Solution();

        System.out.println(Obj.findNumberOfTriangles(A));
    }

}
class Solution{
    public static int findNumberOfTriangles(int[] arr) {
        int count=0;
        int n=arr.length;
        Arrays.sort(arr);
        for(int i=n-1;i>=0;i--){
            int l=0,r=i-1;
            while(l<r){
                if(arr[l]+arr[r]>arr[i])
                {
                    count=count%1000000007+(r-l);
                    r--;
                }
                else
                    l++;
            }
        }
        return count;
    }
}