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
        return null;
    }
    public static void main(String[] args) {
        int[] freq = {30, 5,5, 8,7, 12,12, 14};
        String[] letters = {"a", "b", "c", "d", "e", "f", "g", "h"};
        Tree code = huffman(freq, letters);
        showCode(code);
    }
}
