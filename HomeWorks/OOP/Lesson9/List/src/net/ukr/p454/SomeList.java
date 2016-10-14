package net.ukr.p454;


import java.util.ArrayDeque;

/**
 * Created by vkekukh on 14.09.2016.
 */
public class SomeList <T> {
    private ArrayDeque<T> list = new ArrayDeque<>();

    public SomeList(ArrayDeque<T> list) {
        this.list = list;
    }

    public SomeList() {
    }

    public ArrayDeque<T> getList() {
        return list;
    }

    public void setList(ArrayDeque<T> list) {
        this.list = list;
    }

    public void addToList(T element){
        list.add(element);
    }

    public void removeTwoFirstAndOneLast(){
        list.removeFirst();
        list.removeLast();
        list.removeLast();

        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "SomeList{" +
                "list=" + list +
                '}';
    }
}
