import org.w3c.dom.Node;

import java.awt.event.WindowFocusListener;
import java.util.ArrayList;

public class lab4_1 {
    public static void main(String[] args) {
        QReader in = new QReader();
        QWriter out = new QWriter();
        int n=in.nextInt(),m= in.nextInt(),c=in.nextInt();
        long MODULE = (long)1e9+7;
        Node41[] node = new Node41[n+1];
        node[0] = new Node41(0);
        node[0].info[4]=c;
        for (int i = 1; i <= n; i++) {
             node[i] = new Node41(i);
            for (int j = 0; j < 4; j++) {
                node[i].info[j]=in.nextInt();
            }
            node[i].info[4]=0;
        }
        for (int i = 0; i < m; i++) {
            int a=in.nextInt(), b=in.nextInt();
            node[a].next.add(node[b]);
            node[b].back.add(node[a]);
            node[b].prop[1]++;
        }
        Node41[] order = new Node41[n+2];
        find_order(node, order, n);
        Node41[] term = new Node41[n+2];
        int end=0;
        find_term(order, term, n, end);

        boolean go=false;
        double maxD=0;long maxL=0;
        for (int i = 1; i <= n; i++) {

            for (Node41 nodeb : order[i].back){
                if (nodeb.prop[2]==0){//前一个节点<10e9
                    if (nodeb.info[4]>order[i].info[0]){//看是否更新CE
                        long CE=nodeb.info[4],ins=Math.max(Math.max(CE+order[i].info[1], CE*order[i].info[2]), order[i].info[3]);
                        if (order[i].prop[2]==0){//超过之后就不更新info[4]，只更新CE
                            if (ins>order[i].info[4]) {
                                order[i].info[4] = ins;
                                if (order[i].info[4]>1e9){
                                    order[i].CE=Math.log10(order[i].info[4]);
                                    order[i].prop[2]=1;
                                }
                            }
                        }
                        else {
                            if (Math.log10(ins) > order[i].CE)
                                order[i].CE = Math.log10(ins);
                        }
                    }
                }
                else{
                    if (nodeb.CE>Math.log10(order[i].info[0])){
                        double ins = nodeb.CE+Math.log10(order[i].info[2]);
                        if (ins > order[i].CE)
                            order[i].CE = ins;
                    }
                }
            }
            if (order[i].next.size()==0) {
                if (order[i].CE != 0 || order[i].info[4]!=0) {
                    go = true;
                    if (order[i].prop[2]==0){
                        if (order[i].info[4]>maxL)
                            maxL = order[i].info[4];
                    }
                    else{
                        if (order[i].CE > maxD)
                            maxD = order[i].CE;
                    }
                }
            }
        }
        if (go){
            if (maxD==0)
                System.out.println(maxL%MODULE);
            else{
                if (Math.pow(10,maxD)>maxL)
                    maxL = (long)Math.pow(10,maxD);
                System.out.println(maxL%MODULE);
            }
        }
        else System.out.println(-1);

    }
    public static void find_term(Node41[] order, Node41[] term, int size,int end){
        int p=size;
        while(order[p].next.size()==0){
            term[end++]=order[p--];
        }
    }
    public static void find_order(Node41[] node, Node41[] order, int size){//排序正确吗
        int p=0;
        order[p++]=node[0];
        for (int i = 1; i <= size ; i++) {
            if (node[i].prop[1]==0) {
                order[p++] = node[i];
                node[0].next.add(node[i]);
                node[i].back.add(node[0]);
            }
        }
        int begin =0;
        while(p < size){//分段
            int temp = p-1;
            for (int i = begin; i <= temp ; i++) {
                for (Node41 node41: order[i].next){
                    if (--node41.prop[1]<=0)
                        order[p++] = node41;
                }
            }
            begin = temp+1;
        }

    }
}
class Node41{
    int[] prop = new int[3];//val,in,whether_ex
    long[] info = new long[5];//h,a,b,c,ce
    double CE =0;
    ArrayList<Node41> next = new ArrayList<>(), back = new ArrayList<>();
    public Node41(){}
    public Node41(int val){
        prop[0]=val;
    }
}