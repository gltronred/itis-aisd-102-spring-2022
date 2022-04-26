import java.io.*;
import java.util.*;

class Tree {
    private Tree left;
    private Tree right;
    private int freq;
    private String letter;

    public Tree(int freq, String letter, Tree left, Tree right) {
        this.freq = freq;
        this.letter = letter;
        this.left = left;
        this.right = right;
    }

    public int getFreq() { return freq; }
    public Tree getLeft() { return left; }
    public Tree getRight() { return right; }
    public String getLetter() { return letter; }
}

public class L6 {
    public static void showCodePrefixed(String prefix, Tree code) {
        if (code == null) {
            return;
        }
        if (code.getLeft() == null && code.getRight() == null) {
            System.out.println(code.getLetter() + "\t" + prefix);
        }
        showCodePrefixed(prefix + "0", code.getLeft());
        showCodePrefixed(prefix + "1", code.getRight());
    }
    public static void showCode(Tree code) {
        showCodePrefixed("", code);
    }
    public static Tree huffman(int[] freq, String[] letters) {
        PriorityQueue<Tree> pq =
            new PriorityQueue<>(Comparator.comparing(t -> t.getFreq()));
        for (int i=0; i<freq.length; i++) {
            pq.add(new Tree(freq[i],
                            letters[i],
                            null,
                            null));
        }
        while (pq.size() > 1) {
            Tree m1 = pq.poll();
            Tree m2 = pq.poll();
            System.out.println("DEBUG:\t" +
                               m1.getLetter() + " " + m1.getFreq() +
                               "\t+\t" +
                               m2.getLetter() + " " + m2.getFreq());
            pq.add(new Tree(m1.getFreq() + m2.getFreq(),
                            m1.getLetter() + m2.getLetter(),
                            m1,
                            m2));
        }
        return pq.poll();
    }
    public static void main(String[] args) {
        int[] freq = {30, 5,5, 8,7, 12,12, 14};
        String[] letters = {"a", "b", "c", "d", "e", "f", "g", "h"};
        Tree code = huffman(freq, letters);
        // Tree code = huffman(new int[]{5,3,1,1},
        //                     new String[]{"a","b","c","d"});
        showCode(code);
    }
}
