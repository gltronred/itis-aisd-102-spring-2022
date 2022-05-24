import java.util.*;
import java.util.function.*;

public class L5 {
    public static int[] subset(int[] set, Function<int[],Integer> cmp) {
        int n = set.length;
        int[] a = new int[n];
        int min = cmp.apply(a);
        int[] b = new int[n];
        boolean f = true;
        while (f) {
            f = false;
            int i=n-1;
            while (i>=0 && a[i]==1) {
                a[i] = 0;
                i--;
            }
            if (i>=0) {
                f = true;
                a[i] = 1;
            }
            // System.out.println(Arrays.toString(a) + " " + cmp.apply(a));
            if (cmp.apply(a) < min) {
                for (i=0; i<n; i++)
                    b[i] = a[i];
            }
        }
        return b;
    }
    public static void main(String[] args) {
        int[] a = new int[]{1,-2,5,3};
        System.out.println(Arrays.toString(subset(a,x -> {
                        int w = 0;
                        int ws = 0;
                        for (int i=0; i<x.length; i++) {
                            w += a[i];
                            if (x[i] == 1) {
                                ws += a[i];
                            }
                        }
                        return Math.abs(w-2*ws);
                    })));
    }
}
