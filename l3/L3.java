import java.util.*;

class BinaryHeap {
    private int[] a;
    private int n;

    public BinaryHeap() {
        a = new int[100];
        n = 0;
    }
    public int getMin() {
        return a[0];
    }
    void swap(int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
    public int extractMin() {
        int r = a[0];
        n--;
        a[0] = a[n];
        int i=0;
        while (2*i+1<n && (a[i]>a[2*i+1] || 2*i+2<n && a[i]>a[2*i+2])) {
            if (a[2*i+1] < a[2*i+2] || 2*i+2==n) {
                swap(i, 2*i+1);
                i = 2*i+1;
            } else {
                swap(i, 2*i+2);
                i = 2*i+2;
            }
        }
        return r;
    }
    public void insert(int x) {
        a[n] = x;
        int i = n;
        n++;
        while (i>0 && a[(i-1)/2] > a[i]) {
            swap((i-1)/2, i);
            i = (i-1)/2;
        }
    }
    public String toString() {
        return Arrays.toString(Arrays.copyOf(a,n));
    }
}

public class L3 {
    public static void main(String[] args) {
        Random r = new Random();

        BinaryHeap h = new BinaryHeap();
        for (int i=0; i<10; i++) {
            if (i<7) {
                int x = r.nextInt(10);
                System.out.println("Insert " + x);
                h.insert(x);
                System.out.println("Heap: " + h);
            }
            if (i>3) {
                int y = h.extractMin();
                System.out.println("Min: " + y);
                System.out.println("Heap: " + h);
            }
        }
    }
}
