import java.util.Scanner;

import java.util.*;

public class Solution {
    private static boolean check(int n,long time,int[] batteries){
        long currentSum=0;
        long targetSum=n*time;
        for(int bat:batteries){
            if(bat<time){
                currentSum+=bat;
            }
            else{
                currentSum+=time;
            }
            if(currentSum>=targetSum)
                return true;
        }
        return false;
    }
    public static long maxRunTime(int n, int[] batteries) {
        long low=0;
        long ans=-1;
        long totalSum=0;
        for(int bat:batteries)
        {
            low=Math.min(bat,low);
            totalSum+=bat;
        }
        long high=(totalSum/n) +1;
        while(low<high){
            long mid=(low+high)/2;
            if(check(n,mid,batteries)){
                ans=mid;
                low=mid+1;
            }
            else{
                high=mid;
            }
        }
        return ans;

    }
}

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();

        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }
        int computers = scanner.nextInt();
        System.out.println(Solution.maxRunTime(computers, array));
        scanner.close();
    }
}
