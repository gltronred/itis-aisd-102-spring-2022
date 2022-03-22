import java.util.*;

class Pair<K,V> {
    K fst;
    V snd;
    public Pair(K k, V v) {
        this.fst = k;
        this.snd = v;
    }
    public String toString() {
        return fst + "=" + snd;
    }
}

class Table<K,V> {
    private ArrayList<LinkedList<Pair<K,V>>> a;
    private int n;              // длина массива
    private int cnt;            // количество эл-в

    public Table() {
        n = 7;
        a = new ArrayList<>();
        for (int i=0; i<n; i++) a.add(null);
        cnt = 0;
    }
    void insertTo(ArrayList<LinkedList<Pair<K,V>>> a, int n, K k, V v) {
        int i = k.hashCode() % n;
        if (a.get(i) == null) {
            a.set(i, new LinkedList<>());
        }
        a.get(i).add(new Pair<>(k,v));
    }
    void changeSize(int newSize) {
        ArrayList<LinkedList<Pair<K,V>>> b = new ArrayList<>();
        for (int i=0; i<newSize; i++) b.add(null);
        for (LinkedList<Pair<K,V>> l : a) {
            if (l != null) {
                for (Pair<K,V> p : l) {
                    insertTo(b, newSize, p.fst, p.snd);
                }
            }
        }
        n = newSize;
        a = b;
    }
    public void insert(K k, V v) {
        insertTo(a,n,k,v);
        cnt++;
        if (cnt > 0.85*n) {
            changeSize(3*n/2);
        }
    }
    public V lookup(K k) {
        int i = k.hashCode() % n;
        if (a.get(i) == null) {
            return null;
        }
        for (Pair<K,V> el : a.get(i)) {
            if (el.fst.equals(k)) {
                return el.snd;
            }
        }
        return null;
    }
    public String toString() {
        return a.toString();
    }
}

public class L4 {
    public static void main(String[] args) {
        Table<String,Integer> t = new Table<>();
        for (Integer i=0; i<10; i++) {
            String k = i.toString();
            k = k + k;
            t.insert(k, i);
            System.out.println(t);
        }
        System.out.println(t.lookup("88"));
        System.out.println(t.lookup("100"));
    }
}
