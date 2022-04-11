import java.util.Arrays;
import java.util.Scanner;

public class w6e3_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        char[] ss = in.next().toCharArray();
        int cnt1=0,cnt2=0, l=0, r=n/2;
        while(l < n/2 && r < n){
            if (ss[l] == ss[r]){
                l++;
                r++;
            }
            else {
                r++;
                cnt1++;
            }
            if (cnt1 > 2)break;
        }

        l=0; r=n/2+1;
        while(r<n && l<n/2+1){
            if (ss[l] == ss[r]){
                l++;
                r++;
            }
            else{
                l++;
                cnt2++;
            }
            if (cnt2 > 2)break;
        }

        String ans= new String(ss);
        if (n % 2 == 0)
            System.out.println("NOT POSSIBLE");
        else if (cnt1==0){
            if (cnt2>=2) {
                ans = ans.substring(n/2+1,n);
            }
            else
                ans = "NOT UNIQUE";
        }
        else if (cnt1==1){
             if (cnt2==0){
                 ans = ans.substring(n/2+1,n);
             }
             else if (cnt2 == 1){
                 if (n==3)
                     ans = "NOT POSSIBLE";
                 else
                     ans = ans.substring(0,n/2+1);
             }
             else
                 ans = "NOT POSSIBLE";
        }
        //有点吃力，没仔细想
        else if (cnt1 == 2){
            if (n == 3){
                ans = "NOT POSSIBLE";
            }
            else if (n == 5){
                if (cnt2 == 1){
                    ans = ans.substring(n/2+1, n);
                }
                else ans = "NOT POSSIBLE";
            }
            else {
                if (cnt2 == 1){
                    ans = ans.substring(n/2+1, n);
                }
                else ans = "NOT POSSIBLE";
            }
        }
        else{
            if (cnt2 == 0 || cnt2 == 1)
                ans = ans.substring(n/2+1, n);
            else
                ans = "NOT POSSIBLE";
        }
        System.out.println(ans);

    }
}
