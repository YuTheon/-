import java.util.Scanner;

public class w6e1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n= in.nextInt();
        char[] str = in.next().toCharArray();
        int[] next = new int[n+1];
        int i=1,now=0;
        while(i<n){
            if (str[i]==str[now]){
                now++;
                next[i]= now;
                i++;
            }
            else if (now != 0){
                now = next[now-1];
            }else{
                i++;
                next[i]=now;
            }
        }
        for (int j = 0; j < n; j++) {
            System.out.println(next[i]+" ");
        }
    }
}
