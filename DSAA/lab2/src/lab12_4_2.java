import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class lab12_4_2 {
    public static void main(String[] args) {
        QReader in = new QReader();
        QWriter out = new QWriter();
        int n = in.nextInt(), m = in.nextInt();
        Node1242[] node1242s = new Node1242[n+1];
        for (int i = 1; i <= n ; i++) {
            node1242s[i] = new Node1242(i);
        }
        for (int i = 0; i < m; i++) {
            int a = in.nextInt(), b = in.nextInt();
            node1242s[a].next.add(node1242s[b]);
            node1242s[b].indeg++;
        }
        PriorityQueue<Node1242> priorityQueue = new PriorityQueue<Node1242>(new Comparator<Node1242>(){
            @Override
            public int compare(Node1242 o1, Node1242 o2){
                return o1.val - o2.val;
            }
        });
        for (int i = 1; i <= n ; i++) {
            if (node1242s[i].indeg == 0){
                priorityQueue.add(node1242s[i]);
            }
        }
        Node1242[] order = new Node1242[n+1];int l = 0;
        while (!priorityQueue.isEmpty()){
            //int len = priorityQueue.size();
            //for (int i = 0; i < len; i++) {
                Node1242 node = priorityQueue.peek();priorityQueue.poll();
                for (Node1242 no : node.next){
                    no.indeg--;
                    if (no.indeg == 0 ){
                        priorityQueue.add(no);
                    }
                }
                order[l++] = node;

            //}
        }
        if (l == 0){
            out.print(-1);
        }else {
            for (int i = 0; i < l; i++) {
                out.print(order[i].val + " ");
            }
        }
        out.close();
    }
}
class Node1242{
    int val, indeg;
    ArrayList<Node1242> next;
    public Node1242(){}
    public Node1242(int val){
        this.val = val;
        this.indeg = 0;
        next = new ArrayList<>();
    }
}
