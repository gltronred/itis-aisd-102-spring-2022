

class Lst<T> {
    private T val;
    private Lst<T> next;

    public Lst(T val, Lst<T> next) {
        this.val = val;
        this.next = next;
    }

    public static <T> Lst<T> nil() { return null; }
    public static <T> Lst<T> cons(T head, Lst<T> tail) {
        return new Lst<>(head, tail);
    }

    public static <T> void print(Lst<T> lst) {
        Lst<T> p = lst;
        while (p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }
        System.out.println();
    }

    // Функция удаления всех чётных элементов
    // из списка
}

public class L2 {
    public static void main(String[] args) {
        Lst<Integer> lst = Lst.cons(1,
                            Lst.cons(2,
                             Lst.nil()));
        Lst.print(lst);
    }
}
