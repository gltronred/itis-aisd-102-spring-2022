# АиСД 2022, группа 11-102

## Домашние задания

# 1

В папке `homeworks/1` выложите класс списка, дополнив его методом

``` java
public static Lst<T> change12(Lst<T> lst) {
    return lst;
}
```

Этот метод должен менять местами первый и второй элемент списка, третий и четвертый, пятый и шестой и т.д., меняя указатели на следующий. Если в списке нечётное количество элементов, последний элемент остаётся на месте.

# 2


В папке `homeworks/2` выложите класс списка, дополнив его методом

``` java
public static Pair<Integer,Integer> findCycle(Lst<T> lst) {
    return new Pair<>(0,0);
}
```

Методу передаётся либо обычный линейный список, либо список, последний элемент которого указывает куда-то внутрь списка. Метод возвращает, соответственно, либо пару из длины списка и 0 (если список линейный), либо пару из количества элементов до цикла и в цикле. Класс Pair импортируйте из пакета [javafx.util](https://docs.oracle.com/javase/8/javafx/api/javafx/util/Pair.html).

Также нужно оценить сложность работы этого метода.
