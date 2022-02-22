import java.io.*;
import java.util.*;

public class L1 {
    public static int f1(int a, int n) {
        int p = 1;
        for (int i=0; i<n; i++) {
            p*=a;
        }
        return p;
    }
    public static int f2(int a, int n) {
        if (n==0) return 1;
        if (n==1) return a;
        if (n%2 == 0) {
            int p = f2(a,n/2);
            return p*p;
        } else {
            return a*f2(a,n-1);
        }
    }
    public static void main(String[] args) {
        for (int n: new int[]{0,1,5,10}) {
            System.out.println("n=" + n + ":\t" + f1(3,n) + "\t" + f2(3,n));
        }
    }
}
