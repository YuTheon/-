/*
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class lab5_2 {
    public static void main(String[] args) {
        QReader in = new QReader();
        QWriter out = new QWriter();
        int n = in.nextInt(), m = in.nextInt();
        Node52[] node52s = new Node52[n + 1];
        Edge52[] edge52s = new Edge52[n + 1];
        Edge52 edgeHead = new Edge52(0, 0, 0), curEdge = edgeHead;
        for (int i = 1; i <= n; i++) {
            node52s[i] = new Node52(i);
        }
        for (int i = 1; i <= n; i++) {
            edge52s[i] = new Edge52(0, i, 0);
        }
        for (int i = 0; i < m; i++) {
            int a = in.nextInt(), b = in.nextInt();
            long w = in.nextLong();//边的等下再来看
            curEdge.anw = new Edge52(a, b, w);
            curEdge = curEdge.anw;
            node52s[a].link.add(node52s[b]);
            node52s[a].weight.add(w);
            node52s[b].link.add(node52s[a]);
            node52s[b].weight.add(w);
        }
        for (int i = 0; i < m; i++) {
            //第一次跑dij
            int s=in.nextInt(), t=in.nextInt();
            int[] outQ = new int[n + 1];//是否出过队列
            long[] nodeToStart = new long[n + 1];//node到起点的最短距离
            int cnt = 1;
            Queue<nod> minHeap = new java.util.PriorityQueue<>(new Comparator<nod>(){
                @Override
                public int compare(nod o1, nod o2) {
                    int ans = (int) (Math.log10(o1.dis)-Math.log10(o2.dis));
                    return ans;
                }
            });
            nodeToStart[s] = 0;
            outQ[s] = 1;
            Node52 S = node52s[s];
            while(cnt != n){
                for (int j = 0; j < S.link.size(); j++) {//对于取出来的，将连出来的放进去
                    if (outQ[S.link.get(j).val] == 0){
                        minHeap.add(new nod(S.link.get(j).val, S.val, S.weight.get(j)));
                    }
                }
                if (minHeap.peek() == null)break;
                while (true){//
                    if (minHeap.peek() == null)break;
                    nod tempNode = minHeap.poll();
                    int kk = tempNode.id, hh = tempNode.last;
                    long ww = tempNode.dis;
                    if (outQ[kk] == 0){
                        cnt++;
                        outQ[kk] = 1;
                        S = node52s[kk];
                        nodeToStart[kk] = nodeToStart[hh]+ww;
                        break;
                    }
                }
            }
            //反向dij
            outQ = new int[n+1];
            Node52[] bb = new Node52[n+1];
            bb[0] = node52s[t];
            int front =0, rear = 1;cnt=1;
            while(cnt != n){
                int temp = rear;
                for (int j = front; j <temp ; j++) {
                    for (int k = 0; k < bb[j].link.size(); k++) {
                        Node52 nn = bb[j].link.get(k);
                        if (outQ[nn.val] == 0){
                            bb[rear++] = nn;cnt++;
                            for (int l = 0; l < nn.link.size(); l++) {
                                if (nn.link.get(l).val == bb[j].val){//找到上一个点
                                    if (nodeToStart[nn.val]+nn.weight.get(l) == nodeToStart[bb[j].val]){
                                        //对应的边可以加1
                                    }
                                }
                            }
                        }
                    }
                }
                front = temp;

            }


        }

    }


    static class nod {
        int id,last;
        long dis;
        public nod() {

        }
        public nod(int id, int last, long dis) {
            this.id = id;
            this.last = last;
            this.dis = dis;
        }
    }
}

class Node52{
    int val;
    ArrayList<Node52> link;
    ArrayList<Long> weight;
    public Node52(){}
    public Node52(int val){
        this.val = val;
        link = new ArrayList<>();
        weight = new ArrayList<>();
    }
}
class Edge52{
    int a,b;
    long weight;
    Edge52 anw, next, back;//anw指anwser, 按anwser的顺序
    public Edge52(){}
    public Edge52(int a, int b, long weight ){
        if (a<b){
            this.a = a;
            this.b = b;
        }
        else {
            this.a = b;
            this.b = a;
        }
        this.weight = weight;
        anw = new Edge52();
        next = new Edge52();
        back = new Edge52();
    }
}


*/
