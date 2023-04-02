import java.util.*;
public class Solution{
    private static int getMSB(int num){
        int count=-1;
        while(num>0){
            num=num>>1;
            count++;
        }
        return count;
    }
    public static int rangeBitwiseAnd(int left, int right) {
        //write your code here

        int ans=0;
        while(left>0 && right>0){
            int msb1=getMSB(left);
            int msb2=getMSB(right);
            if(msb1!=msb2)
                break;
            int rem=1<<msb1;
            ans+=rem;
            left-=rem;
            right-=rem;
        }
        return ans;
    }
}
class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int left = sc.nextInt();
        int right = sc.nextInt();
        System.out.print(Solution.rangeBitwiseAnd(left,right));
    }
}