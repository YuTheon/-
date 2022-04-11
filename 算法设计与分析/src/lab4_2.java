public class lab4_2 {
    public static void main(String[] args) {
        QReader in = new QReader();
        QWriter out = new QWriter();
        long sum=0;
        int n=in.nextInt(), m=in.nextInt(), base=0;
        double log2n = Math.log(n) / Math.log(2);
        long[][] a=new long[n+1][(int) log2n +2];
        long[] b=new long[n+1];
        for (int i = 1; i <= n; i++) {
            a[i][0]=in.nextLong();
        }
        b[0]=0;
        for (int i = 1; i <= n; i++) {
            b[i]=in.nextLong()+b[i-1];
        }//sum(l~r) = b[r]-b[l-1]

        //st table
        int[] logn = new int[n+1];
        int[][] addr = new int[n+1][(int) log2n +4];
        for (int i = 1; i <= n ; i++) {
            addr[i][0] = i;
        }
        logn[1]=0; logn[2]=1;
        for (int i = 3; i <= n ; i++) {
            logn[i] = logn[i/2]+1;
        }
        for (int j = 1; j <= log2n + 4; j++) {
            for (int i = 1; i+(1<<j)-1 <= n ; i++) {
                if (a[i][j-1] > a[i+(1<<(j-1))][j-1]){
                    a[i][j] = a[i+(1<<(j-1))][j-1];
                    addr[i][j] = addr[i+(1<<(j-1))][j-1];
                }
                else{
                    a[i][j] = a[i][j-1];
                    addr[i][j] = addr[i][j-1];
                }
            }
        }

        /*for (int i = 1; i <= n ; i++) {
            for (int j = 0; j <= (int)log2n+1 ; j++) {
                out.print(a[i][j]+" ");
            }
            out.println("");
        }
        System.out.println();
        for (int i = 1; i <= n ; i++) {
            for (int j = 0; j <= (int)log2n+1 ; j++) {
                out.print(addr[i][j]+" ");
            }
            out.println("");
        }
*/



       // System.out.println(Math.log(4)/Math.log(2)+" "+Math.log10(10));
        out.close();
    }
}
