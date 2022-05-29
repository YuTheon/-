import java.util.*;

public class lab13_1 {
    public static void main(String[] args) {
        QReader in = new QReader();
        QWriter out = new QWriter();
        int n = in.nextInt(), m = in.nextInt(), cnt = 0;
        Edge131[] edge = new Edge131[2*m+1];
        for (int i = 0; i < 2*m+1; i++) {
            edge[i] = new Edge131();
        }
        int[] head = new int[n+1];
        for (int i = 0; i < n+1; i++) {
            head[i] = -1;
        }
        for (int i = 0; i < m; i++) {
            int a = in.nextInt(), b = in.nextInt(), c = in.nextInt();
            edge[cnt].to = b;
            edge[cnt].weight = c;
            edge[cnt].next = head[a];
            head[a] = cnt++;
            edge[cnt].to = a;
            edge[cnt].weight = 0;
            edge[cnt].next = head[b];
            head[b] = cnt++;
        }
        int[] vis = new int[n+1], near = new int[n+1];
        for (int i = 1; i <= n ; i++) {
            near[i] = Integer.MAX_VALUE;
        }
        vis[1] = 1; near[1] = 0;
        Queue<Integer> Q = new Queue<Integer>() {
            @Override
            public boolean add(Integer integer) {
                return false;
            }

            @Override
            public boolean offer(Integer integer) {
                return false;
            }

            @Override
            public Integer remove() {
                return null;
            }

            @Override
            public Integer poll() {
                return null;
            }

            @Override
            public Integer element() {
                return null;
            }

            @Override
            public Integer peek() {
                return null;
            }

            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<Integer> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends Integer> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }
        };
        Q.add(1);
        while (!Q.isEmpty()){
            int u = Q.peek(), minEdge=Integer.MAX_VALUE, nextP=-1;
            Q.poll();
            for (int i = head[u]; i != -1; i = edge[i].next) {
                int v = edge[i].to, w = edge[i].weight;
                if (w < minEdge && vis[v] != 1){
                    minEdge = w;
                    nextP = v;
                }
                if (near[u]+w < near[v]){
                    near[v] = near[u]+w;
                }
            }
            if (nextP != -1) {
                Q.add(nextP);
                vis[nextP] = 1;
            }
        }





    }
}
class Edge131{
    int to, weight, next;
    public Edge131(){next = -1;}

}