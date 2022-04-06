import java.io.*;
import java.util.StringTokenizer;
//如果有哈希函数该怎么改这个
public class lab5_1_2 {
    public static void main(String[] args) {
        QReader in = new QReader();
        QWriter out = new QWriter();
        int n=in.nextInt(),m=in.nextInt(),a,b,c;
        Node512[] node512s = new Node512[30005];
        Node512 head = new Node512(0,-1), tail = new Node512(0,-1);
        head.next = tail; tail.back = head;
        for (int i = 0; i < m; i++) {
            switch (in.next().charAt(0)){
                case 'p':
                    a=in.nextInt(); b=in.nextInt();
                    if (node512s[a] == null){
                        node512s[a] = new Node512(a,b);
                        node512s[a].next = head.next;
                        head.next.back = node512s[a];
                        head.next = node512s[a];
                        node512s[a].back = head;
                        if(tail.key == n){
                            c=tail.back.key;
                            node512s[c]=null;
                            tail.back = tail.back.back;
                            tail.back.next = tail;
                        }
                        else tail.key++;
                    }
                    else{//更新
                        node512s[a].val = b;
                        node512s[a].back.next = node512s[a].next;
                        node512s[a].next.back = node512s[a].back;
                        node512s[a].next = head.next;
                        head.next.back = node512s[a];
                        node512s[a].back = head;
                        head.next = node512s[a];
                    }
                    break;
                case 'g':
                    a=in.nextInt();
                    if (node512s[a] == null)
                        out.println(-1);
                    else {
                        out.println(node512s[a].val);
                        node512s[a].back.next = node512s[a].next;
                        node512s[a].next.back = node512s[a].back;
                        node512s[a].next = head.next;
                        head.next.back = node512s[a];
                        node512s[a].back = head;
                        head.next = node512s[a];
                    }
                    break;
            }
        }
        out.close();

    }
}
class Node512{
    int key, val;
    Node512 next, back;
    public Node512(){}
    public Node512(int key, int val){
        this.val = val;
        this.key = key;
        next = new Node512();
        back = new Node512();
    }
}

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
