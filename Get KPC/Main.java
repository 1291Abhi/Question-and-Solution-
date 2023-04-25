import java.util.*;

class Solution {
    private List<String> arr=new ArrayList<>();
    private void helper(String s,String[] keyPad,int index,String str){
        if(index>=s.length()){
            if(str.length()==4)
                arr.add(str);
//            System.out.println(str);
            return;
        }
        for(int i=0;i<keyPad[s.charAt(index)-'0'].length();i++)
            helper(s,keyPad,index+1,str+keyPad[s.charAt(index)-'0'].charAt(i));
    }

    public int GetKPC(String s) {
        if(s.length()<4)
            return 0;
        String []keyPad={".;","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};
        helper(s,keyPad,0,"");
        return arr.size();

    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        Solution Obj = new Solution();
        int ans = Obj.GetKPC(s);
        System.out.println(ans);
    }
}