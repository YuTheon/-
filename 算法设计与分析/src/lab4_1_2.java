import java.util.ArrayList;
import java.io.*;
import java.util.StringTokenizer;

public class lab4_1_2 {
    //too long ago so I decide to rewrite
    public static void main(String[] args) {
        QReader in = new QReader();
        QWriter out = new QWriter();
        long maxL=0, maxM=0,ex=0;
        double maxD=0;
        //input info
        int n=in.nextInt(), m=in.nextInt(), c=in.nextInt();
        Node412[] nodes = new Node412[n+1];
        for (int i = 1; i <=n ; i++) {
            nodes[i] = new Node412(i);
            for (int j = 0; j < 4; j++) {
                nodes[i].info[j] = in.nextInt();
            }
        }
        for (int i = 0; i < m; i++) {
            int a=in.nextInt(), b=in.nextInt();
            nodes[a].next.add(nodes[b]);
            nodes[b].inde++;
        }
        nodes[0] = new Node412(0);
        nodes[0].ceL = c; nodes[0].ceM = c;
        for (int i = 1; i <= n ; i++) {
            if (nodes[i].inde == 0){
                nodes[0].next.add(nodes[i]);
                nodes[i].inde++;
            }
        }

        //topo order
        Node412[] order = new Node412[n+1];
        order[0] = nodes[0];
        int front=0, rear=0;
        while(front < n){
            if (order[front].next.size() != 0){
                for (Node412 node: order[front].next){
                    if (--node.inde == 0){
                        order[++rear] = node;
                    }
                }
            }
            front++;
        }

        //go the order
        for (int i = 0; i <= n; i++) {
            Node412 now = order[i];
            if (now.next.size() != 0){
                if (now.ex == 0 && now.ceL != 0){
                    for (Node412 node:now.next){
                        if (node.info[0] <= now.ceL ){
                            long max = Math.max(Math.max(node.info[1]+now.ceL, node.info[2]*now.ceL), node.info[3]),
                            maxMM = Math.max(Math.max(node.info[1]+now.ceM, node.info[2]*now.ceM), node.info[3])%(long)(1e9+7);
                            if (max > node.ceL){
                                node.ceL = max;
                                node.ceM = maxMM;
                            }
                            if (node.ceL > 1e9){
                                node.ex=1;
                                node.ceD = Math.max(Math.log10(node.ceL),node.ceD);
                            }//else pass
                        }// else pass
                    }//go all the next and update
                }
                else if (now.ex == 1 && now.ceD != 0){
                    for (Node412 node: now.next){
                        double max = now.ceD+Math.log10(node.info[2]);
                        node.ex = 1;
                        if (max > node.ceD){
                            node.ceD = max;
                            node.ceM = (now.ceM*node.info[2])%(long)(1e9+7);
                        }

                    }
                }//else pass

            }
            else{
                if (ex == 0){
                    if (now.ex == 0){
                        if (now.ceL > maxL){
                            maxL = now.ceL;
                            maxM = now.ceM;
                        }
                    }
                    else{
                        ex = 1;
                        maxM = now.ceM;
                        maxD = now.ceD;
                    }
                }
                else{
                    if (now.ex == 1){
                        if (now.ceD > maxD){
                            maxD = now.ceD;
                            maxM = now.ceM;
                        }
                    }
                }
            }//for terminal point, max
        }
        if (maxL + maxD == 0)
            maxM = -1;
        maxM %= (long)(1e9+7);
        out.println(maxM);

        /*if (maxD > Math.log10(maxL)){
            long back = (long)Math.pow(10, maxD);
            back %= 1e9+7;
            if (back == 0)
                out.println(-1);
            else
                out.println(back);
        }
        else {
            maxL %= 1e9 + 7;
            if (maxL == 0)
                out.println(-1);
            else out.println(maxL);
        }*/
      /*  for (int i = 0; i <= n; i++) {
            out.println(order[i].val +" "+ order[i].ceM+" "+order[i].ceL+" "+order[i].ceD+" "+order[i].ex);
        }

        long[] ans = new long[5];
        ans[0] = (long)(4e9 % (1e9+7));
        ans[1] = (long)(ans[0]*47 % (1e9+7));
        ans[2] = (125 * ans[1])%(long)(1e9+7);
        ans[3] = (35 * ans[1])%(long)(1e9+7);
        ans[4] = (34 * ans[2])%(long)(1e9+7);
        long aa =  (34 *125* ans[2])%(long)(1e9+7);
        out.println(ans[0]+" "+ans[1]+" "+ans[2]+" "+ans[3]+" "+ans[4]+" "+aa);

        out.print(order[2].ceD+Math.log10(34)+" ");
        out.println(order[3].ceD+Math.log10(34));
*/

        out.close();

    }
}
class Node412{
    int val, ex=0, inde=0;
    long ceL=0, ceM=0;
    double ceD=0;
    int[] info= new int[4];
    ArrayList<Node412> next;
    public Node412(){}
    public Node412(int val){
        this.val = val;
        next = new ArrayList<>();
    }
}
/*

class QReader {
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer tokenizer = new StringTokenizer("");

    private String innerNextLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            return null;
        }
    }

    public boolean hasNext() {
        while (!tokenizer.hasMoreTokens()) {
            String nextLine = innerNextLine();
            if (nextLine == null) {
                return false;
            }
            tokenizer = new StringTokenizer(nextLine);
        }
        return true;
    }

    public String nextLine() {
        tokenizer = new StringTokenizer("");
        return innerNextLine();
    }

    public String next() {
        hasNext();
        return tokenizer.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public long nextLong() {
        return Long.parseLong(next());
    }
}

class QWriter implements Closeable {
    private BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public void print(Object object) {
        try {
            writer.write(object.toString());
        } catch (IOException e) {
            return;
        }
    }

    public void println(Object object) {
        try {
            writer.write(object.toString());
            writer.write("\n");
        } catch (IOException e) {
            return;
        }
    }

    @Override
    public void close() {
        try {
            writer.close();
        } catch (IOException e) {
            return;
        }
    }
}
*/
