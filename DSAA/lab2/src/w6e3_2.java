import java.util.Scanner;

public class w6e3_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        char[] ss = in.next().toCharArray();
        int cnt=0, dir=1,l=0, r=n/2;
        while(l < n/2){
            if (ss[l] == ss[r]){
                l++;
                r++;
            }else if(l==0){
                dir=0;
                r++;
                cnt++;
            }

        }
    }
}
