import java.util.Scanner;

public class w6e3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String ss = in.next();
        String s0, s1, s2;
        String[] ans = new String[2];
        int p=0;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (i==0)
                s0 = ss.substring(1,n);
            else if (i==n-1)
                s0 = ss.substring(0,n-1);
            else
                s0 = ss.substring(0,i).concat(ss.substring(i+1,n));
            s1 = s0.substring(0,(n-1)/2);
            s2 = s0.substring((n-1)/2, n-1);
            if (s1.compareTo(s2)==0){
                ans[p++] = s1;
                cnt++;
            }
            if (cnt == 2)break;
        }
        if (cnt == 0)
            System.out.println("NOT POSSIBLE");
        else if (cnt == 1)
            System.out.println(ans[0]);
        else
            System.out.println("NOT UNIQUE");
    }
}
